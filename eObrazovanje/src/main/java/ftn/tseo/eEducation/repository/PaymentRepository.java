package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ftn.tseo.eEducation.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
}
