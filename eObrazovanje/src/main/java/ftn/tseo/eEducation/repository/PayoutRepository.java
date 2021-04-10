package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.model.PayOut;

public interface PayoutRepository extends JpaRepository<PayOut, Long> {
//	@Query(value = "SELECT p FROM Student s LEFT OUTER JOIN FinancialCard fc LEFT OUTER JOIN Payout p WHERE s.id= :id")
//	List<PayOut> getStudentFinancialCardPayout(Long id);
//	 List<PayoutDTO> getStudentFinancialCardPayout(Long id);
//	
}
