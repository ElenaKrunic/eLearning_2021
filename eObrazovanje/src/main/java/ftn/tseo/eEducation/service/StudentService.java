package ftn.tseo.eEducation.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.repository.DocumentRepository;
import ftn.tseo.eEducation.repository.EnrollmentRepository;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	
	@Autowired
	FinancialCardRepository financialCardRepository;
	
	@Autowired
	DocumentRepository documentRepository;
	
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
	
//	@Override
//	public int registerExam(Long studentId, Long examId) {
//		// TODO Auto-generated method stub
//		Exam exam = examRepository.findById(examId).orElse(null);
//		Student student = studentRepository.findById(studentId).orElse(null);
//		
//		if(exam != null && student != null) {
//			PreexamObligation examReg = new PreexamObligation();
//			examReg.setExam(exam);
//			examReg.setStudent(student);
//			examReg.setStatus(EExamStatus.ND);
//			examReg.setExamPeriod(exam.getExamPeriod());
//			examReg.setFinalGrade(5);
//			examRegistrationRepository.save(examReg);
//			
//			double cost = exam.getExamPeriod().getPaymentAmount();
//			FinancialCard transaction = new FinancialCard();
//			transaction.setPayments(new Date(new java.util.Date().getTime()));
//			transaction.setPaymentAmount(cost);
//			transaction.setPaymentDescription("Prijava ispita");
//			transaction.setStudent(student);
//			transaction.setTotalCost(cost);
//			transaction.setTotalPayment(cost);
//			
//			financialCardRepository.save(transaction);
//			
//			student.setAccountBalance(student.getAccountBalance() - cost);
//			studentRepository.save(student);
//			return examReg.getId();
//		}
//		return 0;
//	}
	
	public List<Exam> findTakenExams(Long id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		
		//pitati na osnovu upita da li se dobro izvlace podaci 
		List<Exam> exams = new ArrayList<Exam>();
		if(student != null) {
			exams = examRepository.findStudentExams(id);
		}
		
	

		return exams;
	}
	
	public List<FinancialCard> getFinancialCardInfo(Long id) {
		List<FinancialCard> studentsTransactions = new ArrayList();
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
	
	public List<FinancialCard> getStudentFinancialCard(Long id) {
		
		List<FinancialCard> financialCardPayment = new ArrayList<FinancialCard>();
		for (FinancialCard f: financialCardRepository.getStudentFinancialCard(id)) {
			financialCardPayment.add(f);
		}
		return financialCardPayment;
		
	}
	
	
	public List<Exam> getCurrentExams(Long id) {
		// TODO Auto-generated method stub
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
	private List<Document > getDocumentsForStudents(Long id){
		List<Document> documentForStudent = new ArrayList<Document>();
		for (Document d: studentRepository.getDocumentsForStudents(id)) {
			documentForStudent.add(d);
		}
		return documentForStudent;
	}
}
