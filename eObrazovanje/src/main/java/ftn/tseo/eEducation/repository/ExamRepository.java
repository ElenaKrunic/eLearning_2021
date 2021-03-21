package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Exam;



public interface ExamRepository extends JpaRepository<Exam, Long>{

	
	@Query(value = "SELECT e.exam_date, e.points, e.grade, c.course_code FROM student s INNER JOIN enrollment en ON s.id = en.student INNER JOIN exam e ON en.enrollment_id = e.enrollment INNER JOIN courses c ON en.course = c.course_id WHERE s.id = ?", nativeQuery = true)
	List<Exam> findStudentExams(Long id);
}
