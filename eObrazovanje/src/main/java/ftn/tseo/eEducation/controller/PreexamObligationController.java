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

import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.DTO.PreexamObligationDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.service.ExamService;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.PaymentService;
import ftn.tseo.eEducation.service.PreExamObligationService;

@RestController
@RequestMapping(value="api/preexamObligation")
public class PreexamObligationController {

	@Autowired
	private PreExamObligationService preexamObligationService; 	
	
	@Autowired
	private ExamService examService; 	

	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PreexamObligationDTO>> getAllPayments(){
		
		List<PreexamObligation> preexamObligations = preexamObligationService.findAll();
		List<PreexamObligationDTO> dto = new ArrayList<>();
		for(PreexamObligation preexamObligation : preexamObligations) {
			dto.add(new PreexamObligationDTO(preexamObligation));
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PreexamObligationDTO> getPayment(@PathVariable Long id){
		PreexamObligation preexamObligation = preexamObligationService.findOne(id);
		if(preexamObligation == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PreexamObligationDTO(preexamObligation), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PreexamObligationDTO> savePreexamObligation(@RequestBody PreexamObligationDTO dto){		
		
		Exam exam = examService.findOne(dto.getExam().getId());

		
		PreexamObligation preexamObligation = new PreexamObligation();
		preexamObligation.setDateOfObligation(dto.getDateOfObligation());
		preexamObligation.setLocation(dto.getLocation());
		preexamObligation.setPassed(dto.isPassed());
		preexamObligation.setPoints(dto.getPoints());
		preexamObligation.setExam(exam);
		
		preexamObligation = preexamObligationService.save(preexamObligation);
		return new ResponseEntity<>(new PreexamObligationDTO(preexamObligation), HttpStatus.CREATED);	
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePreexamObligation(@PathVariable Long id){
		PreexamObligation preexam = preexamObligationService.findOne(id);
		if (preexam != null){
			preexamObligationService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
