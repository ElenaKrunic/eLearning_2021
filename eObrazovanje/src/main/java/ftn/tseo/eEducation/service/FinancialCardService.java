package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.StudentRepository;

@Service
public class FinancialCardService {
	@Autowired
	FinancialCardRepository financialCardRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	public FinancialCard findOne(Long id) {
		return financialCardRepository.findById(id).orElse(null);
	}
	
	public List<FinancialCard> findAll() {
		return financialCardRepository.findAll(); 
	}
	
	public FinancialCard save(FinancialCard financialCard) {
		return financialCardRepository.save(financialCard);
	}
	
	public void remove(Long id) {
		financialCardRepository.deleteById(id);
	}
	
	public FinancialCardDTO findFinancialCardForStudent(Long id) {
	
		FinancialCard allFinancialCards = financialCardRepository.findFinancialCardByStudentId(id);
		
		
		return new FinancialCardDTO(allFinancialCards);
		}
		
	
//	public FinancialCardDTO findStudentFinancialCard(Long id) {
//		
//		FinancialCard financialCardForStudent= financialCardRepository.findStudentFinancialCard(id);
//		FinancialCardDTO financialCardDTO=new FinancialCardDTO(financialCardForStudent);
//		return financialCardDTO;
//		
//	}
	
	
}
