package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
	Page<User> findAll(Pageable pageable);
	Page<User> findByUsername(String username, Pageable page);
	List<User> findByUsername(String username, Sort sort);

}
