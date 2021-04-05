package ftn.tseo.eEducation.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
@Entity
public class ExamPeriod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String startDate;
	
	private String endDate;
	
	private float paymentAmount;
	
	@OneToMany(mappedBy="examPeriod", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<Exam> exam= new HashSet<Exam>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExamPeriod(Long id, String name, String startDate, String endDate, float paymentAmount, Set<Exam> exam) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentAmount = paymentAmount;
		this.exam = exam;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Set<Exam> getExam() {
		return exam;
	}

	public void setExam(Set<Exam> exam) {
		this.exam = exam;
	}

	public ExamPeriod() {
		super();
	}

	
	

}
