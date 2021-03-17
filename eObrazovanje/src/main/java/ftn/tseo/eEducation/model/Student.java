package ftn.tseo.eEducation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cardNumber",unique=true,nullable=false)
	String cardNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String email;
	
	private String umnc;
	
	private int startedCollegeIn;
	
	private int modelNumber;
	
	private String referenceNumber;
	
	private String accountNumber;
	
	@OneToOne
	@JoinColumn(name = "typeOfFinancing", referencedColumnName = "id", nullable = false)
	private TypeOfFinancing typeOfFinancing;
	
	@OneToMany(mappedBy="student" ,fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Enrollment> enrollments=new HashSet<Enrollment>();
	
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<FinancialCard> financialCards=new HashSet<FinancialCard>();
	

	@OneToMany(mappedBy="student",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Document> document=new HashSet<Document>();
	
	@OneToOne
	@JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
	private User user;

	public Student() {
		super();
	}

	public Student(Long id, String cardNumber, String firstName, String lastName, String phoneNumber, String email,
			String umnc, int startedCollegeIn, int modelNumber, String referenceNumber, String accountNumber,
			TypeOfFinancing typeOfFinancing, Set<Enrollment> enrollments, Set<FinancialCard> financialCards,
			Set<Document> documents, User user) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.umnc = umnc;
		this.startedCollegeIn = startedCollegeIn;
		this.modelNumber = modelNumber;
		this.referenceNumber = referenceNumber;
		this.accountNumber = accountNumber;
		this.typeOfFinancing = typeOfFinancing;
		this.enrollments = enrollments;
		this.financialCards = financialCards;
//		this.documents = documents;
		this.user = user;
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

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public TypeOfFinancing getTypeOfFinancing() {
		return typeOfFinancing;
	}

	public void setTypeOfFinancing(TypeOfFinancing typeOfFinancing) {
		this.typeOfFinancing = typeOfFinancing;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Set<FinancialCard> getFinancialCards() {
		return financialCards;
	}

	public void setFinancialCards(Set<FinancialCard> financialCards) {
		this.financialCards = financialCards;
	}

//	public Set<Document> getDocuments() {
//		return documents;
//	}
//
//	public void setDocuments(Set<Document> documents) {
//		this.documents = documents;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
//
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", cardNumber=" + cardNumber + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", umnc=" + umnc
//				+ ", startedCollegeIn=" + startedCollegeIn + ", modelNumber=" + modelNumber + ", referenceNumber="
//				+ referenceNumber + ", accountNumber=" + accountNumber + ", typeOfFinancing=" + typeOfFinancing
//				+ ", enrollments=" + enrollments + ", financialCards=" + financialCards + ", documents=" + documents
//				+ ", user=" + user + "]";
//	}
//	

	
	
	
	
	
}
