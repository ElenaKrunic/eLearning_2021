package ftn.tseo.eEducation.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date paymentDate;
	
	private String paymentDescription;
	
	private float paymentAmount;
	
	@OneToOne
	@JoinColumn(name = "financialCard", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private FinancialCard financialCard;
	
	public Payment() {
		super();
	}

	public Payment(Long id, Date dateOfPayment, String paymentDescription, float paymentAmount,
			FinancialCard financialCard) {
		super();
		this.id = id;
		this.paymentDate = dateOfPayment;
		this.paymentDescription = paymentDescription;
		this.paymentAmount = paymentAmount;
		this.financialCard = financialCard;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfPayment() {
		return paymentDate;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.paymentDate = dateOfPayment;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public FinancialCard getFinancialCard() {
		return financialCard;
	}

	public void setFinancialCard(FinancialCard financialCard) {
		this.financialCard = financialCard;
	}

}
