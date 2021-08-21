package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Admin;
import ftn.tseo.eEducation.model.Student;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findByUser(String username);


}
