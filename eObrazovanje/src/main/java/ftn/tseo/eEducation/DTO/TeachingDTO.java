package ftn.tseo.eEducation.DTO;
/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
import java.util.Date;

import ftn.tseo.eEducation.model.Teaching;

public class TeachingDTO {
	
	private long id;
	private Date startDate;
	private Date endDate;
	private ProfessorDTO professor;
	private CourseDTO courseDTO;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public ProfessorDTO getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorDTO professor) {
		this.professor = professor;
	}
	public CourseDTO getCourseDTO() {
		return courseDTO;
	}
	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}
	public TeachingDTO() {
		// TODO Auto-generated constructor stub
	}
	public TeachingDTO(Teaching teaching) {
		super();
		this.id = teaching.getId();
		this.startDate = teaching.getStartDate();
		this.endDate =teaching.getEndDate();
		this.professor = new ProfessorDTO(teaching.getProfessor());
		this.courseDTO=new CourseDTO(teaching.getCourses());
		
	}
	
	
	
	
}
	
	