package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	 Professor findByUser_Username(String userName);	 
}
