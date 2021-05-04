package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamPeriodDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.service.ExamPeriodService;
import ftn.tseo.eEducation.service.ExamService;

@RestController
@RequestMapping(value="api/examPeriod")
public class ExamPeriodController {

	@Autowired
	private ExamPeriodService examPeriodService; 
	
	private ExamService examService; 
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<ExamPeriodDTO>> getAllExamPeriods(){
		
		List<ExamPeriod> examPeriods = examPeriodService.findAll();
		List<ExamPeriodDTO> examPeriodDto = new ArrayList<>();
		for(ExamPeriod examPeriod : examPeriods) {
			examPeriodDto.add(new ExamPeriodDTO(examPeriod));
		}
		return new ResponseEntity<>(examPeriodDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ExamPeriodDTO> getStudent(@PathVariable Long id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.OK);
	}
	
	//@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	@PostMapping(value="/{examId}", consumes="application/json")
	public ResponseEntity<ExamPeriodDTO> saveExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO, @PathVariable("examId") Long id){		
		
		Exam exam = examService.findOne(id);
		
		if(exam == null) {
			return new ResponseEntity<ExamPeriodDTO>(HttpStatus.NOT_FOUND);
		}
		
		ExamPeriod examPeriod = new ExamPeriod();
		examPeriod.setStartDate(examPeriodDTO.getStartDate());
		examPeriod.setEndDate(examPeriodDTO.getEndDate());
		examPeriod.setName(examPeriodDTO.getName());
		examPeriod.setPaymentAmount(examPeriodDTO.getPaymentAmount());
		
		exam.addExamPeriod(examPeriod);
		exam = examService.save(exam);
		
		examPeriod = examPeriodService.save(examPeriod);
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{examId}", consumes="application/json")
	public ResponseEntity<ExamPeriodDTO> updateExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO, @PathVariable("examId") Long id){
		
		Exam exam = examService.findOne(id); 
		
		if(exam == null) {
			return new ResponseEntity<ExamPeriodDTO>(HttpStatus.NOT_FOUND);
		}
		
		ExamPeriod examPeriod = examPeriodService.findOne(examPeriodDTO.getId()); 
		if (examPeriod == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		examPeriod.setStartDate(examPeriodDTO.getStartDate());
		examPeriod.setEndDate(examPeriodDTO.getEndDate());
		examPeriod.setName(examPeriodDTO.getName());
		examPeriod.setPaymentAmount(examPeriodDTO.getPaymentAmount());
		
		exam.addExamPeriod(examPeriod);
		exam = examService.save(exam);
		
		examPeriod = examPeriodService.save(examPeriod);
		return new ResponseEntity<>(new ExamPeriodDTO(examPeriod), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExamPeriod(@PathVariable Long id){
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if (examPeriod != null){
			examPeriodService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//implementirati metodu za pretragu ispitnog roka po nazivu mjeseca (name) --> Elena 
	
}
