package ftn.tseo.eEducation.model;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
	private User user;
	
	

	public Professor() {
		super();
	}

	public Professor(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", user=" + user + "]";
	}
	
	
	
	
	
	
	
	

}
