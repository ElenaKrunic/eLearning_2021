package ftn.tseo.eEducation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@JoinColumn(name = "course", referencedColumnName = "course_id", nullable = false)
	private Course course;
	

	@OneToOne
	@JoinColumn(name = "teachingtype", referencedColumnName = "id", nullable = false)
	private TeachingType teachingType;

	public Teaching() {
		super();
	}
	
	




	public Teaching(Long id, Date startDate, Date endDate, Professor professor, Course course,
			TeachingType teachingType) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.professor = professor;
		this.course = course;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public TeachingType getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}



	@Override
	public String toString() {
		return "Teaching [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", professor=" + professor
				+ ", course=" + course + ", teachingType=" + teachingType + "]";
	}
	
	
	
}
