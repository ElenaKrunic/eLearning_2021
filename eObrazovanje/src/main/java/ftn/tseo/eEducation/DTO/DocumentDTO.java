package ftn.tseo.eEducation.DTO;

import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Student;

public class DocumentDTO {
	
	private Long id;
	private String url;
	private String title;
	private StudentDTO studentDTO;
	private String documentType;
	public DocumentDTO() {
		super();
	}
	public DocumentDTO(Document document) {
		super();
		this.id = document.getId();
		this.url =document.getUrl();
		this.title = document.getTitle();
		this.studentDTO = new StudentDTO(document.getStudent());
		this.documentType =document.getDocumentType().getName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}
	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	
}
