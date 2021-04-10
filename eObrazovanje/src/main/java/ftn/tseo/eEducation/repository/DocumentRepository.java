package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Document;


public interface DocumentRepository extends JpaRepository<Document, Long>{
	 @Query(value = "SELECT d FROM Student s LEFT OUTER JOIN Document d WHERE s.id = :id")
	 List<Document> getDocumentsForStudents(Long id);
	    
}
