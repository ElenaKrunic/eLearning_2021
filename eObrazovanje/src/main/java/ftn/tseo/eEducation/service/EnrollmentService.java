package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.EnrollmentDTO;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.CourseRepository;
import ftn.tseo.eEducation.repository.EnrollmentRepository;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.StudentRepository;

@Service
public class EnrollmentService {
	
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	

	
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
	
	public List<EnrollmentDTO> findEnrollmentForStudent(Long id){
		List<EnrollmentDTO> enrollmentToDTO = new ArrayList<>();
		List<Enrollment> enrollment=enrollmentRepository.findByStudent(id);
		System.out.println("Enrollment service  "+enrollmentToDTO);
		
		if(enrollment!=null) {
			for (Enrollment e: enrollment) {
				enrollmentToDTO.add(new EnrollmentDTO(e));
			}
		
		}
		return enrollmentToDTO;
		
	}
	
	

}
