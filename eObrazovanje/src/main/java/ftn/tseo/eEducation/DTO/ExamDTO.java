package ftn.tseo.eEducation.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ftn.tseo.eEducation.model.Exam;
/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
public class ExamDTO {
	
	private Long id;
	private int grade;
	private float points;
	private Date examDate;
	//testna
	private Long student;

	
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
	
	
	public ExamDTO(Exam exam) {
		this.id= exam.getId();
		this.grade= exam.getGrade();
		this.points= exam.getPoints();
		this.examDate= exam.getExamDate();
		
	}
	
	public Long getStudent() {
		return student;
	}
	public void setStudent(Long student) {
		this.student = student;
	}
}
