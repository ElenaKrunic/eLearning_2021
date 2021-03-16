package ftn.tseo.eEducation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FinancialCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private float initialState;
	
	private float totalPayment;
	
	private float totalCost;
	
	@OneToOne(mappedBy="financialCard",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Student student;
	
	@OneToMany(mappedBy="financialCard",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Payment> payments=new HashSet<Payment>();
	
	public FinancialCard() {
		super();
	}

	public FinancialCard(Long id, float initialState, float totalPayment, float totalCost, Student student,
			Set<Payment> payments) {
		super();
		this.id = id;
		this.initialState = initialState;
		this.totalPayment = totalPayment;
		this.totalCost = totalCost;
		this.student = student;
		this.payments = payments;
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



	public float getTotalPayment() {
		return totalPayment;
	}



	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}



	public float getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Set<Payment> getPayments() {
		return payments;
	}



	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}



	@Override
	public String toString() {
		return "FinancialCard [id=" + id + ", initialState=" + initialState + ", totalPayment=" + totalPayment
				+ ", totalCost=" + totalCost + ", student=" + student + ", payments=" + payments + "]";
	}
	
	
	
	
	

}
