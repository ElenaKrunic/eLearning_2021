package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.TeachingDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.TypeOfFinancing;
import ftn.tseo.eEducation.repository.CourseRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;
import ftn.tseo.eEducation.service.CourseService;
import ftn.tseo.eEducation.service.EnrollmentService;
import ftn.tseo.eEducation.service.TeachingService;

@RestController
@RequestMapping(value = "/api/courses")
public class CourseController {
	@Autowired
	 CourseService courseService;
	@Autowired
	EnrollmentService eService;
	@Autowired
	CourseRepository cRepo;
	@Autowired
	TeachingService teachingService;
	
	@RequestMapping(value="/courses", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllCourses(
			@RequestParam(required=false) String title, 
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
		      
			List<Course> courses = new ArrayList<Course>(); 

			Pageable paging = PageRequest.of(page, size); 
			
			Page<Course> pageCourses; 
			if (title == null) 
				pageCourses = cRepo.findAll(paging);
			else 
				pageCourses = cRepo.findByTitle(title, paging); 
			
			courses = pageCourses.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("courses", courses); 
			response.put("currentPage", pageCourses.getNumber()); 
			response.put("totalItems", pageCourses.getTotalElements());
			response.put("totalPages", pageCourses.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<Course> courses = courseService.findAll();
		// convert courses to DTOs
		List<CourseDTO> coursesDTO = new ArrayList<>();
		for (Course c : courses) {
			coursesDTO.add(new CourseDTO(c));
		}
		return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
	}*/

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
		Course course = courseService.findOne(id);
		if (course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO) {
		Course course = new Course();
		course.setTitle(courseDTO.getTitle());
		course.setECTS(courseDTO.getECTS());
		course.setCourseCode(courseDTO.getCourseCode());
		course.setEnrollments(null);
		course.setStartDate(courseDTO.getStartDate());
		course.setEndDate(courseDTO.getEndDate());
		

		course = courseService.save(course);
		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {

		Course course = courseService.findOne(courseDTO.getId());
		if (course == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		course.setTitle(courseDTO.getTitle());
		course.setECTS(courseDTO.getECTS());
		course.setCourseCode(courseDTO.getCourseCode());
		course.setEnrollments(null);
		course.setStartDate(courseDTO.getStartDate());
		course.setEndDate(courseDTO.getEndDate());
		

		course = courseService.save(course);
		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		Course course = courseService.findOne(id);
		if (course != null) {
			courseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping(value="/{courseId}/proffesorCourses")
	private CourseDTO getProffesorCourses(@PathVariable("courseId") Long id) {
		return courseService.findProfessorCourses(id);
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
