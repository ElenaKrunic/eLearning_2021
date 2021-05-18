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
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.StudentService;

@RestController
@RequestMapping(value="api/financialCard")
public class FinancialCardController {
	
	@Autowired
	private FinancialCardService financialCardService; 
	
	@Autowired
	private StudentService studentService; 

	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<FinancialCardDTO>> getAllFinancialCards(){
		
		List<FinancialCard> financialCards = financialCardService.findAll();
		List<FinancialCardDTO> financialCardDto = new ArrayList<>();
		for(FinancialCard financialCard : financialCards) {
			financialCardDto.add(new FinancialCardDTO(financialCard));
		}
		return new ResponseEntity<>(financialCardDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<FinancialCardDTO> getFinancialCard(@PathVariable Long id){
		FinancialCard financialCard = financialCardService.findOne(id);
		if(financialCard == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new FinancialCardDTO(financialCard), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{studentId}", consumes="application/json")
	public ResponseEntity<FinancialCardDTO> saveFinancialCard(@RequestBody FinancialCardDTO financialCardDto, @PathVariable("studentId") Long studentId){		
		
		Student student = studentService.findOne(studentId); 
		
		if(student == null) {
			return new ResponseEntity<FinancialCardDTO>(HttpStatus.NOT_FOUND);
		}
		
		FinancialCard financialCard = new FinancialCard(); 
		
		financialCard.setInitialState(financialCardDto.getInitialState());
		financialCard.setTotalCost(financialCardDto.getTotalCost());
		financialCard.setTotalPayment(financialCardDto.getTotalPayment());
		financialCard.setStudent(student);
		
		financialCard = financialCardService.save(financialCard);
		return new ResponseEntity<>(new FinancialCardDTO(financialCard), HttpStatus.CREATED);	
	}
	

	@RequestMapping(method=RequestMethod.PUT,value="/{id}", consumes="application/json")
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

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFinancialCard(@PathVariable Long id){
		FinancialCard financialCard = financialCardService.findOne(id);
		if (financialCard != null){
			financialCardService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
