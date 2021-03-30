package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.ExamPeriodDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.service.ExamPeriodService;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.PaymentService;

@RestController
@RequestMapping(value="api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService; 
	
	@Autowired
	private FinancialCardService financialCardService; 
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> getAllPayments(){
		
		List<Payment> payments = paymentService.findAll();
		List<PaymentDTO> paymentDto = new ArrayList<>();
		for(Payment payment : payments) {
			paymentDto.add(new PaymentDTO(payment));
		}
		return new ResponseEntity<>(paymentDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id){
		Payment payment = paymentService.findOne(id);
		if(payment == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO){		
		
		FinancialCard financialCard = financialCardService.findOne(paymentDTO.getFinancialCardDTO().getId());

		if (financialCard == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Payment payment = new Payment(); 
		payment.setDateOfPayment(paymentDTO.getPaymentDate());
		payment.setFinancialCard(financialCard);
		//payment.setPaymentAmount(paymentDTO.getPaymentAmount());
		payment.setPaymentDescription(paymentDTO.getPaymentDescription());
		
		
		payment = paymentService.save(payment);
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO){
		
		FinancialCard financialCard = financialCardService.findOne(paymentDTO.getFinancialCardDTO().getId());

		if (financialCard == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Payment payment = paymentService.findOne(paymentDTO.getId()); 
		if (payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		payment.setDateOfPayment(paymentDTO.getPaymentDate());
		payment.setFinancialCard(financialCard);
		//payment.setPaymentAmount(paymentDTO.getPaymentAmount());
		payment.setPaymentDescription(paymentDTO.getPaymentDescription());
		
		
		payment = paymentService.save(payment);
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExamPeriod(@PathVariable Long id){
		Payment payment = paymentService.findOne(id);
		if (payment != null){
			paymentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
