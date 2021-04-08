package ftn.tseo.eEducation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Elena Krunic 
 *
 */

@Entity
public class DocumentType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String code;

	@OneToMany(mappedBy="documentType",fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Set<Document> documents = new HashSet<Document>();

	public DocumentType() {
		super();
	}
	

	public DocumentType(Long id, String name, String code, Set<Document> documents) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.documents = documents;
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

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	

}
