package ftn.tseo.eEducation.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;

public interface PreExamObligationRepository extends JpaRepository<PreexamObligation, Long>{
	
//    List<PreexamObligation> getLatestResults(Student student, Long courseId, java.util.Date date);
	Page<PreexamObligation> findAll(Pageable pageable);
	Page<PreexamObligation> findByLocation(String location, Pageable page);
	List<PreexamObligation> findByLocation(String location, Sort sort);
	List<PreexamObligation> findByStudentIdAndExamId(Long studentId,Long examid);
	
}
