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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	private Float points;
	
	private Date examDate;
	
	@OneToMany(mappedBy="exam", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<PreexamObligation> preExamObligations= new HashSet<PreexamObligation>();
	
	@OneToMany(mappedBy="exam", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<ExamPeriod> examPeriods= new HashSet<ExamPeriod>();
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Enrollment enrollment;

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

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Set<PreexamObligation> getPreExamObligations() {
		return preExamObligations;
	}

	public void setPreExamObligations(Set<PreexamObligation> preExamObligations) {
		this.preExamObligations = preExamObligations;
	}

	public Set<ExamPeriod> getExamPeriods() {
		return examPeriods;
	}

	public void setExamPeriods(Set<ExamPeriod> examPeriods) {
		this.examPeriods = examPeriods;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Exam(Long id, int grade, Float points, Date examDate, Set<PreexamObligation> preExamObligations,
			Set<ExamPeriod> examPeriods, Enrollment enrollment) {
		super();
		this.id = id;
		this.grade = grade;
		this.points = points;
		this.examDate = examDate;
		this.preExamObligations = preExamObligations;
		this.examPeriods = examPeriods;
		this.enrollment = enrollment;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
