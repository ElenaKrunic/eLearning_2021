package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.FinancialCard;

public class FinancialCardDTO {
	
	private Long id;
	private float initialState;
	private float totalCost;
	private float totalPayment;
	private float totalPayout; 
	private StudentDTO studentDTO;

	public FinancialCardDTO( ) {
		super();
	}

	public FinancialCardDTO(FinancialCard financialCard) {
		super();
		this.id = financialCard.getId();
		this.initialState = financialCard.getInitialState();
		this.totalCost = financialCard.getTotalCost();
		this.totalPayment = financialCard.getTotalPayment();
		this.totalPayout = financialCard.getTotalPayout();
		this.studentDTO=new StudentDTO(financialCard.getStudent());
		
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getInitialState() {
		return initialState;
	}

	public void setInitialState(float initialState) {
		this.initialState = initialState;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}

	public float getTotalPayout() {
		return totalPayout;
	}

	public void setTotalPayout(float totalPayout) {
		this.totalPayout = totalPayout;
	}

	
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}
	
	
	

}