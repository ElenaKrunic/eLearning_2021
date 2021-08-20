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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.ExamPeriodDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.DTO.PreexamObligationDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;
import ftn.tseo.eEducation.service.ExamService;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.PaymentService;
import ftn.tseo.eEducation.service.PreExamObligationService;

@RestController
@RequestMapping(value="/api")
public class PreexamObligationController {

	@Autowired
	private PreExamObligationService preexamObligationService; 	
	
	@Autowired
	private PreExamObligationRepository preexamObligationRepository; 	
	
	@Autowired
	private ExamService examService; 	

	@RequestMapping(value="/preexamObligations", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllPreexamObligations(
			@RequestParam(required=false) String location, 
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
		      
			List<PreexamObligation> preexamObligations = new ArrayList<PreexamObligation>(); 

			Pageable paging = PageRequest.of(page, size); 
			
			Page<PreexamObligation> pagePreexamObligations; 
			
			if (location == null) 
				pagePreexamObligations = preexamObligationRepository.findAll(paging);
			else 
				pagePreexamObligations = preexamObligationRepository.findByLocation(location, paging); 
			
			preexamObligations = pagePreexamObligations.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("preexamObligations", preexamObligations); 
			response.put("currentPage", pagePreexamObligations.getNumber()); 
			response.put("totalItems", pagePreexamObligations.getTotalElements());
			response.put("totalPages", pagePreexamObligations.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@RequestMapping(value="preexamObligations/{id}", method=RequestMethod.GET)
	public ResponseEntity<PreexamObligationDTO> getPreexamObligation(@PathVariable Long id){
		PreexamObligation preexamObligation = preexamObligationService.findOne(id);
		if(preexamObligation == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PreexamObligationDTO(preexamObligation), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json", value="/preexamObligations")
	public ResponseEntity<PreexamObligationDTO> savePreexamObligation(@RequestBody PreexamObligationDTO dto){		
		
		//Exam exam = examService.findOne(dto.getExam().getId());

		PreexamObligation preexamObligation = new PreexamObligation();
		preexamObligation.setDateOfObligation(dto.getDateOfObligation());
		preexamObligation.setLocation(dto.getLocation());
		//preexamObligation.setPassed(dto.isPassed());
		//preexamObligation.setPoints(dto.getPoints());
		//preexamObligation.setExam(exam);
		
		preexamObligation = preexamObligationService.save(preexamObligation);
		return new ResponseEntity<>(new PreexamObligationDTO(preexamObligation), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/preexamObligations/{id}")
	public ResponseEntity<PreexamObligationDTO> updatePreexamObligation(@RequestBody PreexamObligationDTO dto, @PathVariable("id") Long id){		
		
		PreexamObligation preeexam = preexamObligationService.findOne(id);

		preeexam.setDateOfObligation(dto.getDateOfObligation());
		preeexam.setLocation(dto.getLocation());
		//preexamObligation.setPassed(dto.isPassed());
		//preexamObligation.setPoints(dto.getPoints());
		//preexamObligation.setExam(exam);
		
		preeexam = preexamObligationService.save(preeexam);
		return new ResponseEntity<>(new PreexamObligationDTO(preeexam), HttpStatus.CREATED);	
	}
	

	@RequestMapping(value="/preexamObligations/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePreexamObligation(@PathVariable Long id){
		PreexamObligation preexam = preexamObligationService.findOne(id);
		if (preexam != null){
			preexamObligationService.remove(id);
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
