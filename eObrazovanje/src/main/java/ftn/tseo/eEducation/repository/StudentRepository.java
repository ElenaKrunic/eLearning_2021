package ftn.tseo.eEducation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Student;




public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);

}
