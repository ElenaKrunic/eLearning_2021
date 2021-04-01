package ftn.tseo.eEducation.DTO;
/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
import java.util.Date;

public class TeachingDTO {
	
	private long id;
	private Date startDate;
	private Date endDate;
	private ProfessorDTO professorDTO;
	
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
	public ProfessorDTO getProfessorDTO() {
		return professorDTO;
	}
	public void setProfessorDTO(ProfessorDTO professorDTO) {
		this.professorDTO = professorDTO;
	}
	
	public TeachingDTO(long id, Date startDate, Date endDate, ProfessorDTO professorDTO) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.professorDTO = professorDTO;
	}
	
	
}
	
	