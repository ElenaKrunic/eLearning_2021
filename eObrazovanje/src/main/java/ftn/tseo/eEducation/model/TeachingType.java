package ftn.tseo.eEducation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class TeachingType {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String code;
	
	@OneToMany(mappedBy="teachingType", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Professor> professors=new HashSet<Professor>();

	public TeachingType() {
		super();
	}

	public TeachingType(Long id, String name, String code, Set<Professor> professors) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.professors = professors;
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

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	@Override
	public String toString() {
		return "TeachingType [id=" + id + ", name=" + name + ", code=" + code + ", professors=" + professors + "]";
	}
	
	
	

}
