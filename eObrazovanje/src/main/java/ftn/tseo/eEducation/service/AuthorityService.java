package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ftn.tseo.eEducation.repository.AuthorityRepository;

import ftn.tseo.eEducation.model.Authority;

@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository; 

	public List<Authority> findAll() {
		return authorityRepository.findAll();
	}

}

