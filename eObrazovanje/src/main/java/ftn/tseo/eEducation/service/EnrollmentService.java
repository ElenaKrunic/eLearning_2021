package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Enrollment;
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
	
	
	
	// mislim da nije dobro
	public List<Student> getEnrolledStudents(long id) {
		Professor professor= professorRepository.findById(id).orElse(null);
		
		return studentRepository.getEnrolledStudentsInProfessorsCourse(id);
	}
	

	
	public Enrollment findOne(Long id) {
		return enrollmentRepository.findById(id).orElse(null);
	}
	
	public List<Enrollment> findAll(){
		return enrollmentRepository.findAll();
	}
	
	public Enrollment save(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}
	
	public void remove(Long id) {
		enrollmentRepository.deleteById(id);
	}
	
	

}
