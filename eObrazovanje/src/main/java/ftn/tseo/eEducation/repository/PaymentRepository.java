package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	Page<Payment> findAll(Pageable pageable); 
	Page<Payment> findByPaymentAmount(float paymentAmount,Pageable pageable); 
	List<Payment> findByPaymentAmount(float paymentAmount, Sort sort);
}
