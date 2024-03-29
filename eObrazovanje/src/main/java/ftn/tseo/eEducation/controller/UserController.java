package ftn.tseo.eEducation.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ftn.tseo.eEducation.DTO.AuthorityDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamPeriodDTO;
import ftn.tseo.eEducation.DTO.LoginDTO;
import ftn.tseo.eEducation.DTO.UserDTO;
import ftn.tseo.eEducation.model.Admin;
import ftn.tseo.eEducation.model.Authority;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserAuthority;
import ftn.tseo.eEducation.repository.AdminRepository;
import ftn.tseo.eEducation.repository.AuthorityRepository;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.UserAuthorityRepository;
import ftn.tseo.eEducation.repository.UserRepository;
import ftn.tseo.eEducation.security.TokenUtils;
import ftn.tseo.eEducation.service.AuthorityService;
import ftn.tseo.eEducation.service.StudentService;
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
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	AdminRepository adminRepository; 
	
	@Autowired
	UserAuthorityRepository userAuthorityRepository; 
	
	
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
        	ex.printStackTrace();
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
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User u = userRepository.getOne(id);
		//System.out.println("Id je " + u.getId());
		if (u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new UserDTO(u), HttpStatus.OK);
	}
	
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
	 
	 @PostMapping(value="/users")
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
				 //student.setAccountNumber();
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
	 
		@RequestMapping(value="/users", method = RequestMethod.GET)
		public ResponseEntity<Map<String,Object>> getAllUsers(
				@RequestParam(required=false) String username, 
				@RequestParam(defaultValue="0") int page,
				@RequestParam(defaultValue="3") int size,
				@RequestParam(defaultValue="id, desc") String[] sort) {
			
			try {
				
				 List<Order> orders = new ArrayList<Order>();

			      if (sort[0].contains(",")) {
			        // will sort more than 2 fields
			        // sortOrder="field, direction"
			        for (String sortOrder : sort) {
			          String[] _sort = sortOrder.split(",");
			          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
			        }
			      } else {
			        // sort=[field, direction]
			        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
			      }
			      
				List<User> users = new ArrayList<User>(); 

				Pageable paging = PageRequest.of(page, size); 
				Page<User> pageUsers; 
				
				if (username == null) 
					pageUsers = userRepository.findAll(paging);
				else 
					pageUsers = userRepository.findByUsername(username, paging); 
				
				users = pageUsers.getContent(); 
				
				Map<String, Object> response = new HashMap<>();
				response.put("users", users); 
				response.put("currentPage", pageUsers.getNumber()); 
				response.put("totalItems", pageUsers.getTotalElements());
				response.put("totalPages", pageUsers.getTotalPages());
				
				System.out.println("Lista objekata" + users);
				
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//helper method 
		private Sort.Direction getSortDirection(String direction) {
		    if (direction.equals("asc")) {
		      return Sort.Direction.ASC;
		    } else if (direction.equals("desc")) {
		      return Sort.Direction.DESC;
		    }

		    return Sort.Direction.ASC;
		  }
	
		
	
		@PutMapping(value="/users")
		@Transactional
		public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
			User user = userService.findByUsername(userDTO.getUsername()); 
			System.out.println("Username korisnika je" + user.getUsername()); 
			
			Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();
			for(UserAuthority a: user.getUserAuthorities()) {
				if(a.getAuthority().getName().equals("ROLE_STUDENT")) {
					Student student = studentRepository.findByUser(user.getUsername());
					System.out.println("\nroleToString "+userDTO.authorityToString());
					System.out.println("r.getRole().getCode() "+a.getAuthority().getName());
					System.out.println("Da li tacno? "+userDTO.authorityToString().contains(a.getAuthority().getName()));
					if(student!=null && !userDTO.authorityToString().contains(a.getAuthority().getName())) {
						studentRepository.delete(student);
					}
				} else if (a.getAuthority().getName().equals("ROLE_ADMINISTRATOR")) {
					Admin admin = adminRepository.findByUser(user.getUsername());
					if(admin!=null && !userDTO.authorityToString().contains(a.getAuthority().getName())) {
						adminRepository.delete(admin);
					}
				} else if (a.getAuthority().getName().equals("ROLE_PROFESOR")) {
					Professor professor = professorRepository.findByUser(user.getUsername());
					if(professor!=null && !userDTO.authorityToString().contains(a.getAuthority().getName())) {
						professorRepository.delete(professor);
					}
				}
			}
			
			userAuthorityRepository.deleteByUser(user.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			if(!userDTO.getPassword().equals(user.getPassword())) {
				user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			}
			user.setUserAuthorities(userAuthorities);
			
			 for(AuthorityDTO authorityDTO: userDTO.getAuthorities()) {
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
				 } else if (authorityDTO.getName().equals("ROLE_ADMIN")) {
					 Admin admin = new Admin();
					 admin.setUser(user);
					 adminRepository.save(admin);
				 }
				 
				 user = userRepository.save(user);
			 }			 
		
			return ResponseEntity.ok().build();
		}
		
		//nova metoda za izmjenu 
		@PutMapping(value="/users/{id}", consumes="application/json")
		public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id){
			
			User user = userRepository.getOne(userDTO.getId()); 
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			//ovde setovati uloge 
			
			user = userRepository.save(user);
			
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);	
		}
		
		@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteUser(@PathVariable Long id){
			User user = userRepository.getOne(id);
			if (user != null){
				userRepository.delete(user);
				//userRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {		
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		//stari 
		/*
		@GetMapping(value="/users/loggedUser")
		public ResponseEntity<UserDTO> getLoggedUser(Principal principal) {
			User user = userService.findByUsername(principal.getName());
			if(user == null) {
				System.out.println("User je null"); 				
			}
			return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);

		}
		*/
		
		@RequestMapping(value="users/loggedUser")
		public ResponseEntity<?> getLoggedUser(@AuthenticationPrincipal UserDetails userDetails){
			User user=userService.findUserByUsername(userDetails.getUsername());
			System.out.println("User je " + user.getUsername());
			return new ResponseEntity<>(user,HttpStatus.OK);
			
		}
		
		
}

