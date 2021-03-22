package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	TeachingRepository teachingRepository;
	
	public Exam findOne(Long id) {
		return examRepository.findById(id).orElse(null);
	}


	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	public void remove(Long id) {
		examRepository.deleteById(id);
	}
	
	
	

}
