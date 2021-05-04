package ftn.tseo.eEducation.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.service.ExamService;



@RestController
@RequestMapping(value = "api/exams")
@CrossOrigin(value="*")
public class ExamController {
	
	@Autowired
	ExamService examService;
	
	
	@RequestMapping(value="/passed-exams", method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getPassedExams(){
		
		List<Exam> exams = examService.findPassedExams();
		List<ExamDTO> examDto = new ArrayList<>();
		for(Exam exam : exams) {
			examDto.add(new ExamDTO(exam));
		}
		return new ResponseEntity<>(examDto, HttpStatus.OK);
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
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamDTO> getExam(@PathVariable Long id) {
		Exam e = examService.findOne(id);
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ExamDTO(e), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
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
	
}
