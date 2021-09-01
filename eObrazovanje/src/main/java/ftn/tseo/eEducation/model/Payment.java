package ftn.tseo.eEducation.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date paymentDate;
	
	private String paymentDescription;
	
	private float paymentAmount;
	
	private String paymentDate1;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "financialCard", referencedColumnName = "id", nullable = true)
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
	

	public Payment(Long id,  String paymentDescription, float paymentAmount, String paymentDate1,
			FinancialCard financialCard) {
		super();
		this.id = id;
		this.paymentDescription = paymentDescription;
		this.paymentAmount = paymentAmount;
		this.paymentDate1 = paymentDate1;
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

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentDate1() {
		return paymentDate1;
	}

	public void setPaymentDate1(String paymentDate1) {
		this.paymentDate1 = paymentDate1;
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
