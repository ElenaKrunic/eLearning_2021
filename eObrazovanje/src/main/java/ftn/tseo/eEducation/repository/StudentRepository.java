package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
		
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);

    Student findByUser_Username(String username);

	Page<Student> findAll(Pageable pageable);
	Page<Student> findByFirstName(String firstName, Pageable page);
	List<Student> findByFirstName(String firstName, Sort sort);


    
}
