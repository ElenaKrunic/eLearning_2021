package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.tseo.eEducation.model.PreexamObligationStatus;
import ftn.tseo.eEducation.repository.PreexamObligationStatusRepository;

public class PreexamObligationStatusService {
	
	@Autowired 
	private PreexamObligationStatusRepository preexamObligationStatusRepository; 
	

	public PreexamObligationStatus findOne(Long id) {
		return preexamObligationStatusRepository.findById(id).orElse(null); 
	}
	
	public List<PreexamObligationStatus> findAll(){
		return preexamObligationStatusRepository.findAll(); 
	}
	
	public PreexamObligationStatus save(PreexamObligationStatus preexamObligationStatus) {
		return preexamObligationStatusRepository.save(preexamObligationStatus);
	}
	
	public void remove(Long id) {
		preexamObligationStatusRepository.deleteById(id);
	}

}
