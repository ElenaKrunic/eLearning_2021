package ftn.tseo.eEducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findOneByName(String name);
}
