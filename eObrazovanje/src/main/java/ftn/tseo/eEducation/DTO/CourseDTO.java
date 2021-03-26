package ftn.tseo.eEducation.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ftn.tseo.eEducation.model.Course;

public class CourseDTO {
	
	private Long id;
	private String title;
	private String courseCode;
	private Date startDate;
	private Date endDate;
	private int ECTS;
	private List<EnrollmentDTO> enrollmentDTOs;
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
	public List<EnrollmentDTO> getEnrollmentDTOs() {
		return enrollmentDTOs;
	}
	public void setEnrollmentDTOs(List<EnrollmentDTO> enrollmentDTOs) {
		this.enrollmentDTOs = enrollmentDTOs;
	}
	
	
	public CourseDTO(Long id, String title, String courseCode, Date startDate, Date endDate, int eCTS,
			List<EnrollmentDTO> enrollmentDTOs) {
		super();
		this.id = id;
		this.title = title;
		this.courseCode = courseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		ECTS = eCTS;
		this.enrollmentDTOs = enrollmentDTOs;
	}
	public CourseDTO(Course course) {
		this.id=course.getId();
		this.title=course.getTitle();
		this.courseCode=course.getCourseCode();
		this.startDate=course.getStartDate();
		this.endDate=course.getEndDate();
		this.ECTS= course.getECTS();
		this.enrollmentDTOs= new ArrayList<EnrollmentDTO>();
	}
	
	
	
	
	
	

}
