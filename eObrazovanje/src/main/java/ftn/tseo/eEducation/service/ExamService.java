package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.ExamRegistrationDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	TeachingRepository teachingRepository;
	
	@Autowired 
	StudentRepository studentRepository; 
	
	@Autowired
	PreExamObligationRepository preexamRepository;
	
	public Exam findOne(Long id) {
		return examRepository.findById(id).orElse(null);
	}


	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	public void remove(Long id) {
		examRepository.deleteById(id);
	}
	
	public List<Exam> examsForRegistration(Student student) {
		
		Student s = studentRepository.findById(student.getId()).orElse(null); 
		boolean passed = true; 
		List<Exam> exams = new ArrayList<>(examRepository.findByStudentAndDate(s, new Date()));
		List<Exam> examsForRegistration = new ArrayList<>();
		
		for(Exam exam : exams) {
			List<PreexamObligation> preexamObligations = preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new Date());
			
			if(((exam.getPreexamObligation().size()) != preexamObligations.size())) 
					continue;
			for(PreexamObligation preexamObligation : preexamObligations) {
				if(!preexamObligation.isPassed()) {
					passed = false;
					break;
				}
			}
			
			if(passed) {
				examsForRegistration.add(exam);
			}
		}
		return examsForRegistration; 
	}
	
public Exam register(ExamRegistrationDTO dto) {
		
		Exam exam = findOne(dto.getId()); 
		Student student = studentRepository.getOne(dto.getStudentId());
		
		if(exam == null || student == null || student.getCardAmount() == null || student.getCardAmount() < 200 || 
				exam.getPreexamObligation().size() != preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new java.util.Date()).size()) {
			return null;
		}
		
		//testno 
		exam.setExamDate(null);
		exam.setExamPeriod(null);
		
		if(student.getCardAmount() == null || student.getCardAmount() < 200) {
			student.setCardAmount(0d);
			return null;
		}
		
		if(exam.getPoints() == 0) {
			exam.setPoints(0F);
		}
		
		student.setCardAmount(student.getCardAmount() - 200);
		
		for(PreexamObligation preexamObligation : preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new java.util.Date())) {
			if(!preexamObligation.isPassed()) {
				return null; 
			}
			preexamObligation.setPassed(true);
		}
		
		return save(exam);
	}
}
