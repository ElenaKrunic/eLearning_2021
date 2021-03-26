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
	
	@OneToMany(mappedBy="exam", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<PreexamObligation> preexamObligation= new HashSet<PreexamObligation>();
	
	@OneToOne
	@JoinColumn(name = "examPeriod", referencedColumnName = "id", nullable = false)
	private ExamPeriod examPeriod;
	
	@ManyToOne
	@JoinColumn(name = "enrollment", referencedColumnName = "enrollment_id", nullable = false)
	private Enrollment enrollment;

	public Exam() {
		super();
	}

	public Exam(Long id, int grade, Float points, Date examDate, Set<PreexamObligation> preExamObligations,
			Set<ExamPeriod> examPeriods, Enrollment enrollments_exams) {
		super();
		this.id = id;
		this.grade = grade;
		this.points = points;
		this.examDate = examDate;
//		this.preExamObligations = preExamObligations;
//		this.examPeriods = examPeriods;
//		this.enrollments_exams = enrollments_exams;
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

	public Set<PreexamObligation> getPreexamObligation() {
		return preexamObligation;
	}

	public void setPreexamObligation(Set<PreexamObligation> preexamObligation) {
		this.preexamObligation = preexamObligation;
	}

	public ExamPeriod getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.examPeriod = examPeriod;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}



	
	
	
	
	
}
