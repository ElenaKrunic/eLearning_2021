package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long>{

	void deleteByUser(Long id);
}
