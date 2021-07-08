package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.PreexamObligationStatus;

public class PreexamObligationStatusDTO {
	
	private Long id; 
	private String name; 
	private String code;
	
	public PreexamObligationStatusDTO(PreexamObligationStatus preexamObligationStatus) {
		this.id = preexamObligationStatus.getId(); 
		this.name = preexamObligationStatus.getName(); 
		this.code = preexamObligationStatus.getCode();
	}
	
	public PreexamObligationStatusDTO(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	} 
}
