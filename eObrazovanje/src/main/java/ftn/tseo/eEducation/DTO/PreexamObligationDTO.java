package ftn.tseo.eEducation.DTO;

import java.sql.Date;

import ftn.tseo.eEducation.model.PreexamObligation;

public class PreexamObligationDTO {

	private Long id;
	private float points;
	private String location;
	private Date dateOfObligation;
	private boolean passed; 
	private ExamDTO exam;
	
	public PreexamObligationDTO(Long id, float points, String location, Date dateOfObligation, boolean passed,
			ExamDTO exam) {
		super();
		this.id = id;
		this.points = points;
		this.location = location;
		this.dateOfObligation = dateOfObligation;
		this.passed = passed;
		this.exam = exam;
	}
	public PreexamObligationDTO(PreexamObligation preexamObligation) {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDateOfObligation() {
		return dateOfObligation;
	}
	public void setDateOfObligation(Date dateOfObligation) {
		this.dateOfObligation = dateOfObligation;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public ExamDTO getExam() {
		return exam;
	}
	public void setExam(ExamDTO exam) {
		this.exam = exam;
	} 
	

}
