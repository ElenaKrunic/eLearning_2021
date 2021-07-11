package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Long>{
	
	FinancialCard findFinancialCardByStudentId(Long id);
	Page<FinancialCard> findAll(Pageable pageable); 
	Page<FinancialCard> findByTotalCost(float totalCost,Pageable pageable); 
	List<FinancialCard> findByTotalCost(float totalCost, Sort sort);

}
