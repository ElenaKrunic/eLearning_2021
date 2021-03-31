package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Student;

public class StudentBasicDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private StudentBasicDTO() {
		super();
	}
	public StudentBasicDTO(Student student) {
		super();
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
