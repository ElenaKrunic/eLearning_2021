package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Long>{
	//to do pogledati kako se rade kveriji
	@Query
	List<FinancialCard> getStudentFinancialCard(Long id);
		
}
