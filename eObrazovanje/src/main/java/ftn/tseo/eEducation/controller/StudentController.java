package ftn.tseo.eEducation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.service.ExamService;
import ftn.tseo.eEducation.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService; 
	
	@Autowired
	private ExamService examService; 
	
	@Autowired 
	private PreexamObligation preexamObligationService; 
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamDTO> registerExam(@RequestBody ExamDTO dto) {
		
		Exam exam = new Exam(); 
		exam = examService.register(dto);
		
		if(exam == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.CREATED);
	}
	
}
