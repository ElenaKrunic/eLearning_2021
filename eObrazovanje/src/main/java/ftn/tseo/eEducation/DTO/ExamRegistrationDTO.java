package ftn.tseo.eEducation.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.PreexamObligationStatus;
import ftn.tseo.eEducation.model.Teaching;
/**
 * 
 * @author Dunja J. Martinovic 
 *
 */

public class ExamRegistrationDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date date;
	private float point;
	private String obligationType;
	private boolean status;
	private String courseName;
	private String courseProfessor;
	private Long studentId;
	private int ECTS;
	private int finalGrade;
	private float paymentAmount;
	private ExamDTO examDTO;
	
	public ExamRegistrationDTO() {
		super();
	}

	public ExamRegistrationDTO(PreexamObligation examReg) {
		this.id=examReg.getId();
		this.date = examReg.getExam().getExamDate();
		this.point = examReg.getExam().getPoints();
		this.status=examReg.isPassed();
		obligationType=examReg.getObligationType().getName();
		this.courseName=examReg.getExam().getEnrollment().getCourse().getTitle();
		//pitati profesora kako da se odradi ovaj deo za profesora
//		this.courseProfessor=examReg.getExam().getEnrollment().getCourse().getTeachings().get(0).getFirstName() + examReg.getExam().getCourse().getProfessors().get(0).getLastName();

		this.studentId=examReg.getExam().getEnrollment().getStudent().getId();
		this.ECTS = examReg.getExam().getEnrollment().getCourse().getECTS();
		this.finalGrade = examReg.getExam().getGrade();
		this.paymentAmount = examReg.getExam().getExamPeriod().getPaymentAmount();
		examDTO=new ExamDTO(examReg.getExam());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseProfessor() {
		return courseProfessor;
	}

	public void setCourseProfessor(String courseProfessor) {
		this.courseProfessor = courseProfessor;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getObligationType() {
		return obligationType;
	}

	public void setObligationType(String obligationType) {
		this.obligationType = obligationType;
	}

	public ExamDTO getExamDTO() {
		return examDTO;
	}

	public void setExamDTO(ExamDTO examDTO) {
		this.examDTO = examDTO;
	}
	
	
}