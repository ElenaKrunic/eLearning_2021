package ftn.tseo.eEducation.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import ftn.tseo.eEducation.DTO.DocumentDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.DTO.StudentDTO;
import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;

import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.PayOut;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Professor;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.CourseRepository;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PaymentRepository;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;
import ftn.tseo.eEducation.repository.ProfessorRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	FinancialCardRepository financialCardRepository;
	
	@Autowired
	PreExamObligationRepository preExamRepo;
	
	@Autowired 
	TeachingRepository teachingRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	public Student findOne(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void remove(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Student findByCard(String cardNumber) {
		return studentRepository.findOneByCardNumber(cardNumber);
	}
	
	public List<Student> findByLastName(String lastName) {
		return studentRepository.findAllByLastName(lastName);
	}
	
	public List<StudentDTO> findProffesorStudent(Long id){
		Set<Enrollment> enrollments=teachingRepo.findTeachingByProfessorId(id).getCourses().getEnrollments();
		Set<Student> students=new HashSet<Student>();
		List<StudentDTO> studentToDTO=new ArrayList<>();
		for(Enrollment e:enrollments) {
			students.add(e.getStudent());
		}
		for(Student s : students) {
			studentToDTO.add(new StudentDTO(s));
		}
		System.out.println("Get proffesor students"+students);
		return studentToDTO;
		
	}
	public Student findUserByUsername(String username) {
		Student student= studentRepository.findByUser_Username(username);
		System.out.println("Student" + student);
		return student;
		
		
	}
	
	
	//proveriti da li treba examDTO ili exam registration i da li je potrebno dodavati atribut bool za polozeni ispit u celosti
		
	//Check it once more
	
//	// mislim da nije dobro
//		public List<Student> getEnrolledStudents(long id) {
//			Professor professor= professorRepository.findById(id).orElse(null);
//				return studentRepository.getEnrolledStudentsInProfessorsCourse(id);
//		}
//		
}
