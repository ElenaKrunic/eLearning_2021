package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.tseo.eEducation.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	@Query(value = "SELECT p FROM Student s LEFT OUTER JOIN FinancialCard fc LEFT OUTER JOIN Payment p WHERE fc.id=p.id and s.id= :id")
	List<Payment> findPaymentForFinancialCard(@Param("id")Long id);
	
	
}
