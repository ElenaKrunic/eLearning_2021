package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.TeachingDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.CourseRepository;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;

@Service
public class TeachingService {
	@Autowired
	TeachingRepository teachingRepository;
	public TeachingDTO findTeachingsForProfessor(Long id) {
	
		return new TeachingDTO(teachingRepository.findTeachingByProfessorId(id));


	}	
}
