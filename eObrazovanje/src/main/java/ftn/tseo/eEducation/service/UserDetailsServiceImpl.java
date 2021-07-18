package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserAuthority;
import ftn.tseo.eEducation.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
//	
//	@Autowired
//	UserMapper userMapper; 
	
//	public UserDetailsServiceImpl(
//		      UserRepository userRepository, UserMapper userMapper) {
//		    this.userRepository = userRepository;
//		    this.userMapper = userMapper;
//		  }
//	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username); 
		System.out.println("User"  + user);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("User not found with username '%s'.", username));
		}
		else {
			List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
			for(UserAuthority ua : user.getUserAuthorities()) {
				ga.add(new SimpleGrantedAuthority(ua.getAuthority().getName()));
			}
			System.out.println("roles"+ga);
			return new org.springframework.security.core.userdetails.User(
		    		  user.getUsername(),
		    		  user.getPassword(),
		    		  ga);
		}
		
			
//		return userMapper.toUserDetails(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}

