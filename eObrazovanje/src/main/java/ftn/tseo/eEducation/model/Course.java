package ftn.tseo.eEducation.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "courses")
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", nullable = false)
	private Long id;
	
	@Column(name = "course_title", unique = true, nullable = false)
	private String title;
	
	@Column(name = "course_code", unique = true, nullable = false)
	private String courseCode;
	
	@Column(name = "course_start_date", unique = false, nullable = true)
	private Date startDate;

	@Column(name = "course_end_date", unique = false, nullable = true)
	private Date endDate;
	
	@Column(name = "ECTS", nullable = false)
	private int ects;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "courses")
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "courses")
	private Set<Teaching> teachings = new HashSet<Teaching>();
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Course() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Date getStartDate() {
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



	public int getECTS() {
		return ects;
	}

	public void setECTS(int ects) {
		this.ects = ects;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public Set<Teaching> getTeachings() {
		return teachings;
	}

	public void setTeachings(Set<Teaching> teachings) {
		this.teachings = teachings;
	}

	/*public Course(Long id, String title, String courseCode, Date startDate, Date endDate, int ects,
			Set<Enrollment> enrollments, Set<Teaching> teachings) {
		super();
		this.id = id;
		this.title = title;
		this.courseCode = courseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ects = ects;
		this.enrollments = enrollments;
		this.teachings = teachings;
	}*/
	public Course(Long id, String title, String courseCode, Date startDate, Date endDate, int ects) {
		super();
		this.id = id;
		this.title = title;
		this.courseCode = courseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ects = ects;
		
	}

	
	

	

}
