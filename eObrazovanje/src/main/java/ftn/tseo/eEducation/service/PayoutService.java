package ftn.tseo.eEducation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.PayOut;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PayoutRepository;
@Service
public class PayoutService {
	
	@Autowired
	PayoutRepository payoutRepository;
	
	@Autowired
	FinancialCardRepository financialCardRepository;
	
	
	public List<PayoutDTO> getStudentFinancialCardPayout(Long id){
		List<PayoutDTO> payoutDTO = new ArrayList<PayoutDTO>();
		FinancialCard financialCardPayment=financialCardRepository.findFinancialCardByStudentId(id);
		for (PayOut p: financialCardPayment.getPayouts()) {
			payoutDTO.add(new PayoutDTO(p));
		}
		return payoutDTO;

	}
	

}
