package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.ProfessorRepository;
@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor findOneById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}
	


	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}

	public void remove(Long id) {
		professorRepository.deleteById(id);
	}
	
	public Professor findUserByUsername(String username) {
		return professorRepository.findByUser_Username(username);
	}
	
	
	
	
	
	

}
