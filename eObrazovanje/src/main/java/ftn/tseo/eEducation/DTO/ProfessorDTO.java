package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Professor;

/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
public class ProfessorDTO {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProfessorDTO(Professor professor) {
		this.id = professor.getId();
	}
	
	
	
	

}
