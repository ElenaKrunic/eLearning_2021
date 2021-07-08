package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamPeriodDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.repository.ExamPeriodRepository;
import ftn.tseo.eEducation.service.ExamPeriodService;
import ftn.tseo.eEducation.service.ExamService;
/**
 * Implementiran API sa metodama koje nude osnovne CRUD funkcionalnosti prilikom rada sa ispitnim rokom/vima 
 * @author Elena Krunic 
 *
 */
@RestController
@RequestMapping(value="/api")
public class ExamPeriodController {

	@Autowired
	private ExamPeriodService examPeriodService; 
	
	@Autowired 
	private ExamPeriodRepository examPeriodRepository; 
		
	/*
	@RequestMapping(value="/examPeriods", method = RequestMethod.GET)
	public ResponseEntity<List<ExamPeriodDTO>> getAllExamPeriods(){
		
		List<ExamPeriod> examPeriods = examPeriodService.findAll();
		List<ExamPeriodDTO> examPeriodDto = new ArrayList<>();
		for(ExamPeriod examPeriod : examPeriods) {
			examPeriodDto.add(new ExamPeriodDTO(examPeriod));
		}
		return new ResponseEntity<>(examPeriodDto, HttpStatus.OK);
	}
	*/
	
	
	/*
	@RequestMapping(value="/examPeriods", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllExamPeriods(
			@RequestParam(required=false) String name, 
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="3") int size) {
		
		try {
			List<ExamPeriod> examPeriods = new ArrayList<ExamPeriod>(); 
			Pageable paging = PageRequest.of(page, size); 
			
			Page<ExamPeriod> pageExamPeriods; 
			if (name == null) 
				pageExamPeriods = examPeriodRepository.findAll(paging);
			else 
				pageExamPeriods = examPeriodRepository.findByName(name, paging); 
			
			examPeriods = pageExamPeriods.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("examPeriods", examPeriods); 
			response.put("currentPage", pageExamPeriods.getNumber()); 
			response.put("totalItems", pageExamPeriods.getTotalElements());
			response.put("totalPages", pageExamPeriods.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	@RequestMapping(value="/examPeriods", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllExamPeriods(
			@RequestParam(required=false) String name, 
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
		      
			List<ExamPeriod> examPeriods = new ArrayList<ExamPeriod>(); 

			Pageable paging = PageRequest.of(page, size); 
			
			Page<ExamPeriod> pageExamPeriods; 
			if (name == null) 
				pageExamPeriods = examPeriodRepository.findAll(paging);
			else 
				pageExamPeriods = examPeriodRepository.findByName(name, paging); 
			
			examPeriods = pageExamPeriods.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("examPeriods", examPeriods); 
			response.put("currentPage", pageExamPeriods.getNumber()); 
			response.put("totalItems", pageExamPeriods.getTotalElements());
			response.put("totalPages", pageExamPeriods.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value="examPeriods/{id}", method=RequestMethod.GET)
	public ResponseEntity<ExamPeriodDTO> getExamPeriod(@PathVariable Long id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/examPeriods", consumes="application/json")
	public ResponseEntity<ExamPeriodDTO> saveExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO){		
		
		ExamPeriod examPeriod = new ExamPeriod();
		examPeriod.setStartDate(examPeriodDTO.getStartDate());
		examPeriod.setEndDate(examPeriodDTO.getEndDate());
		examPeriod.setName(examPeriodDTO.getName());
		examPeriod.setPaymentAmount(examPeriodDTO.getPaymentAmount());
		
		examPeriod = examPeriodService.save(examPeriod);
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.CREATED);	
	}
	
	
	@PutMapping(value="/examPeriods/{examId}", consumes="application/json")
	public ResponseEntity<ExamPeriodDTO> updateExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO, @PathVariable("examId") Long id){
		
		ExamPeriod examPeriod = examPeriodService.findOne(examPeriodDTO.getId()); 
		if (examPeriod == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		examPeriod.setStartDate(examPeriodDTO.getStartDate());
		examPeriod.setEndDate(examPeriodDTO.getEndDate());
		examPeriod.setName(examPeriodDTO.getName());
		examPeriod.setPaymentAmount(examPeriodDTO.getPaymentAmount());
				
		examPeriod = examPeriodService.save(examPeriod);
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/examPeriods/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExamPeriod(@PathVariable Long id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if (examPeriod != null){
			examPeriodService.remove(id);
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
