package ftn.tseo.eEducation.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ftn.tseo.eEducation.model.Exam;

public class ExamDTO {
	private Long id;
	private EnrollmentDTO enrollmentDTO;
	private int grade;
	private float points;
	private Date examDate;
	private String courseName;
	private ExamPeriodDTO examPeriodDTO;
	public List<ExamRegistrationDTO> examRegistrationDTOs;

	public ExamDTO(Exam exam) {
		super();
		id = exam.getId();
		enrollmentDTO = new EnrollmentDTO(exam.getEnrollment());
		grade = exam.getGrade();
		points = exam.getPoints();
		courseName=exam.getEnrollment().getCourse().getTitle();
		examDate = exam.getExamDate();
		this.examRegistrationDTOs = new ArrayList<ExamRegistrationDTO>();
		examPeriodDTO=new ExamPeriodDTO(exam.getExamPeriod());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EnrollmentDTO getEnrollmentDTO() {
		return enrollmentDTO;
	}
	public void setEnrollmentDTO(EnrollmentDTO enrollmentDTO) {
		this.enrollmentDTO = enrollmentDTO;
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
	public ExamPeriodDTO getExamPeriodDTO() {
		return examPeriodDTO;
	}
	public void setExamPeriodDTO(ExamPeriodDTO examPeriodDTO) {
		this.examPeriodDTO = examPeriodDTO;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<ExamRegistrationDTO> getExamRegistrationDTOs() {
		return examRegistrationDTOs;
	}
	public void setExamRegistrationDTOs(List<ExamRegistrationDTO> examRegistrationDTOs) {
		this.examRegistrationDTOs = examRegistrationDTOs;
	}
	
	
	

}
