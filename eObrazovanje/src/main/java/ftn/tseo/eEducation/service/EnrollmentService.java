package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.CourseRepository;
import ftn.tseo.eEducation.repository.EnrollmentRepository;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.StudentRepository;

@Service
public class EnrollmentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	public List<Student> getEnrolledStudents(long id) {
		Professor professor= professorRepository.findById(id).orElse(null);
		
		return enrollmentRepository.getEnrolledStudentsInProfessorsCourse(id);
	}
	
	

	
	

}
