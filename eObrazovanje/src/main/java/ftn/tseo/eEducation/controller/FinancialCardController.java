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
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.StudentService;

/**
 * Implementiran API sa metodama koje nude osnovne CRUD funkcionalnosti prilikom rada sa finansijskom karticom/ama
 * @author Elena Krunic 
 *
 */
@RestController
@RequestMapping(value="/api")
public class FinancialCardController {
	
	@Autowired
	private FinancialCardService financialCardService; 
	
	@Autowired
	private FinancialCardRepository financialCardRepository;
		
	@RequestMapping(value="/financialCards", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllFinancialCards(
			@RequestParam(defaultValue="0") float totalCost, 
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
		      
			List<FinancialCard> financialCards = new ArrayList<FinancialCard>(); 

			Pageable paging = PageRequest.of(page, size); 
			
			Page<FinancialCard> pageFinancialCards; 
			if (totalCost == 0) 
				pageFinancialCards = financialCardRepository.findAll(paging);
			else 
				pageFinancialCards = financialCardRepository.findByTotalCost(totalCost, paging); 
			
			financialCards = pageFinancialCards.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("financialCards", financialCards); 
			response.put("currentPage", pageFinancialCards.getNumber()); 
			response.put("totalItems", pageFinancialCards.getTotalElements());
			response.put("totalPages", pageFinancialCards.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	@RequestMapping(value="/financialCards", method = RequestMethod.GET)
	public ResponseEntity<List<FinancialCardDTO>> getAllFinancialCards(){
		
		List<FinancialCard> financialCards = financialCardService.findAll();
		List<FinancialCardDTO> financialCardDto = new ArrayList<>();
		for(FinancialCard financialCard : financialCards) {
			financialCardDto.add(new FinancialCardDTO(financialCard));
		}
		return new ResponseEntity<>(financialCardDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/financialCards/{id}", method=RequestMethod.GET)
	public ResponseEntity<FinancialCardDTO> getFinancialCard(@PathVariable Long id){
		FinancialCard financialCard = financialCardService.findOne(id);
		if(financialCard == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new FinancialCardDTO(financialCard), HttpStatus.OK);
	}
	*/
	
	@RequestMapping(method=RequestMethod.POST,value="/financialCards", consumes="application/json")
	public ResponseEntity<FinancialCardDTO> saveFinancialCard(@RequestBody FinancialCardDTO financialCardDto){		
		
		/*
		Student student = studentService.findOne(studentId); 
		
		if(student == null) {
			return new ResponseEntity<FinancialCardDTO>(HttpStatus.NOT_FOUND);
		}
		*/
		
		FinancialCard financialCard = new FinancialCard(); 
		
		financialCard.setInitialState(financialCardDto.getInitialState());
		financialCard.setTotalCost(financialCardDto.getTotalCost());
		financialCard.setTotalPayment(financialCardDto.getTotalPayment());
		//financialCard.setStudent(student);
		
		financialCard = financialCardService.save(financialCard);
		return new ResponseEntity<>(new FinancialCardDTO(financialCard), HttpStatus.CREATED);	
	}
	

	@RequestMapping(method=RequestMethod.PUT,value="/financialCards/{id}", consumes="application/json")
	public ResponseEntity<FinancialCardDTO> updateFinancialCard(@RequestBody FinancialCardDTO financialCardDto, @PathVariable("id") Long id){		

		FinancialCard financialCard = financialCardService.findOne(id); 
		if (financialCard == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		financialCard.setInitialState(financialCardDto.getInitialState());
		financialCard.setTotalCost(financialCardDto.getTotalCost());
		financialCard.setTotalPayment(financialCardDto.getTotalPayment());
		
		financialCard = financialCardService.save(financialCard);
		return new ResponseEntity<>(new FinancialCardDTO(financialCard), HttpStatus.OK);	
	}

	@RequestMapping(value="/financialCards/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFinancialCard(@PathVariable Long id){
		FinancialCard financialCard = financialCardService.findOne(id);
		if (financialCard != null){
			financialCardService.remove(id);
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
