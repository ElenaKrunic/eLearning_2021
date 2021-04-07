package ftn.tseo.eEducation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @author Elena Krunic 
 *
 */

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String url;
	
	//veza ka studentu 
	@ManyToOne
	@JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
	private Student student;
	
	//veza ka tipu dokumenata 
	@ManyToOne
	@JoinColumn(name = "document_type", referencedColumnName = "id", nullable = false)
	private DocumentType documentType;
	
	public Document() {
		super();
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Document(Long id, String title, String url, Student student, DocumentType documentType) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.student = student;
		this.documentType = documentType;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Document(Long id, String title, String url) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
	}

	


}
