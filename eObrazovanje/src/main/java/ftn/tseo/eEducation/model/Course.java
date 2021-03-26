package ftn.tseo.eEducation.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	private int ECTS;
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "course")
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();
	
	
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
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Course(Long id, String title, String courseCode, Date startDate, Date endDate, int eCTS,
			Set<Enrollment> enrollments) {
		super();
		this.id = id;
		this.title = title;
		this.courseCode = courseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		ECTS = eCTS;
		this.enrollments = enrollments;
	}
	
	
	

	

}
