package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserAuthority;
import ftn.tseo.eEducation.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u= userRepository.findByUsername(username);
		if (u == null) {
		      throw new UsernameNotFoundException(String.format("User not found with username '%s'.", username));
		    } else {
		    	List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
		    	for (UserAuthority ua: u.getUserAuthorities()) {
		    		ga.add(new SimpleGrantedAuthority(ua.getAuthority().getName()));
		    	}
		    	
		    	
		    	return new org.springframework.security.core.userdetails.User(
		    		  u.getUsername(),
		    		  u.getPassword(),
		    		  ga);
		    }
		  }
	
	
	

}
