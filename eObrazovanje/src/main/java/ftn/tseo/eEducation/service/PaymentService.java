package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	private List<Payment> getFinancialCardPayment(Long id){
		List<Payment> payments = new ArrayList<Payment>();
		for (Payment p: paymentRepository.getFinancialCardPayment(id)) {
			payments.add(p);
		}
		return payments;
	}
	
	public Payment findOne(Long id) {
		return paymentRepository.findById(id).orElse(null); 
	}
	
	public List<Payment> findAll(){
		return paymentRepository.findAll(); 
	}
	
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public void remove(Long id) {
		paymentRepository.deleteById(id);
	}
}