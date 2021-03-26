package ftn.tseo.eEducation.DTO;

import java.sql.Date;

import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.ExamPeriod;
/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
public class ExamPeriodDTO {
	
	private Long id;
	private String name;
	private Date startDate;
	private Date endDate;
	private float paymentAmount;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public float getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
	public ExamPeriodDTO(ExamPeriod examPeriod) {
		this.id=examPeriod.getId();
		this.name=examPeriod.getName();
		this.startDate=examPeriod.getStartDate();
		this.endDate=examPeriod.getEndDate();
		this.paymentAmount=examPeriod.getPaymentAmount();
		
	}
	
	
	
	

}
