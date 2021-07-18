package ftn.tseo.eEducation.controller;


import java.security.cert.URICertStoreParameters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ftn.tseo.eEducation.DTO.AuthorityDTO;
import ftn.tseo.eEducation.DTO.LoginDTO;
import ftn.tseo.eEducation.DTO.UserDTO;
import ftn.tseo.eEducation.model.Authority;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserAuthority;
import ftn.tseo.eEducation.repository.AuthorityRepository;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.UserRepository;
import ftn.tseo.eEducation.security.TokenUtils;
import ftn.tseo.eEducation.service.AuthorityService;
import ftn.tseo.eEducation.service.UserDetailsServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	AuthenticationManager aManager;
	
	@Autowired
	UserDetailsService uDService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	UserDetailsServiceImpl userService; 
	
	@Autowired
	AuthorityService authorityService; 
	
	@Autowired
	AuthorityRepository authorityRepository; 
	
	@Autowired
	StudentRepository studentRepository; 
	
	@Autowired
	ProfessorRepository professorRepository; 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,
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
	 
	 
	 
	 @GetMapping(value= "users/{username}/unassigned-authorities")
	 public ResponseEntity<List<AuthorityDTO>> getAuthorities(@PathVariable("username") String username) {
		 User user = userService.findByUsername(username);
		 
		 List<AuthorityDTO> authoritiesDTO = new ArrayList<AuthorityDTO>(); 
		 List<Authority> authorities = authorityService.findAll();
		 
		 if(user != null & user.getUserAuthorities().size() > 0) {
			 for (Authority authority : authorities) {
				 int isIn = 0;
				 for( UserAuthority userAuthority : user.getUserAuthorities()) {
					 if (!userAuthority.getAuthority().getName().equals(authority.getName())) {
						 isIn++;
					 }
				 }
				 
				 if(isIn == user.getUserAuthorities().size()) {
					 System.out.println("Dodala se uloga");
					 authoritiesDTO.add(new AuthorityDTO(authority));
				 }
			 }
		 } else if ((user == null) || user.getUserAuthorities().size()==0) {
			 for(Authority authority : authorities) {
				 authoritiesDTO.add(new AuthorityDTO(authority));
			 }
		 }
		return new ResponseEntity<List<AuthorityDTO>>(authoritiesDTO, HttpStatus.OK);
	 }
	 
	 @PostMapping(value="/users/addUser")
	 public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto, UriComponentsBuilder ucBuilder) {
		 User existsUser = this.userService.findByUsername(dto.getUsername());
		 
		 if(existsUser != null) {
			 return ResponseEntity.status(409).build();
		 }
		 
		 User user = new User(); 
		 user.setUsername(dto.getUsername());
		 user.setPassword(passwordEncoder.encode(dto.getPassword()));
		 userRepository.save(user);
		 
		 for(AuthorityDTO authorityDTO: dto.getAuthorities()) {
			 Authority a = authorityRepository.findOneByName(authorityDTO.getName());
			 UserAuthority userAuthority = new UserAuthority(user,a); 
			 user.getUserAuthorities().add(userAuthority);
			 
			 if(authorityDTO.getName().equals("ROLE_STUDENT")) {
				 Student student = new Student();
				 //osmisliti nacin kako da dodam druge parametre ili da prebacim osnovne podatke u user-a 
				 student.setUser(user);
				 studentRepository.save(student); 
			 } else if (authorityDTO.getName().equals("ROLE_PROFESOR")) {
				 Professor professor = new Professor(); 
				 professor.setUser(user);
				 professorRepository.save(professor);
			 } 
			 
			 user = userRepository.save(user);
		 }
		 
		 return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
		 
	 }
	 
}

