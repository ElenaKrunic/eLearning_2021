package ftn.tseo.eEducation.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ftn.tseo.eEducation.model.Exam;

public class ExamDTO {
	
	private Long id;
	private int grade;
	private float points;
	private Date examDate;
	private PreExamObligationDTO examObligationDTOs;
	private ExamPeriodDTO examPeriodDTOs;
	private EnrollmentDTO enrollmentDTOs;
	
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
	
	
	public PreExamObligationDTO getExamObligationDTOs() {
		return examObligationDTOs;
	}
	public void setExamObligationDTOs(PreExamObligationDTO examObligationDTOs) {
		this.examObligationDTOs = examObligationDTOs;
	}
	public ExamPeriodDTO getExamPeriodDTOs() {
		return examPeriodDTOs;
	}
	public void setExamPeriodDTOs(ExamPeriodDTO examPeriodDTOs) {
		this.examPeriodDTOs = examPeriodDTOs;
	}
	public EnrollmentDTO getEnrollmentDTOs() {
		return enrollmentDTOs;
	}
	public void setEnrollmentDTOs(EnrollmentDTO enrollmentDTOs) {
		this.enrollmentDTOs = enrollmentDTOs;
	}
	
	public ExamDTO(Long id, int grade, float points, Date examDate, PreExamObligationDTO examObligationDTOs,
			ExamPeriodDTO examPeriodDTOs, EnrollmentDTO enrollmentDTOs) {
		super();
		this.id = id;
		this.grade = grade;
		this.points = points;
		this.examDate = examDate;
		this.examObligationDTOs = examObligationDTOs;
		this.examPeriodDTOs = examPeriodDTOs;
		this.enrollmentDTOs = enrollmentDTOs;
	}
	
	public ExamDTO(Exam exam) {
		this.id= exam.getId();
		this.grade= exam.getGrade();
		this.points= exam.getPoints();
		this.examDate= exam.getExamDate();
		// pravi gresku jer su ovi DTO-ovi prazni
		this.examObligationDTOs= new PreExamObligationDTO(exam.getPreexamObligation());
		this.examPeriodDTOs= new ExamPeriodDTO(exam.getExamPeriod());
		this.enrollmentDTOs= new EnrollmentDTO(exam.getEnrollment());
	}
	
	
	
	
	
	

}
