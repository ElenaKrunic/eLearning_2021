package ftn.tseo.eEducation.DTO;

import java.util.Date;

import ftn.tseo.eEducation.model.PayOut;

public class PayoutDTO {
	private Long id;
	private String descriptionOfPayout;
	private float amountOfPayout;
	private Date dateOfPayout;
	private FinancialCardDTO financialCardDTO;
	
	public PayoutDTO(PayOut payout) {
		super();
		this.id=payout.getId();
		this.descriptionOfPayout = payout.getDescriptionPayOut();
		this.amountOfPayout = payout.getPayOutAmount();
		this.dateOfPayout = payout.getDateOfPayOut();
		this.financialCardDTO = new FinancialCardDTO(payout.getFinancialCard());
	}

	public PayoutDTO() {
		super();


	}

	public String getDescriptionOfPayout() {
		return descriptionOfPayout;
	}

	public void setDescriptionOfPayout(String descriptionOfPayout) {
		this.descriptionOfPayout = descriptionOfPayout;
	}

	public float getAmountOfPayout() {
		return amountOfPayout;
	}

	public void setAmountOfPayout(float amountOfPayout) {
		this.amountOfPayout = amountOfPayout;
	}

	public Date getDateOfPayout() {
		return dateOfPayout;
	}

	public void setDateOfPayout(Date dateOfPayout) {
		this.dateOfPayout = dateOfPayout;
	}

	public FinancialCardDTO getFinancialCardDTO() {
		return financialCardDTO;
	}

	public void setFinancialCardDTO(FinancialCardDTO financialCardDTO) {
		this.financialCardDTO = financialCardDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
