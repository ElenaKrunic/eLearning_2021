package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.ProfessorDTO;
import ftn.tseo.eEducation.DTO.StudentDTO;
import ftn.tseo.eEducation.DTO.TeachingDTO;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.Teaching;
import ftn.tseo.eEducation.service.ProfessorService;
import rs.ac.uns.ftn.kts.students.web.dto.EnrollmentDTO;


@RestController
@RequestMapping("api/professors")
@CrossOrigin(value = "*")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@RequestMapping( value="/all",method = RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> getProfessors() {
		List<Professor> professors = professorService.findAll();
		// convert professors to DTOs
		List<ProfessorDTO> pDTO = new ArrayList<>();
		for (Professor c : professors) {
			pDTO.add(new ProfessorDTO(c));
		}
		return new ResponseEntity<>(pDTO, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfessorDTO> getProfessor(@PathVariable Long id) {
		Professor p = professorService.findOneById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ProfessorDTO(p), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ProfessorDTO> saveProfessor(@RequestBody ProfessorDTO pDTO){		
		Professor p = new Professor();
		
		
		p = professorService.save(p);
		return new ResponseEntity<>(new ProfessorDTO(p), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO pDTO){
		//a professor must exist
		Professor p = professorService.findOneById(pDTO.getId()); 
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		p = professorService.save(p);
		return new ResponseEntity<>(new ProfessorDTO(p), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProfessor(@PathVariable Long id){
		Professor p = professorService.findOneById(id);
		if (p != null){
			professorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
