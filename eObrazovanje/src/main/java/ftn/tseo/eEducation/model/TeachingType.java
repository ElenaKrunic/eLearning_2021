package ftn.tseo.eEducation.model;




import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeachingType {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String code;
	

	public TeachingType() {
		super();
	}
	

	
	public TeachingType(Long id, String name, String code) {
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



	@Override
	public String toString() {
		return "TeachingType [id=" + id + ", name=" + name + ", code=" + code +"]";
	}
	
	
	

}
