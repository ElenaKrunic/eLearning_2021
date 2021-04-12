package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Long>{
	
	List<FinancialCard> findFinancialCardByStudentId(Long id); 
	
	@Query(value = "SELECT f FROM Student s LEFT OUTER JOIN FinancialCard f WHERE s.id = :id")
	FinancialCard findStudentFinancialCard(Long id);
	    
}
