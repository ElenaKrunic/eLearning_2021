package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.User;

public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	
	public UserDTO(User user) {
		
		this.id=user.getId();
		this.password=user.getPassword();
		this.username=user.getUsername();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
