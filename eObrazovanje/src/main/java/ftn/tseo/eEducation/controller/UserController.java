package ftn.tseo.eEducation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.LoginDTO;
import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserAuthority;
import ftn.tseo.eEducation.repository.UserRepository;
import ftn.tseo.eEducation.security.TokenUtils;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder; 
//	
	@Autowired
	AuthenticationManager aManager;
	
	@Autowired
	UserDetailsService uDService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

			)
	public ResponseEntity<String> login (@RequestBody LoginDTO lDTO){
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(lDTO.getUsername(), lDTO.getPassword());
            UserDetails details = uDService.loadUserByUsername(lDTO.getUsername());
            System.out.println("details"+details);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<String>(tokenUtils.generateToken(details), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Login failed", HttpStatus.BAD_REQUEST);
        }
	}
	
//	@PostMapping("/api/register")
//	@ResponseStatus(code=HttpStatus.CREATED)
//	public void register(@RequestBody LoginDTO loginDTO) {
//		UserAuthority userAuthority=new UserAuthority();
//		User user = new User(); 
//		user.setUsername(loginDTO.getUsername());
//		user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
//		
//		//ovde da se odradi setUserAuthority
//	    userRepository.save(user);
//	}
	 @GetMapping(
	            value = "/logOut",
	            produces = MediaType.TEXT_PLAIN_VALUE
	    )
	    public ResponseEntity logoutUser() throws Exception {

	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	        if (!(auth instanceof AnonymousAuthenticationToken)){
	            SecurityContextHolder.clearContext();

	            return new ResponseEntity<>("You successfully logged out!", HttpStatus.OK);
	        } else {
	            throw new Exception("WineUser is not authenticated!");
	        }

	    }
}
