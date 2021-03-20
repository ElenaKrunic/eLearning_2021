package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.repository.CourseRepository;


@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
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
	
}
