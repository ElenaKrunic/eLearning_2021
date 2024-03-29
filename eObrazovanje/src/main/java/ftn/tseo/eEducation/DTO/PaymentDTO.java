package ftn.tseo.eEducation.DTO;

import java.sql.Date;

import ftn.tseo.eEducation.model.Payment;

public class PaymentDTO {
	
	private Long id;
	private Date paymentDate;
	private String paymentDescription;
	private float paymentAmount;
	//private FinancialCardDTO financialCardDTO;
		
	public PaymentDTO() {
		super();
	}

	public PaymentDTO(Payment payment) {
		super();
		this.id = payment.getId();
		this.paymentDate = payment.getDateOfPayment();
		this.paymentDescription = payment.getPaymentDescription();
		this.paymentAmount = payment.getPaymentAmount();
		//financialCardDTO=new FinancialCardDTO(payment.getFinancialCard());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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

	/*
	public FinancialCardDTO getFinancialCardDTO() {
		return financialCardDTO;
	}

	public void setFinancialCardDTO(FinancialCardDTO financialCardDTO) {
		this.financialCardDTO = financialCardDTO;
	}
	*/
	
}
