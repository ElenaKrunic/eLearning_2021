package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Authority;

public class AuthorityDTO { 

	private Long id; 
	private String name;
	
	public AuthorityDTO() {
		super();
	}
	
	public AuthorityDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public AuthorityDTO(Authority authority) {
		this(authority.getId(), authority.getName());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
}
