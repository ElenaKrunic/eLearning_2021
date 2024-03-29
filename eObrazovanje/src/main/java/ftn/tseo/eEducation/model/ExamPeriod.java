package ftn.tseo.eEducation.model;

import java.sql.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	private Date startDate;

	private Date endDate;
	
	private float paymentAmount;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "exam", referencedColumnName = "id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Exam exam;

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

	public ExamPeriod(Long id, String name, Date startDate, Date endDate, float paymentAmount, Set<Exam> exam) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentAmount = paymentAmount;
//		this.exam = exam;
	}

	public ExamPeriod(Long id, String name, Date startDate, Date endDate, float paymentAmount) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentAmount = paymentAmount;
	}

	
	public 	Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ExamPeriod() {
		super();
	}

	
	

}
