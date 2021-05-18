package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
