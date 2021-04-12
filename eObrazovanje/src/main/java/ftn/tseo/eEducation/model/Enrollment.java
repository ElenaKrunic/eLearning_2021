
package ftn.tseo.eEducation.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Mirjana Zaric 
 *
 */
@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollment_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "enrollment_start_date", unique = false, nullable = true)
	public Date startDate;

	@Column(name = "enrollment_end_date", unique = false, nullable = true)
	private Date endDate;
	
	@OneToOne
	@JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
	private Student student;
	
	@OneToOne
	@JoinColumn(name = "courses", referencedColumnName = "course_id", nullable = false)
	private Course courses;
	
	@OneToMany(mappedBy="enrollments", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<Exam> exam= new HashSet<Exam>();

	
	public Enrollment() {
		
		super();
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



	public Course getCourses() {
		return courses;
	}

	public void setCourses(Course courses) {
		this.courses = courses;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Exam> getExam() {
		return exam;
	}

	public void setExam(Set<Exam> exam) {
		this.exam = exam;
	}

	

	

}
