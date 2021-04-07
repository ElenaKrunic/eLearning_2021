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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int grade;
	
	private float points;
	
	private Date examDate;
	
	private boolean status;
	
	@OneToMany(mappedBy="exam", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<PreexamObligation> preexamObligation= new HashSet<PreexamObligation>();
	
	@OneToMany(mappedBy = "exam",  fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<ExamPeriod> examPeriod= new HashSet<ExamPeriod>();
	
	@ManyToOne
	@JoinColumn(name = "enrollments", referencedColumnName = "enrollment_id", nullable = false)
	private Enrollment enrollments;

	

	public Exam() {
		super();
	}



	public Exam(Long id, int grade, float points, Date examDate, boolean status,
			Set<PreexamObligation> preexamObligation, Set<ExamPeriod> examPeriod, Enrollment enrollments) {
		super();
		this.id = id;
		this.grade = grade;
		this.points = points;
		this.examDate = examDate;
		this.status = status;
		this.preexamObligation = preexamObligation;
		this.examPeriod = examPeriod;
		this.enrollments = enrollments;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public float getPoints() {
		return points;
	}



	public void setPoints(float points) {
		this.points = points;
	}



	public Date getExamDate() {
		return examDate;
	}



	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public Set<PreexamObligation> getPreexamObligation() {
		return preexamObligation;
	}



	public void setPreexamObligation(Set<PreexamObligation> preexamObligation) {
		this.preexamObligation = preexamObligation;
	}



	public Set<ExamPeriod> getExamPeriod() {
		return examPeriod;
	}



	public void setExamPeriod(Set<ExamPeriod> examPeriod) {
		this.examPeriod = examPeriod;
	}



	public Enrollment getEnrollments() {
		return enrollments;
	}



	public void setEnrollments(Enrollment enrollments) {
		this.enrollments = enrollments;
	}







}
