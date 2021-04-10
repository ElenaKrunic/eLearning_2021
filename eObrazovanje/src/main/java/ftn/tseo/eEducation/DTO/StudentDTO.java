package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Student;

public class StudentDTO {
	private Long id;
	private String cardNumber;
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String email;
	
	private String umnc;
	
	private TypeOfFinancingDTO typeOfFinancing;

	public StudentDTO() {
		super();
	}

	public StudentDTO(Student student) {
		super();
		this.cardNumber = student.getCardNumber();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.phoneNumber = student.getPhoneNumber();
		this.email = student.getEmail();
		this.umnc = student.getUmnc();
		this.typeOfFinancing=new  TypeOfFinancingDTO(student.getTypeOfFinancing());
	
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUmnc() {
		return umnc;
	}

	public void setUmnc(String umnc) {
		this.umnc = umnc;
	}

	public TypeOfFinancingDTO getTypeOfFinancing() {
		return typeOfFinancing;
	}

	public void setTypeOfFinancing(TypeOfFinancingDTO typeOfFinancing) {
		this.typeOfFinancing = typeOfFinancing;
	}

	
	
	
	

	

}
