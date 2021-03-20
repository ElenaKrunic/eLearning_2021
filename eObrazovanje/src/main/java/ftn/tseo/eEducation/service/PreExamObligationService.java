package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;

@Service
public class PreExamObligationService {

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
}
