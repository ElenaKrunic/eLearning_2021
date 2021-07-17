package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.User;

/**
 * 
 * @author Dunja J. Martinovic 
 *
 */
public class ProfessorDTO {
	
	private Long id;
	private String lastName;
	private String firstName;

	private UserDTO user;
	public ProfessorDTO() {}

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
		this.user=new UserDTO(professor.getUser());
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
	
	
	
	

}
