package ftn.tseo.eEducation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.repository.ProfessorRepository;
@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor findOneById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

}
