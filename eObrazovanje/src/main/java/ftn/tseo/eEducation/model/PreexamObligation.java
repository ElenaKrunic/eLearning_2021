package ftn.tseo.eEducation.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	//veza ka ispitu 
	@ManyToOne
	@JoinColumn(name = "exam", referencedColumnName = "id", nullable = false)
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "obligationType", referencedColumnName = "id", nullable = false)
	private PreexamObligationType obligationType;
	
	@ManyToOne
	@JoinColumn(name = "examObligationStatus", referencedColumnName = "id", nullable = false)
	private PreexamObligationStatus examObligationStatus;
	
	//testna 
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

	public PreexamObligationType getObligationType() {
		return obligationType;
	}

	public void setObligationType(PreexamObligationType obligationType) {
		this.obligationType = obligationType;
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

	public PreexamObligation(Long id, float points, String location, Date dateOfObligation, Exam exam,
			PreexamObligationType obligationType, PreexamObligationStatus examObligationStatus, boolean passed) {
		super();
		this.id = id;
		this.points = points;
		this.location = location;
		this.dateOfObligation = dateOfObligation;
		this.exam = exam;
		this.obligationType = obligationType;
		this.examObligationStatus = examObligationStatus;
		this.passed = passed; 
	}

	public Date getDateOfObligation() {
		return dateOfObligation;
	}

	public void setDateOfObligation(Date dateOfObligation) {
		this.dateOfObligation = dateOfObligation;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}	
	
	public PreexamObligationStatus getExamObligationStatus() {
		return examObligationStatus;
	}

	public void setExamObligationStatus(PreexamObligationStatus examObligationStatus) {
		this.examObligationStatus = examObligationStatus;
	}
	
	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}


	
}
