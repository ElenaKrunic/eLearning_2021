package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ProfessorDTO;
import ftn.tseo.eEducation.DTO.StudentDTO;
import ftn.tseo.eEducation.DTO.TeachingDTO;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.Teaching;
import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.UserRepository;
import ftn.tseo.eEducation.service.CourseService;
import ftn.tseo.eEducation.service.ExamService;
import ftn.tseo.eEducation.service.ProfessorService;
import ftn.tseo.eEducation.service.StudentService;
import ftn.tseo.eEducation.service.TeachingService;
import ftn.tseo.eEducation.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/professors")
@CrossOrigin(value = "*")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	


	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamService examService;
	
	@Autowired
	StudentService studentService;
	@Autowired
	TeachingService teachingService;
	@Autowired
	UserRepository userRepository; 
	@Autowired
	ProfessorRepository pRepository;
	
	@Autowired
	UserDetailsServiceImpl userService; 
	
	@RequestMapping(value="/me")
	public ResponseEntity<?> getProffesor(@AuthenticationPrincipal UserDetails userDetails){
	
		Professor proffesor=professorService.findUserByUsername(userDetails.getUsername());
		System.out.println("professor" + proffesor);
		return new ResponseEntity<>(proffesor,HttpStatus.OK);
		
	}
	

	/*@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> getProfessors() {
		List<Professor> professors = professorService.findAll();
		// convert professors to DTOs
		List<ProfessorDTO> pDTO = new ArrayList<>();
		for (Professor c : professors) {
			pDTO.add(new ProfessorDTO(c));
		}
		return new ResponseEntity<>(pDTO, HttpStatus.OK);
	}*/
	
	
	
	@RequestMapping(value="/professors", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllProfessors(
			@RequestParam(required=false) String firstName, 
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
		      
			List<Professor> professors = new ArrayList<Professor>(); 

			Pageable paging = PageRequest.of(page, size); 
			
			Page<Professor> pageP; 
			
			if (firstName == null) 
				pageP = pRepository.findAll(paging);
			else 
				pageP = pRepository.findByFirstName(firstName, paging); 
			
			professors = pageP.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("professors", professors); 
			response.put("currentPage", pageP.getNumber()); 
			response.put("totalItems", pageP.getTotalElements());
			response.put("totalPages", pageP.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfessorDTO> getProfessor(@PathVariable Long id) {
		Professor p = professorService.findOneById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ProfessorDTO(p), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ProfessorDTO> saveProfessor(@RequestBody ProfessorDTO pDTO){		
		
		User user = userRepository.findById((long) 1).orElse(null);
		
		Professor p = new Professor();
		p.setFirstName(pDTO.getFirstName());
		p.setLastName(pDTO.getLastName());
		p.setUser(user);
		
		p = professorService.save(p);
		user = userRepository.save(user);
		return new ResponseEntity<>(new ProfessorDTO(p), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO pDTO){
		//a professor must exist
		Professor p = professorService.findOneById(pDTO.getId()); 
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		p.setFirstName(pDTO.getFirstName());
		p.setLastName(pDTO.getLastName());
		
		p = professorService.save(p);
		return new ResponseEntity<>(new ProfessorDTO(p), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProfessor(@PathVariable Long id){
		Professor p = professorService.findOneById(id);
		if (p != null){
			professorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/{professorId}/professorStudents")
	private List<StudentDTO> getProffesorStudents(@PathVariable("professorId") Long id) {
		return studentService.findProffesorStudent(id);
	}
	
//	
	@GetMapping(value="/{professorId}/proffesorCourses")
	private CourseDTO getProffesorCourses(@PathVariable("professorId") Long id) {
		return courseService.findProfessorCourses(id);
	}
//	
//	@RequestMapping(value = "/{id}/students", method = RequestMethod.GET)
//	public ResponseEntity<List<StudentDTO>> getProfessorStudents(
//			@PathVariable Long id) {
//		Professor professor = professorService.findOneById(id);
//		if (professor != null){
//			studentService.getEnrolledStudents(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {		
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
	@GetMapping(value="/{professorId}/professorExams")
	private List<ExamDTO> getProffesorExams(@PathVariable("professorId") Long id) {
		return examService.findProffesorExams(id);
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
	
	
}
