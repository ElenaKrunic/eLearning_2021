package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.PreexamObligation;

public interface PreExamObligationRepository extends JpaRepository<PreexamObligation, Long>{
	
	
}
