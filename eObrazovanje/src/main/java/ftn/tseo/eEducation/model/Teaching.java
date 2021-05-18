package ftn.tseo.eEducation.model;



import java.sql.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Teaching {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date startDate;
	
	private Date endDate;
	//kada budemo menjale ici ce user umesto profesora
	@ManyToOne
	@JoinColumn(name = "professor", referencedColumnName = "id", nullable = false)
	private Professor professor;
	
	
	@OneToOne
	@JoinColumn(name = "courses", referencedColumnName = "course_id", nullable = false)
	private Course courses;
	

	@OneToOne
	@JoinColumn(name = "teaching_type", referencedColumnName = "id", nullable = false)
	private TeachingType teachingType;

	public Teaching() {
		super();
	}
	
	




	public Teaching(Long id, Date startDate, Date endDate, Professor professor, Course courses,
			TeachingType teachingType) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.professor = professor;
		this.courses = courses;
		this.teachingType = teachingType;
	}






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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}



	public Course getCourses() {
		return courses;
	}






	public void setCourses(Course courses) {
		this.courses = courses;
	}






	public TeachingType getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}



	
}
