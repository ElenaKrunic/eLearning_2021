package ftn.tseo.eEducation.model;



import java.sql.Date;
import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	private String examDate1;
	
	private Date examDate;
	
	private boolean status;
	@JsonIgnore
	@OneToMany(mappedBy="exam", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<PreexamObligation> preexamObligation= new HashSet<PreexamObligation>();
	@JsonIgnore
	@OneToMany
	(mappedBy="exam", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<ExamPeriod> examPeriod= new HashSet<ExamPeriod>();
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "enrollments", referencedColumnName = "enrollment_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Enrollment enrollments;

	

	public Exam() {
		super();
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


	public String getExamDate1() {
		return examDate1;
	}



	public void setExamDate1(String examDate1) {
		this.examDate1 = examDate1;
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
	
	public Exam(Long id, int grade, float points, String examDate1, boolean status,
			Set<PreexamObligation> preexamObligation, Set<ExamPeriod> examPeriod, Enrollment enrollments) {
		super();
		this.id = id;
		this.grade = grade;
		this.points = points;
		this.examDate1 = examDate1;
		this.status = status;
		this.preexamObligation = preexamObligation;
		this.examPeriod = examPeriod;
		this.enrollments = enrollments;
	}



	public void addExamPeriod(ExamPeriod examPeriod) {
		if(examPeriod.getExam() != null) {
			examPeriod.getExam().removeExamPeriod(examPeriod);
		examPeriod.setExam(this);
		getExamPeriod().add(examPeriod);
		}
	}
	
	public void removeExamPeriod(ExamPeriod examPeriod) {
		examPeriod.setExam(null);
		getExamPeriod().remove(examPeriod);
	}
}
