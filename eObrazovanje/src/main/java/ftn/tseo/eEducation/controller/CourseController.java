package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.TeachingDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.repository.TeachingRepository;
import ftn.tseo.eEducation.service.CourseService;
import ftn.tseo.eEducation.service.TeachingService;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	TeachingService teachingService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<Course> courses = courseService.findAll();
		// convert courses to DTOs
		List<CourseDTO> coursesDTO = new ArrayList<>();
		for (Course c : courses) {
			coursesDTO.add(new CourseDTO(c));
		}
		return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
	}

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
}
