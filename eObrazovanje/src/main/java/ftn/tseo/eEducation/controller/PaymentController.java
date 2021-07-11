package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.ExamPeriodDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PaymentRepository;
import ftn.tseo.eEducation.service.ExamPeriodService;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.PaymentService;

/**
 * Implementiran API sa metodama koje nude osnovne CRUD funkcionalnosti prilikom rada sa placanjem/ima 
 * @author Elena Krunic 
 *
 */
@RestController
@RequestMapping(value="/api")
public class PaymentController {

	@Autowired
	private PaymentService paymentService; 
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@RequestMapping(value="/payments", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllFinancialCards(
			@RequestParam(defaultValue="0") float paymentAmount, 
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="3") int size,
			@RequestParam(defaultValue="id, desc") String[] sort) {
		
		try {
			
			 List<Order> orders = new ArrayList<Order>();

		      if (sort[0].contains(",")) {
		        // will sort more than 2 fields
		        // sortOrder="field, direction"
		        for (String sortOrder : sort) {
		          String[] _sort = sortOrder.split(",");
		          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
		        }
		      } else {
		        // sort=[field, direction]
		        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
		      }
		      
			List<Payment> payments = new ArrayList<Payment>();

			Pageable paging = PageRequest.of(page, size); 
			
			Page<Payment> pagePayments;
			
			if (paymentAmount == 0) 
				pagePayments = paymentRepository.findAll(paging);
			else 
				pagePayments = paymentRepository.findByPaymentAmount(paymentAmount, paging); 
			
			payments = pagePayments.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("payments", payments); 
			response.put("currentPage", pagePayments.getNumber()); 
			response.put("totalItems", pagePayments.getTotalElements());
			response.put("totalPages", pagePayments.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	/*
	@RequestMapping(value="/payments", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> getAllPayments(){
		
		List<Payment> payments = paymentService.findAll();
		List<PaymentDTO> paymentDto = new ArrayList<>();
		for(Payment payment : payments) {
			paymentDto.add(new PaymentDTO(payment));
		}
		return new ResponseEntity<>(paymentDto, HttpStatus.OK);
	}
	*/
	
	@RequestMapping(value="payments/{id}", method=RequestMethod.GET)
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id){
		Payment payment = paymentService.findOne(id);
		if(payment == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/payments", consumes="application/json")
	public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO){		
		/*
		FinancialCard financialCard = financialCardService.findOne(financialCardId);

		if (financialCard == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		*/
		Payment payment = new Payment(); 
		payment.setDateOfPayment(paymentDTO.getPaymentDate());
		//payment.setFinancialCard(financialCard);
		payment.setPaymentAmount(paymentDTO.getPaymentAmount());
		payment.setPaymentDescription(paymentDTO.getPaymentDescription());
		
		payment = paymentService.save(payment);
		
		System.out.println(payment.getDateOfPayment());
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/payments/{id}", consumes="application/json")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO, @PathVariable("id") Long id){
		
		Payment payment = paymentService.findOne(id); 
		if (payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		payment.setDateOfPayment(paymentDTO.getPaymentDate());
		payment.setPaymentAmount(paymentDTO.getPaymentAmount());
		payment.setPaymentDescription(paymentDTO.getPaymentDescription());
		
		payment = paymentService.save(payment);
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/payments/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExamPeriod(@PathVariable Long id){
		Payment payment = paymentService.findOne(id);
		if (payment != null){
			paymentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//helper method 
		private Sort.Direction getSortDirection(String direction) {
		    if (direction.equals("asc")) {
		      return Sort.Direction.ASC;
		    } else if (direction.equals("desc")) {
		      return Sort.Direction.DESC;
		    }

		    return Sort.Direction.ASC;
		  }
	
}
