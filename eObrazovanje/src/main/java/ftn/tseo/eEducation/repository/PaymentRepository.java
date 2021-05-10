package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ftn.tseo.eEducation.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
