package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Student;

public class StudentDetailsDTO {
	

	private Long id;
	private String cardNumber;
	//buni se,jer ne postoji userDTO ko treba neka ga doda
	private UserDTO userDTO;

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String umnc;
	private int startedCollegeIn;
	private int modelNumber;
	private String typeOfFinancing;
	private String accountNumber;
	
	public StudentDetailsDTO() {
		super();
	}

	public StudentDetailsDTO(Student student) {
		super();
		id = student.getId();
		cardNumber = student.getCardNumber();
		firstName = student.getFirstName();
		lastName = student.getLastName();
		email = student.getEmail();
		phone = student.getPhoneNumber();
		umnc = student.getUmnc();
		startedCollegeIn = student.getStartedCollegeIn();
		modelNumber =student.getModelNumber();
		accountNumber = student.getAccountNumber();
		typeOfFinancing=student.getTypeOfFinancing().getName();
		userDTO=new UserDTO(student.getUser());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUmnc() {
		return umnc;
	}

	public void setUmnc(String umnc) {
		this.umnc = umnc;
	}

	public int getStartedCollegeIn() {
		return startedCollegeIn;
	}

	public void setStartedCollegeIn(int startedCollegeIn) {
		this.startedCollegeIn = startedCollegeIn;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTypeOfFinancing() {
		return typeOfFinancing;
	}

	public void setTypeOfFinancing(String typeOfFinancing) {
		this.typeOfFinancing = typeOfFinancing;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
}
