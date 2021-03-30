package ftn.tseo.eEducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService {
	
	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	public ExamPeriod findOne(Long id) {
		return examPeriodRepository.findById(id).orElse(null);
	}
	
	public List<ExamPeriod> findAll() {
		return examPeriodRepository.findAll();
	}
	
	public ExamPeriod save(ExamPeriod enrollment) {
		return examPeriodRepository.save(enrollment);
	} 
	
	public void remove(Long id) {
		examPeriodRepository.deleteById(id);
	}
}
