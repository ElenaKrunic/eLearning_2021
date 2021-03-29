package ftn.tseo.eEducation.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;

public interface PreExamObligationRepository extends JpaRepository<PreexamObligation, Long>{
	
    List<PreexamObligation> getLatestResults(Student student, Long courseId, java.util.Date date);

	
}
