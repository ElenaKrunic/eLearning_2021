
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
	private int id;
	
	@Column(name = "enrollment_start_date", unique = false, nullable = true)
	public Date startDate;

	@Column(name = "enrollment_end_date", unique = false, nullable = true)
	private Date endDate;
	
	@ManyToOne
	 @JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
	private Student student;
	
	@ManyToOne
    @JoinColumn(name = "course", referencedColumnName = "course_id", nullable = false)
	private Course course;
	
	@OneToMany(mappedBy="enrollment", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private Set<Exam> exam= new HashSet<Exam>();

	
	public Enrollment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

//	public Student getStudent() {
//		return student_enrollment;
//	}

//	public void setStudent(Student student) {
//		this.student_enrollment = student;
//	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
//
//	public Student getStudent_enrollment() {
//		return student_enrollment;
//	}
//
//	public void setStudent_enrollment(Student student_enrollment) {
//		this.student_enrollment = student_enrollment;
//	}

//	public Set<Exam> getEnrollments_exams() {
//		return enrollments_exams;
//	}
//
//	public void setEnrollments_exams(Set<Exam> enrollments_exams) {
//		this.enrollments_exams = enrollments_exams;
//	}
//	


	

}
