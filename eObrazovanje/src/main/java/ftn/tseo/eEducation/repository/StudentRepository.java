package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Student;



public interface StudentRepository extends JpaRepository<Student, Long>{

}
