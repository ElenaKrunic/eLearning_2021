package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	FinancialCardRepository financialCardRepository;

	
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
	

	public List<PaymentDTO> getStudentFinancialCardPayment(Long id){
		List<PaymentDTO> payoutDTO = new ArrayList<PaymentDTO>();
		FinancialCard financialCard=financialCardRepository.findFinancialCardByStudentId(id);
		
		for (Payment p: financialCard.getPayments()) {
			payoutDTO.add(new PaymentDTO(p));
		}
		return payoutDTO;

	}
	
}
