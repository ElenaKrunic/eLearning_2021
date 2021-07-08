package ftn.tseo.eEducation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.TypeOfFinancing;
import ftn.tseo.eEducation.repository.TypeOfFinancingRepository;
@Service
public class TypeOfFinancingService {
	
	@Autowired
	TypeOfFinancingRepository typeOfFinancingRepo;
	
	public TypeOfFinancing findOne(Long id) {
		return typeOfFinancingRepo.findById(id).orElse(null);
	}
	

}
