package ftn.tseo.eEducation.DTO;

import java.sql.Date;

import ftn.tseo.eEducation.model.Enrollment;

public class EnrollmentDTO {
	
	private int id;
	public Date startDate;
	private Date endDate;
	private StudentDTO studentDTO;
	private CourseDTO courseDTO;

	public EnrollmentDTO(Enrollment enrollment) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public CourseDTO getCourseDTO() {
		return courseDTO;
	}

	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}

	public EnrollmentDTO(int id, Date startDate, Date endDate, StudentDTO studentDTO, CourseDTO courseDTO) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentDTO = studentDTO;
		this.courseDTO = courseDTO;
	}
	
	

}
