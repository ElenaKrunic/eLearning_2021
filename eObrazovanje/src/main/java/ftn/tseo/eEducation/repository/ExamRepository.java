package ftn.tseo.eEducation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;


public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	@Query(value= "Select e from Exam e where e.status=true")
	List<Exam> findPassedExams();
	
	@Query(value= "Select e from Exam e where e.status=false")
	List<Exam> findFailedExams();
	
//	@Query("Select e from Exam e where e.examPeriod.startDate > :examDate" + "and :student = e.enrollment.student"
//	+ "and not exists (select p from PreexamObligation p where p.exam = e and p.student = :student) "
//	+ "and not exists (select p from PreexamObligation p where p.student = :student and p.exam.enrollment.course = e.enrollment.course and p.passed = true)")
//	List<Exam> findByStudentAndDate(@Param("student") Student student, @Param("examDate") Date date);
//	
//	   Long registeredExam(Long studentId,Long examId,String location,float points);
//	    
	Page<Exam> findAll(Pageable pageable);
	Page<Exam> findBygrade(int grade, Pageable page);
	List<Exam> findBygrade(int grade, Sort sort);
	//Elena zakomentarisala 
	//List<Exam> findProfessorExams(Long id);
		
}

	
	
