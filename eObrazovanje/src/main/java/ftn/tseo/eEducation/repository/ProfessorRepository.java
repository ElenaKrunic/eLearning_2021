package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	 List<Professor> findAllByLastName(String lastName);
}
