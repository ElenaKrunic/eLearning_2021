package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Teaching;
import ftn.tseo.eEducation.repository.CourseRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;


@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TeachingRepository teachingRepository;
	
	public Course findOne(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}
	

	public void remove(Long id) {
		courseRepository.deleteById(id);
	}
	
	public CourseDTO findProfessorCourses(Long id) {

		Teaching teachings=teachingRepository.findTeachingByProfessorId(id);
		Course courses=teachings.getCourses();
		System.out.println("Professor courses"+courses);
		return new CourseDTO(courses);
	}

}
