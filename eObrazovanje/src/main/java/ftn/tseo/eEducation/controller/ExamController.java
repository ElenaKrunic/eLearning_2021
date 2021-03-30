package ftn.tseo.eEducation.controller;

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
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.service.ExamService;



@RestController
@RequestMapping(value = "api/exams")
@CrossOrigin(value="*")
public class ExamController {
	
	@Autowired
	ExamService examService;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExams() {
		List<Exam> e = examService.findAll();
		// convert courses to DTOs
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
	
}
