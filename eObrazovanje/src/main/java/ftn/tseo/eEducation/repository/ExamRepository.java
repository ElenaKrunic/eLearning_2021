package ftn.tseo.eEducation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.Student;

public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	@Query("Select e from Exam e where e.examPeriod.startDate > :examDate" + "and :student = e.enrollment.student"
	+ "and not exists (select p from PreexamObligation p where p.exam = e and p.student = :student) "
	+ "and not exists (select p from PreexamObligation p where p.student = :student and p.exam.enrollment.course = e.enrollment.course and p.passed = true)")
	List<Exam> findByStudentAndDate(@Param("student") Student student, @Param("examDate") Date date);
	
}
