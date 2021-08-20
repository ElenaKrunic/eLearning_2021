package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.EnrollmentDTO;
import ftn.tseo.eEducation.DTO.PreexamObligationDTO;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;

@Service
public class PreExamObligationService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	PreExamObligationRepository preExamObligationRepository; 
	
	public PreexamObligation findOne(Long id) {
		return preExamObligationRepository.findById(id).orElse(null);
	}

	public List<PreexamObligation> findAll() {
		return preExamObligationRepository.findAll();
	}

	public PreexamObligation save(PreexamObligation course) {
		return preExamObligationRepository.save(course);
	}

	public void remove(Long id) {
		preExamObligationRepository.deleteById(id);
	
	}
	
	public List<PreexamObligationDTO> findPreexamObligationsForStudent(Long studentId,Long examid){
		List<PreexamObligationDTO> preexamDTO = new ArrayList<>();
		List<PreexamObligation> preexam=preExamObligationRepository.findByStudentIdAndExamId(studentId, examid);
		System.out.println("Preexam service  "+preexam);
		
		if(preexam!=null) {
			for (PreexamObligation p: preexam) {
				preexamDTO.add(new PreexamObligationDTO(p));
			}
		
		}
		return preexamDTO;
		
	}
}
