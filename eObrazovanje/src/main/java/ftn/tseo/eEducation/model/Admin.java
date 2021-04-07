package ftn.tseo.eEducation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	
//	@OneToOne
//	@JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
//	private User user;
	
	public Admin() {
		super();
	}
	
	
	public Admin(Long id, User user) {
		super();
		this.id = id;
//		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Admin(Long id) {
		super();
		this.id = id;
	}

//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}


	
	

	
	
}
