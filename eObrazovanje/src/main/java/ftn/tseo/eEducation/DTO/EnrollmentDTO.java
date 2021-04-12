package ftn.tseo.eEducation.DTO;

import java.sql.Date;

import ftn.tseo.eEducation.model.Enrollment;

public class EnrollmentDTO {
	
	private Long id;
	public Date startDate;
	private Date endDate;
	private StudentDTO studentDTO;
	private CourseDTO courseDTO;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public EnrollmentDTO(Enrollment enrollment) {
		super();
		this.id = enrollment.getId();
		this.startDate = enrollment.getStartDate();
		this.endDate =enrollment.getEndDate();
		this.studentDTO = new StudentDTO(enrollment.getStudent());
		this.courseDTO = new CourseDTO(enrollment.getCourses());
	}
	
	

}
