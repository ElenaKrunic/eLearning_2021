package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.TypeOfFinancing;

public class TypeOfFinancingDTO {
	
	private Long id;
	private String name;
	private String code;
	public TypeOfFinancingDTO() {
		super();
	}
	public TypeOfFinancingDTO(TypeOfFinancing typeOfFinancing) {
		super();
		this.id = typeOfFinancing.getId();
		this.name = typeOfFinancing.getName();
		this.code = typeOfFinancing.getCode();
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
