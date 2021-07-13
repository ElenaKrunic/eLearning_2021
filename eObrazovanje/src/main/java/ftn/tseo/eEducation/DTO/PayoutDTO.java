package ftn.tseo.eEducation.DTO;

import java.util.Date;

import ftn.tseo.eEducation.model.PayOut;

public class PayoutDTO {
	
	private Long id;
	private String descriptionPayOut;
	private float payOutAmount;
	private Date dateOfPayOut;
	
	
	public PayoutDTO(PayOut payout) {
		super();
		
		this.id=payout.getId();
		this.descriptionPayOut = payout.getDescriptionPayOut();
		this.payOutAmount = payout.getPayOutAmount();
		this.dateOfPayOut = payout.getDateOfPayOut();
	}

	public PayoutDTO() {
		super();


	}

	public String getDescriptionOfPayout() {
		return descriptionPayOut;
	}

	public void setDescriptionOfPayout(String descriptionOfPayout) {
		this.descriptionPayOut = descriptionOfPayout;
	}

	public float getAmountOfPayout() {
		return payOutAmount;
	}

	public void setAmountOfPayout(float amountOfPayout) {
		this.payOutAmount = amountOfPayout;
	}

	public Date getDateOfPayout() {
		return dateOfPayOut;
	}

	public void setDateOfPayout(Date dateOfPayout) {
		this.dateOfPayOut = dateOfPayout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
