package ftn.tseo.eEducation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date dateOfPayment;
	
	private String paymentDescription;
	
	private float paymentAmount;
	
	@OneToOne(mappedBy="payment",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private FinancialCard financialCard;

	public Payment() {
		super();
	}

	public Payment(Long id, Date dateOfPayment, String paymentDescription, float paymentAmount,
			FinancialCard financialCard) {
		super();
		this.id = id;
		this.dateOfPayment = dateOfPayment;
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
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
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

	@Override
	public String toString() {
		return "Payment [id=" + id + ", dateOfPayment=" + dateOfPayment + ", paymentDescription=" + paymentDescription
				+ ", paymentAmount=" + paymentAmount + ", financialCard=" + financialCard + "]";
	}


	

}
