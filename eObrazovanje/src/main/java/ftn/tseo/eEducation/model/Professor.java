package ftn.tseo.eEducation.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Teaching> teachings;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
	private User user;

	public Professor() {
		super();
	}



	public Professor(Long id, String firstName, String lastName, User user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}



	public Long getId() {
		return id;
	}
	



	public Set<Teaching> getTeachings() {
		return teachings;
	}



	public void setTeachings(Set<Teaching> teachings) {
		this.teachings = teachings;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	

}
