package ftn.tseo.eEducation.service;

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
	

	
	

}
