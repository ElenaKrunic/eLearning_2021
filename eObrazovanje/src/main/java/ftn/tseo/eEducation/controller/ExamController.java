package ftn.tseo.eEducation.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.service.ExamService;



@RestController
@RequestMapping(value = "/api/exams")

@CrossOrigin(value="*")
public class ExamController {
	
	@Autowired
	ExamService examService;
	@Autowired
	ExamRepository examRepository;
	
	

	@RequestMapping(value="/passed-exams", method = RequestMethod.GET)

	public ResponseEntity<List<ExamDTO>> getPassedExams(){
		
		List<Exam> exams = examService.findPassedExams();
		List<ExamDTO> examDto = new ArrayList<>();
		for(Exam exam : exams) {
			examDto.add(new ExamDTO(exam));
		}
		return new ResponseEntity<>(examDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/exams", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllExams(
		@RequestParam(required=false) int grade, 
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
	      
		List<Exam> exams = new ArrayList<Exam>(); 

		Pageable paging = PageRequest.of(page, size); 
		
		Page<Exam> pageExams; 
		if (grade == 0) 
			pageExams = examRepository.findAll(paging);
		else 
			pageExams = examRepository.findBygrade(grade, paging); 
		
		exams = pageExams.getContent(); 
		
		Map<String, Object> response = new HashMap<>();
		response.put("exams", exams); 
		response.put("currentPage", pageExams.getNumber()); 
		response.put("totalItems", pageExams.getTotalElements());
		response.put("totalPages", pageExams.getTotalPages());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	} catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

	@RequestMapping(value="/failed-exams", method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getFailedExams(){
		
		List<Exam> exams = examService.findFailedExams();
		List<ExamDTO> examDto = new ArrayList<>();
		for(Exam exam : exams) {
			examDto.add(new ExamDTO(exam));
		}
		return new ResponseEntity<>(examDto, HttpStatus.OK);
	}

	/*@RolesAllowed("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExams() {
		List<Exam> e = examService.findAll();
		// convert exams to DTOs
		List<ExamDTO> eDTO = new ArrayList<>();
		for (Exam ex : e) {
			eDTO.add(new ExamDTO(ex));
		}
		return new ResponseEntity<>(eDTO, HttpStatus.OK);
	}
	*/
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamDTO> getExam(@PathVariable Long id) {
		Exam e = examService.findOne(id);
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ExamDTO(e), HttpStatus.OK);
	}
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<ExamDTO> saveExam(@RequestBody ExamDTO eDTO){
		Exam e = new Exam();
		//treba dodati 
		e.setGrade(eDTO.getGrade());
		e.setPoints(eDTO.getPoints());
		
		e.setExamDate ( (Date) eDTO.getExamDate());
	
		e = examService.save(e);
		return new ResponseEntity<>(new ExamDTO(e), HttpStatus.CREATED);	
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO eDTO){
		//a exam must exist
		Exam e = examService.findOne(eDTO.getId()); 
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		//treba dodati 
		e.setGrade(eDTO.getGrade());
		e.setPoints(eDTO.getPoints());
		
		e.setExamDate ( (Date) eDTO.getExamDate());
	
		e = examService.save(e);
		return new ResponseEntity<>(new ExamDTO(e), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExam(@PathVariable Long id){
		Exam e = examService.findOne(id);
		if (e != null){
			examService.remove(id);
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
