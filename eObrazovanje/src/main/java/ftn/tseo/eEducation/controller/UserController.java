package ftn.tseo.eEducation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.LoginDTO;
import ftn.tseo.eEducation.security.TokenUtils;

@RestController
public class UserController {
	
	@Autowired
	AuthenticationManager aManager;
	
	@Autowired
	private UserDetailsService uDService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> login (@RequestBody LoginDTO lDTO){
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(lDTO.getUsername(), lDTO.getPassword());
            Authentication authentication = aManager.authenticate(token);
            UserDetails details = uDService.loadUserByUsername(lDTO.getUsername());
            return new ResponseEntity<String>(tokenUtils.generateToken(details), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Login failed", HttpStatus.BAD_REQUEST);
        }
		}

}
