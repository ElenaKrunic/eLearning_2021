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
	public List<DocumentDTO> getDocumentsForStudents(Long id){
		List<DocumentDTO> documentForStudent = new ArrayList<DocumentDTO>();
		for (Document d: documentRepository.getDocumentsForStudents(id)) {
			documentForStudent.add(new DocumentDTO(d));
		}
		return documentForStudent;
	}

}
