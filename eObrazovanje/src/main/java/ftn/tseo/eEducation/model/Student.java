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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private Long startedCollegeIn;
	
	private int modelNumber;
	
	private String referenceNumber;
	
	private String accountNumber;
	
	//testno 
	private Double cardAmount; 
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "type_of_financing", referencedColumnName = "id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TypeOfFinancing typeOfFinancing;
	
	@JsonIgnore
	@OneToMany(mappedBy="student" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Enrollment> enrollments=new HashSet<Enrollment>();
	
//	@JsonIgnore
	@OneToOne
//	@JoinColumn(name = "financial_card", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private FinancialCard financialCards;
	
	@JsonIgnore
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Document> document=new HashSet<Document>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<PreexamObligation> preexamObligation;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	/*
	@ManyToOne
	@JoinColumn(name="user", referencedColumnName = "id", nullable = false)
	private User user; 
	*/
	
	public Set<Document> getDocument() {
		return document;
	}

	
	public void setDocument(Set<Document> document) {
		this.document = document;
	}

	public Set<PreexamObligation> getPreexamObligation() {
		return preexamObligation;
	}

	public void setPreexamObligation(Set<PreexamObligation> preexamObligation) {
		this.preexamObligation = preexamObligation;
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Student() {
		super();
	}


	


	public Student(Long id, String cardNumber, String firstName, String lastName, String phoneNumber, String email,
			String umnc, Long startedCollegeIn, int modelNumber, String referenceNumber, String accountNumber,
			Double cardAmount, TypeOfFinancing typeOfFinancing, Set<Enrollment> enrollments,
			FinancialCard financialCards, Set<Document> document, Set<PreexamObligation> preexamObligation, User user) {
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
		this.cardAmount = cardAmount;
		this.typeOfFinancing = typeOfFinancing;
		this.enrollments = enrollments;
		this.financialCards = financialCards;
		this.document = document;
		this.preexamObligation = preexamObligation;
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


	public Long getStartedCollegeIn() {
		return startedCollegeIn;
	}


	public void setStartedCollegeIn(Long startedCollegeIn) {
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


	public Double getCardAmount() {
		return cardAmount;
	}


	public void setCardAmount(Double cardAmount) {
		this.cardAmount = cardAmount;
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


	public FinancialCard getFinancialCards() {
		return financialCards;
	}


	public void setFinancialCards(FinancialCard financialCards) {
		this.financialCards = financialCards;
	}
	
	/*
	public void addFinancialCard(FinancialCard financialCard) {
		if(financialCard.getStudent() != null) {
			financialCard.getStudent().removeFinancialCard(financialCard);
		financialCard.setStudent(this);
		getFinancialCards()
		}
	}
	
	public void removeFinancialCard(FinancialCard financialCard) {
		financialCard.setStudent(null);
		getFinancialCards().setStudent(null);
	}
	*/

	
}
