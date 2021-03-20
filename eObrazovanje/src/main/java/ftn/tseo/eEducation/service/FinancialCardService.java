package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.repository.FinancialCardRepository;

@Service
public class FinancialCardService {
	@Autowired
	FinancialCardRepository financialCardRepository;
	
	
	private List<FinancialCard> getStudentFinancialCard(Long id){
		List<FinancialCard> financialCard = new ArrayList<FinancialCard>();
		for (FinancialCard f: financialCardRepository.getStudentFinancialCard(id)) {
			financialCard.add(f);
		}
		return financialCard;
	}
	
}
