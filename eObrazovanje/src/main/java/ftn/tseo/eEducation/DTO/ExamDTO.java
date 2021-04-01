package ftn.tseo.eEducation.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.Teaching;

public class ExamDTO {
	private Long id;

	private int grade;
	private float points;
	private Date examDate;
	private ExamPeriodDTO examPeriodDTO;
	private EnrollmentDTO enrollmentDTO;
	private String courseName;
	private String professorName;

	@SuppressWarnings("unchecked")
	public ExamDTO(Exam exam) {
		super();
		id = exam.getId();
		courseName=exam.getEnrollment().getCourse().getTitle();
		if(( (Set<Teaching>) exam.getEnrollment().getCourse().getTeachings().iterator().next().getProfessor()).size()>0) {
			professorName=exam.getEnrollment().getCourse().getTeachings().iterator().next().getProfessor().getFirstName()+exam.getEnrollment().getCourse().getTeachings().iterator().next().getProfessor().getLastName();
		}
		
		grade = exam.getGrade();
		points = exam.getPoints();
		examDate = exam.getExamDate();
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
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	
	
	

}
