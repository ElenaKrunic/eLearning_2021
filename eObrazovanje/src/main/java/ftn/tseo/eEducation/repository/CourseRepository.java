package ftn.tseo.eEducation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
//	
//	@Query(value = "SELECT c.course_id, c.ects, c.course_code, c.course_end_date, c.course_start_date, c.course_title FROM professor p INNER JOIN teaching t ON p.id = t.professor INNER JOIN courses c ON t.course = c.id WHERE p.id = ?")
//	List<Course> findProfessorsCourse(long id);
	
 
	
}
