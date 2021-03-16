package ftn.tseo.eEducation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeOfFinancing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	String name;
	@Column(name = "code", unique = true, nullable = false)
	String code;
	
	@OneToMany(mappedBy="typeOfFinancing",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Student> students=new HashSet<Student>();

	public TypeOfFinancing(Long id, String name, String code, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.students = students;
	}

	public TypeOfFinancing() {
		super();
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "TypeOfFinancing [id=" + id + ", name=" + name + ", code=" + code + ", students=" + students + "]";
	}
	
	
	

}
