package ftn.tseo.eEducation.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import ftn.tseo.eEducation.model.Enrollment;




public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	

	
	//to do pogledati kako se rade kveriji
	
//	
//	List<Student> findStudentsForProfessorCourse(long id);
	List<Enrollment> findByStudent(Long id);

}
