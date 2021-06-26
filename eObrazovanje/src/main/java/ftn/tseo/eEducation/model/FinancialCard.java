package ftn.tseo.eEducation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class FinancialCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private float initialState;
	
	private float totalPayment;
	
	private float totalPayout;
	
	private float totalCost;
	
	@OneToOne
	@JoinColumn(name = "student", referencedColumnName = "id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Student student;
	
	@OneToMany(mappedBy="financialCard",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Payment> payments=new HashSet<Payment>();

	@OneToMany(mappedBy="financialCard",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<PayOut> payouts=new HashSet<PayOut>();
	
	public Set<PayOut> getPayouts() {
		return payouts;
	}

	public void setPayouts(Set<PayOut> payouts) {
		this.payouts = payouts;
	}

	public FinancialCard() {
		super();
	}

	public FinancialCard(Long id, float initialState, float totalPayment, float totalPayout, float totalCost,
			Student student, Set<Payment> payments, Set<PayOut> payouts) {
		super();
		this.id = id;
		this.initialState = initialState;
		this.totalPayment = totalPayment;
		this.totalPayout = totalPayout;
		this.totalCost = totalCost;
		this.student = student;
		this.payments = payments;
		this.payouts = payouts;
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

	public float getTotalPayout() {
		return totalPayout;
	}

	public void setTotalPayout(float totalPayout) {
		this.totalPayout = totalPayout;
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


}
