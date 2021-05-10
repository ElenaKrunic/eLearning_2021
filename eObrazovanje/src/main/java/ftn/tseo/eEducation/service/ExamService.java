package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamRegistrationDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.EnrollmentRepository;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PaymentRepository;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;
import javassist.expr.NewArray;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	FinancialCardRepository financialCardRepository;

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
	
	public List<Exam> findPassedExams(){
		return examRepository.findPassedExams();
	}
	
	public List<Exam> findFailedExams(){
		return examRepository.findFailedExams();
	}
	public List<ExamDTO> getCurrentExams(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		List<Exam> allExams = examRepository.findAll();
		List<Exam> currentExams = new ArrayList<>();
		
	
		Date currentDate = new Date(new java.util.Date().getTime());
		

		if(student != null) {
			for (Exam e : allExams) {
				if(e.getExamPeriod().iterator().next().getEndDate().after(currentDate) && 
						e.getExamPeriod().iterator().next().getStartDate().before(currentDate) && e.isStatus()==false) {
					
						currentExams.add(e);
					
				}
			}
			
			
		}
		List<ExamDTO> currentExamsDTOs = new ArrayList<>();
		
		for( Exam examToDTO : currentExams) {
			currentExamsDTOs.add(new ExamDTO(examToDTO));
		}
		
		return currentExamsDTOs;
	
	}
	
	
	//ova klasa
	public List<ExamDTO> findStudentExams(Long id) {
		
		List<Enrollment> enrollment=enrollmentRepository.findByStudentId(id);
		System.out.println("Enrollment"+enrollment);
		List<ExamDTO> examsToDTO=new  ArrayList<ExamDTO>();
		Set<Exam> exams= new  HashSet<Exam>();
		
		for(Enrollment e:enrollment) {
			exams.addAll( e.getExam());
			
		}
		for(Exam ex : exams) {
			examsToDTO.add(new ExamDTO(ex));
		}
		
		return examsToDTO;
	}
		
//	public List<Exam> examsForRegistration(Student student) {
//		
//		Student s = studentRepository.findById(student.getId()).orElse(null); 
//		boolean passed = true; 
//		List<Exam> exams = new ArrayList<>(examRepository.findByStudentAndDate(s, new Date()));
//		List<Exam> examsForRegistration = new ArrayList<>();
//		
//		for(Exam exam : exams) {
//			List<PreexamObligation> preexamObligations = preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new Date());
//			
//			if(((exam.getPreexamObligation().size()) != preexamObligations.size())) 
//					continue;
//			for(PreexamObligation preexamObligation : preexamObligations) {
//				if(!preexamObligation.isPassed()) {
//					passed = false;
//					break;
//				}
//			}
//			
//			if(passed) {
//				examsForRegistration.add(exam);
//			}
//		}
//		return examsForRegistration; 
//	}
	

//	public Long registerExam(Long studentId, Long examId,String location,float points) {
//		
//		Exam exam = examRepository.findById(examId).orElse(null);
//		Student student = studentRepository.findById(studentId).orElse(null);
//		
////		kako cu izvuci za sve ispite naziv kursa kada promenim u jpql
////		String course=exam.getEnrollment().getCourse().getTitle();
//		if(exam != null && student != null) {
//			PreexamObligation examReg = new PreexamObligation();
//			examReg.setExam(exam);
//			examReg.setPreexamObligationStatus(null);
//			examReg.setLocation(location);
//			examReg.setPoints(points);
//			examReg.setPreexamObligationType(null);
//			
//			preexamRepository.save(examReg);
//			
//			float cost = exam.getExamPeriod().iterator().next().getPaymentAmount();
//			FinancialCard transaction = studentRepository.findStudentFinancialCard(studentId);
//			
//			
//			Payment payment=new Payment();
//			payment.setDateOfPayment(new Date(new java.util.Date().getTime()));
//			payment.setPaymentAmount((float) cost);
//			payment.setPaymentDescription("Prijava ispita");
//			payment.setFinancialCard(transaction);
//			
//			paymentRepository.save(payment);
//			
//			transaction.setPayments((Set<Payment>) payment);
//			transaction.setStudent(student);
//			transaction.setTotalCost(cost);
//			transaction.setTotalPayment(cost);
//			
//			transaction.setInitialState(transaction.getInitialState() - cost);
//			financialCardRepository.save(transaction);
//			
//			return examReg.getId();
//		}
//		return  (long) 0;
//	}
//public Exam register(ExamRegistrationDTO dto) {
//		
//		Exam exam = findOne(dto.getId()); 
//		Student student = studentRepository.getOne(dto.getStudentId());
//		
//		if(exam == null || student == null || student.getCardAmount() == null || student.getCardAmount() < 200 || 
//				exam.getPreexamObligation().size() != preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new java.util.Date()).size()) {
//			return null;
//		}
//		
//		//testno 
//		exam.setExamDate(null);
//		exam.setExamPeriod(null);
//		
//		if(student.getCardAmount() == null || student.getCardAmount() < 200) {
//			student.setCardAmount(0d);
//			return null;
//		}
//		
//		if(exam.getPoints() == 0) {
//			exam.setPoints(0F);
//		}
//		
//		student.setCardAmount(student.getCardAmount() - 200);
//		
//		for(PreexamObligation preexamObligation : preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new java.util.Date())) {
//			if(!preexamObligation.isPassed()) {
//				return null; 
//			}
//			preexamObligation.setPassed(true);
//		}
//		
//		return save(exam);
//	}
	
	
}



