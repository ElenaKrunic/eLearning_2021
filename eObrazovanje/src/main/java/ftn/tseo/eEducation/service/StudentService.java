package ftn.tseo.eEducation.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Document;

import ftn.tseo.eEducation.model.Exam;

import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;

import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PaymentRepository;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;
import ftn.tseo.eEducation.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	
	@Autowired
	FinancialCardRepository financialCardRepository;
	@Autowired
	PreExamObligationRepository preExamRepo;
	
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
	
	public Long registerExam(Long studentId, Long examId,String location,float points) {
		
		Exam exam = examRepository.findById(examId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		
//		kako cu izvuci za sve ispite naziv kursa kada promenim u jpql
//		String course=exam.getEnrollment().getCourse().getTitle();
		if(exam != null && student != null) {
			PreexamObligation examReg = new PreexamObligation();
			examReg.setExam(exam);
			examReg.setExamObligationStatus(null);
			examReg.setLocation(location);
			examReg.setPoints(points);
			examReg.setObligationType(null);
			
			preExamRepo.save(examReg);
			
			float cost = exam.getExamPeriod().getPaymentAmount();
			FinancialCard transaction = findStudentFinancialCard(studentId);
			
			
			Payment payment=new Payment();
			payment.setDateOfPayment(new Date(new java.util.Date().getTime()));
			payment.setPaymentAmount((float) cost);
			payment.setPaymentDescription("Prijava ispita");
			payment.setFinancialCard(transaction);
			
			paymentRepo.save(payment);
			
			transaction.setPayments((Set<Payment>) payment);
			transaction.setStudent(student);
			transaction.setTotalCost(cost);
			transaction.setTotalPayment(cost);
			
			transaction.setInitialState(transaction.getInitialState() - cost);
			financialCardRepository.save(transaction);
			
			return examReg.getId();
		}
		return (long) 0;
	}
	
	public List<Exam> findTakenExams(Long id) {
	
		Student student = studentRepository.findById(id).orElse(null);
		
		//pitati na osnovu upita da li se dobro izvlace podaci 
		List<Exam> exams = new ArrayList<Exam>();
		if(student != null) {
			exams = studentRepository.findStudentExams(id);
		}
		
	

		return exams;
	}
	
	public List<FinancialCard> getFinancialCardInfo(Long id) {
		List<FinancialCard> studentsTransactions = new ArrayList<FinancialCard>();
		Student student = studentRepository.findById(id).orElse(null);
		
		if(student != null) {
			if(student.getFinancialCards().size() > 0) {
				for(FinancialCard fCard : student.getFinancialCards()) {
					studentsTransactions.add(fCard);
				}
			}
		}
		
		return studentsTransactions;
	}
	
	public List<Payment> getStudentFinancialCard(Long id) {
		
		List<Payment> financialCardPayment = new ArrayList<Payment>();
		for (Payment p: studentRepository.getStudentFinancialCard(id)) {
			financialCardPayment.add(p);
		}
		return financialCardPayment;
		
	}
	
	public FinancialCard findStudentFinancialCard(Long id) {
		
		FinancialCard financialCardForStudent= studentRepository.findStudentFinancialCard(id);
		return financialCardForStudent;
		
	}
	
	
	public List<Exam> getCurrentExams(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		List<Exam> allExams = examRepository.findAll();
		List<Exam> currentExams = new ArrayList<>();
//		List<Exam> examsTaken=examRepository.findStudentExams(id);
		Date currentDate = new Date(new java.util.Date().getTime());
		
		if(student != null) {
			for (Exam e : allExams) {
				if(e.getExamPeriod().getEndDate().after(currentDate) && 
						e.getExamPeriod().getStartDate().before(currentDate)) {
					
						currentExams.add(e);
					
				}
			}
			
		}
		return currentExams;
		
	}
	@SuppressWarnings("unused")
	private List<Document > getDocumentsForStudents(Long id){
		List<Document> documentForStudent = new ArrayList<Document>();
		for (Document d: studentRepository.getDocumentsForStudents(id)) {
			documentForStudent.add(d);
		}
		return documentForStudent;
	}
}
