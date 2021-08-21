package ftn.tseo.eEducation.DTO;

import java.util.ArrayList;
import java.util.List;

import ftn.tseo.eEducation.model.Authority;
import ftn.tseo.eEducation.model.User;
import ftn.tseo.eEducation.model.UserAuthority;

public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private List<AuthorityDTO> authorities = new ArrayList<AuthorityDTO>(); 
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		
		this.id=user.getId();
		this.password=user.getPassword();
		this.username=user.getUsername();
		for (UserAuthority userAuthority: user.getUserAuthorities()) {
			this.authorities.add(new AuthorityDTO(userAuthority.getAuthority()));
		}
	}

	public List<AuthorityDTO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityDTO> authorities) {
		this.authorities = authorities;
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
	
	public String authorityToString() {
		String authorityString =""; 
		for(AuthorityDTO authority : this.authorities) {
			authorityString += authority.getName()+ " "; 
		}
		return authorityString;
	}
	
	

}
