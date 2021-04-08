package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.DocumentDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamRegistrationDTO;
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.DTO.StudentDTO;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.service.ExamService;
import ftn.tseo.eEducation.service.StudentService;


@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService; 
	
	@Autowired
	private ExamService examService; 
	
	@Autowired 
	private PreexamObligation preexamObligationService; 
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		List<Student> students = studentService.findAll();
		//convert students to DTOs
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){		
		Student student = new Student();
		student.setCardNumber(studentDTO.getCardNumber());
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		//a student must exist
		Student student = studentService.findOne(studentDTO.getId()); 
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		student.setCardNumber(studentDTO.getCardNumber());
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
/*	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamRegistrationDTO> registerExam(@RequestBody ExamRegistrationDTO dto) {
		
		Exam exam = new Exam(); 
		exam = examService.register(dto);
		
		if(exam == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ExamRegistrationDTO(exam), HttpStatus.CREATED);
	}*/
	
	@GetMapping(value="/{studentId}/exams-current")
	private List<ExamDTO> getCurrentExamsForStudent(@PathVariable("studentId") Long id) {
		return studentService.getCurrentExams(id);
	}
	
	@GetMapping(value="/{studentId}/exams")
	private List<ExamDTO> getTakenExams(@PathVariable("studentId") Long id) {
		return studentService.findTakenExams(id);
	}
	
	@GetMapping(value="/{studentId}/financial-card")
	private List<FinancialCardDTO> getFinancialCardInfo(@PathVariable("studentId") Long id) {
		return studentService.getFinancialCardInfo(id);
	}
	
	@GetMapping(value="/{studentId}/financial-card2")
	private FinancialCardDTO getFinancialCardInfo2(@PathVariable("studentId") Long id) {
		return studentService.findStudentFinancialCard(id);
	}
	
	@GetMapping(value="/{studentId}/documents")
	private List<DocumentDTO> getDocuments(@PathVariable("studentId") Long id) {
		return studentService.getDocumentsForStudents(id);
	}
	
	@GetMapping(value="/{studentId}/financial-payment")
	private List<PaymentDTO> getStudentPayment(@PathVariable("studentId") Long id) {
		return studentService.getStudentFinancialCardPayment(id);
	}
	
	@GetMapping(value="/{studentId}/financial-payout")
	private List<PayoutDTO> getStudentPayout(@PathVariable("studentId") Long id) {
		return studentService.getStudentFinancialCardPayout(id);
	}
	
	
}
