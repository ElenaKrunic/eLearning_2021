package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.Teaching;

public interface TeachingRepository extends JpaRepository<Teaching, Long> {

	List<Course> findProfessorsCourse(long id);
	
	
}
