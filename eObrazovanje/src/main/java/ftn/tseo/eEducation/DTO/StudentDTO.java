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
	private Long startedCollegeIn;
	private String accountNumber;
	private int modelNumber;
//
//	private FinancialCardDTO financialCardDTO;
	private Double cardAmount; 
	private String referenceNumber; 
	
	private TypeOfFinancingDTO typeOfFinancing;
	private UserDTO user;
	public StudentDTO() {
		super();
	}

	public StudentDTO(Student student) {
		super();
		this.id=student.getId();
		this.cardNumber = student.getCardNumber();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.phoneNumber = student.getPhoneNumber();
		this.email = student.getEmail();
		this.umnc = student.getUmnc();
//
//		this.financialCardDTO=new FinancialCardDTO(student.getFinancialCards());
		this.typeOfFinancing=new  TypeOfFinancingDTO(student.getTypeOfFinancing());

		this.accountNumber=student.getAccountNumber();
		this.modelNumber=student.getModelNumber();
		this.startedCollegeIn=student.getStartedCollegeIn();

		this.user=new UserDTO(student.getUser());

		this.cardAmount = student.getCardAmount(); 
		this.referenceNumber = student.getReferenceNumber();

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

//	public FinancialCardDTO getFinancialCardDTO() {
//		return financialCardDTO;
//	}
//
//	public void setFinancialCardDTO(FinancialCardDTO financialCardDTO) {
//		this.financialCardDTO = financialCardDTO;
//	}

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

	public Long getStartedCollegeIn() {
		return startedCollegeIn;
	}

	public void setStartedCollegeIn(Long startedCollegeIn) {
		this.startedCollegeIn = startedCollegeIn;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public Double getCardAmount() {
		return cardAmount;
	}

	public void setCardAmount(Double cardAmount) {
		this.cardAmount = cardAmount;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
}
