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

import ftn.tseo.eEducation.DTO.DocumentDTO;
import ftn.tseo.eEducation.DTO.StudentDTO;
import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.DocumentType;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.TypeOfFinancing;
import ftn.tseo.eEducation.service.DocumentService;
import ftn.tseo.eEducation.service.StudentService;

@RestController
@RequestMapping(value = "api/documents")
public class DocumentController {

	@Autowired
	private DocumentService dService;
	@Autowired
	private StudentService studentService;
	
	StudentDTO studentDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DocumentDTO>> getDocuments() {
		List<Document> doc= dService.findAll();
		// convert documents to DTOs
		List<DocumentDTO> dDTO = new ArrayList<>();
		for (Document d : doc) {
			dDTO.add(new DocumentDTO(d));
		}
		return new ResponseEntity<>(dDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DocumentDTO> getDocument(@PathVariable Long id) {
		Document d = dService.findOne(id);
		if (d == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DocumentDTO(d), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DocumentDTO> saveDocument(@RequestBody DocumentDTO dDTO) {
		Student student = studentService.findOne(dDTO.getStudentDTO().getId());
		Document d = new Document();
		d.setTitle(dDTO.getTitle());
		d.setUrl(dDTO.getUrl());
		d.setStudent(student);
		//d.setDocumentType(dDTO.getDocumentType());
		d= dService.save(d);
		return new ResponseEntity<>(new DocumentDTO(d), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO dDTO) {

		Document d = dService.findOne(dDTO.getId());
		if (d == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(dDTO.getStudentDTO().getId());
		d.setTitle(dDTO.getTitle());
		d.setUrl(dDTO.getUrl());
		d.setStudent(student);
		//d.setDocumentType(null);
		

		d = dService.save(d);
		return new ResponseEntity<>(new DocumentDTO(d), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
		Document d = dService.findOne(id);
		if (d != null) {
			dService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
