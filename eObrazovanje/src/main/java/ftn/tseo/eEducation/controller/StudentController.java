package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.CourseDTO;
import ftn.tseo.eEducation.DTO.DocumentDTO;
import ftn.tseo.eEducation.DTO.EnrollmentDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.DTO.StudentDTO;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.ExamPeriod;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.TypeOfFinancing;
import ftn.tseo.eEducation.repository.EnrollmentRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.service.DocumentService;
import ftn.tseo.eEducation.service.EnrollmentService;
import ftn.tseo.eEducation.service.ExamService;
import ftn.tseo.eEducation.service.FinancialCardService;
import ftn.tseo.eEducation.service.PaymentService;
import ftn.tseo.eEducation.service.PayoutService;
import ftn.tseo.eEducation.service.PreExamObligationService;
import ftn.tseo.eEducation.service.StudentService;
import ftn.tseo.eEducation.service.TypeOfFinancingService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService; 
	
	@Autowired
	ExamService examService; 
	
	@Autowired
	PayoutService payoutService;
	
	@Autowired
	PaymentService paymentService;

	@Autowired
	DocumentService documentService;
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@Autowired 
	PreExamObligationService preexamObligationService; 
	
	@Autowired 
	FinancialCardService financialCardService;
	
	@Autowired 
	TypeOfFinancingService typeOfFinancingService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="students/me")
	public ResponseEntity<?> getStudent(@AuthenticationPrincipal UserDetails userDetails){
		Student student=studentService.findUserByUsername(userDetails.getUsername());
		System.out.println("student me"+student);
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllStudents(
			@RequestParam(required=false) String firstName, 
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="3") int size,
			@RequestParam(defaultValue="id, desc") String[] sort) {
		
		try {
			
			 List<Order> orders = new ArrayList<Order>();

		      if (sort[0].contains(",")) {
		        // will sort more than 2 fields
		        // sortOrder="field, direction"
		        for (String sortOrder : sort) {
		          String[] _sort = sortOrder.split(",");
		          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
		        }
		      } else {
		        // sort=[field, direction]
		        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
		      }
		      
			List<Student> students = new ArrayList<Student>(); 

			Pageable paging = PageRequest.of(page, size); 
			
			Page<Student> pageStudents; 
			
			if (firstName == null) 
				pageStudents = studentRepository.findAll(paging);
			else 
				pageStudents = studentRepository.findByFirstName(firstName, paging); 
			
			students = pageStudents.getContent(); 
			
			Map<String, Object> response = new HashMap<>();
			response.put("students", students); 
			response.put("currentPage", pageStudents.getNumber()); 
			response.put("totalItems", pageStudents.getTotalElements());
			response.put("totalPages", pageStudents.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="students/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@PostMapping(value="/students", consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){		
		Student student = new Student();
		student.setCardNumber(studentDTO.getCardNumber());
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmail(studentDTO.getEmail());
		student.setUmnc(studentDTO.getUmnc());
		student.setPhoneNumber(studentDTO.getPhoneNumber());
		student.setAccountNumber(student.getAccountNumber());
		student.setCardAmount(studentDTO.getCardAmount());
		student.setReferenceNumber(studentDTO.getReferenceNumber());
		student.setModelNumber(studentDTO.getModelNumber());
		student.setStartedCollegeIn(studentDTO.getStartedCollegeIn());
		//TypeOfFinancing typeOfFinancing =  typeOfFinancingService.findOne(studentDTO.getTypeOfFinancing().getId());
		//student.setTypeOfFinancing(typeOfFinancing);
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/students/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		//a student must exist
		Student student = studentService.findOne(studentDTO.getId()); 
		System.out.println("Student koji je pronadjen"+student);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		student.setId(studentDTO.getId());
		student.setCardNumber(studentDTO.getCardNumber());
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmail(studentDTO.getEmail());
		student.setUmnc(studentDTO.getUmnc());
		student.setPhoneNumber(studentDTO.getPhoneNumber());
		student.setAccountNumber(student.getAccountNumber());
		student.setModelNumber(studentDTO.getModelNumber());
		student.setStartedCollegeIn(studentDTO.getStartedCollegeIn());
		student.setCardAmount(studentDTO.getCardAmount());
		student.setReferenceNumber(studentDTO.getReferenceNumber());
		student.setModelNumber(studentDTO.getModelNumber());
		//TypeOfFinancing typeOfFinancing =  typeOfFinancingService.findOne(studentDTO.getTypeOfFinancing().getId());
		
		//student.setTypeOfFinancing(typeOfFinancing);
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
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
		return examService.getCurrentExams(id);
	}
	
	@GetMapping(value="/{studentId}/exams")
	private List<ExamDTO> getTakenExams(@PathVariable("studentId") Long id) {
		return examService.findStudentExams(id);
	}
	
	@GetMapping(value="/{studentId}/financial-card")
	private FinancialCardDTO getFinancialCardInfo(@PathVariable("studentId") Long id) {
		return financialCardService.findFinancialCardForStudent(id);
	}
	
	@GetMapping(value="/{id}/financial-payment")
	private List<PaymentDTO> getStudentPayment(@PathVariable("id") Long id) {
		return paymentService.getStudentFinancialCardPayment(id);
	}
	@GetMapping(value="/{studentId}/documents")
	private List<DocumentDTO> getStudentDocuments(@PathVariable("studentId") Long id) {
		return documentService.findDocumentsForStudents(id);
	}
	
	@GetMapping(value="/{studentId}/financial-payout")
	private List<PayoutDTO> getStudentPayout(@PathVariable("studentId") Long id) {
		return payoutService.getStudentFinancialCardPayout(id);
	}
	@GetMapping(value="/{studentId}/enrollments")
	private List<EnrollmentDTO> getStudentEnrollments(@PathVariable("studentId") Long id) {
		return enrollmentService.findEnrollmentForStudent(id);
	}
	

	//helper method 
			private Sort.Direction getSortDirection(String direction) {
			    if (direction.equals("asc")) {
			      return Sort.Direction.ASC;
			    } else if (direction.equals("desc")) {
			      return Sort.Direction.DESC;
			    }

			    return Sort.Direction.ASC;
			}
		
}
