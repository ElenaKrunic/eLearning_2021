package ftn.tseo.eEducation.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Elena Krunic 
 *
 */
@Entity
public class PreexamObligation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private float points;

	private String location;
	
	private Date dateOfObligation;
	
	private boolean passed; 

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "exam", referencedColumnName = "id", nullable = true)
	private Exam exam;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "preexam_obligation_type", referencedColumnName = "id", nullable = true)
	private PreexamObligationType preexamObligationType;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "preexam_obligation_status", referencedColumnName = "id", nullable = true)
	private PreexamObligationStatus preexamObligationStatus;
	
	//testna 
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Student student;
	
	
	public PreexamObligation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateOfObligation() {
		return dateOfObligation;
	}

	public void setDateOfObligation(Date dateOfObligation) {
		this.dateOfObligation = dateOfObligation;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public PreexamObligationType getPreexamObligationType() {
		return preexamObligationType;
	}

	public void setPreexamObligationType(PreexamObligationType preexamObligationType) {
		this.preexamObligationType = preexamObligationType;
	}

	public PreexamObligationStatus getPreexamObligationStatus() {
		return preexamObligationStatus;
	}

	public void setPreexamObligationStatus(PreexamObligationStatus preexamObligationStatus) {
		this.preexamObligationStatus = preexamObligationStatus;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PreexamObligation(Long id, float points, String location, Date dateOfObligation, boolean passed, Exam exam,
			PreexamObligationType preexamObligationType, PreexamObligationStatus preexamObligationStatus,
			Student student) {
		super();
		this.id = id;
		this.points = points;
		this.location = location;
		this.dateOfObligation = dateOfObligation;
		this.passed = passed;
		this.exam = exam;
		this.preexamObligationType = preexamObligationType;
		this.preexamObligationStatus = preexamObligationStatus;
		this.student = student;
	}
	
}
