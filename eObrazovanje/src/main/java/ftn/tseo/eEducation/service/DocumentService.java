package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.DocumentDTO;
import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.repository.DocumentRepository;
@Service
public class DocumentService {
	@Autowired
	DocumentRepository documentRepository;

	public Document findOne(Long id) {
		return documentRepository.findById(id).orElse(null);
	}

	public List<Document> findAll() {
		return documentRepository.findAll();
	}

	public Document save(Document doc) {
		return documentRepository.save(doc);
	}

	public void remove(Long id) {
		documentRepository.deleteById(id);
	}
	public List<DocumentDTO> findDocumentsForStudents(Long id){
		List<DocumentDTO> documentForStudent = new ArrayList<>();
		List<Document> documents=documentRepository.findDocumentByStudentId(id);
		if(documents!=null) {
			for (Document d: documents) {
				documentForStudent.add(new DocumentDTO(d));
			}
		}
		System.out.println("Documents for student"+documentForStudent);
		return documentForStudent;
	}
	

}
