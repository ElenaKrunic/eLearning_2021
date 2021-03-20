package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.repository.TeachingRepository;

@Service
public class TeachingService {
	
	@Autowired
	private TeachingRepository teachingRepository;
	
	public List<Course> findCoursesForProfessor(long id){
		return teachingRepository.findProfessorsCourse(id);
	}
}
