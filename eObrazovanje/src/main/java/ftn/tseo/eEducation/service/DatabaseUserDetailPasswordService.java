package ftn.tseo.eEducation.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserMapper;
import ftn.tseo.eEducation.repository.UserRepository;

@Service
@Transactional
public class DatabaseUserDetailPasswordService implements UserDetailsPasswordService {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		
		User registeredUser = userRepository.findByUsername(user.getUsername());
		
		registeredUser.setPassword(newPassword);
		return userMapper.toUserDetails(registeredUser);
		
	} 
	
	
}
