package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	 	Professor findByUser_Username(String username);	
	 	Page<Professor> findAll(Pageable pageable);
		Page<Professor> findByFirstName(String firstName, Pageable page);
		List<Professor> findByFirstName(String firstName, Sort sort);
}
