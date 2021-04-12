package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Professor;

/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
public class ProfessorDTO {
	
	private Long id;
	private String lastName;
	private String firstName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProfessorDTO(Professor professor) {
		this.id = professor.getId();
		this.firstName=professor.getFirstName();
		this.lastName=professor.getLastName();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
	

}
