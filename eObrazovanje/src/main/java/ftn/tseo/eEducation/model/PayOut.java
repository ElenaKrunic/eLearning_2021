package ftn.tseo.eEducation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PayOut {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date dateOfPayOut;
	
	private String descriptionPayOut;
	
	private float payOutAmount;
	

	@OneToOne
	@JoinColumn(name = "financialCard", referencedColumnName = "id", nullable = false)
	private FinancialCard financialCard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfPayOut() {
		return dateOfPayOut;
	}

	public void setDateOfPayOut(Date dateOfPayOut) {
		this.dateOfPayOut = dateOfPayOut;
	}

	public String getDescriptionPayOut() {
		return descriptionPayOut;
	}

	public void setDescriptionPayOut(String descriptionPayOut) {
		this.descriptionPayOut = descriptionPayOut;
	}

	public float getPayOutAmount() {
		return payOutAmount;
	}

	public void setPayOutAmount(float payOutAmount) {
		this.payOutAmount = payOutAmount;
	}

	public FinancialCard getFinancialCard() {
		return financialCard;
	}

	public void setFinancialCard(FinancialCard financialCard) {
		this.financialCard = financialCard;
	}

	public PayOut(Long id, Date dateOfPayOut, String descriptionPayOut, float payOutAmount,
			FinancialCard financialCard) {
		super();
		this.id = id;
		this.dateOfPayOut = dateOfPayOut;
		this.descriptionPayOut = descriptionPayOut;
		this.payOutAmount = payOutAmount;
		this.financialCard = financialCard;
	}

	public PayOut() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
