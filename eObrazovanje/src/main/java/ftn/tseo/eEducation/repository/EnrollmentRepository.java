package ftn.tseo.eEducation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.Student;



public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	
	List<Student> getEnrolledStudentsInProfessorsCourse(long id);
	
	//to do pogledati kako se rade kveriji
	
	
	
}
