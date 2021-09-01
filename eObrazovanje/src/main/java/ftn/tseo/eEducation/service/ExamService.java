package ftn.tseo.eEducation.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamRegistrationDTO;
import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.Enrollment;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;
import ftn.tseo.eEducation.model.Teaching;
import ftn.tseo.eEducation.repository.EnrollmentRepository;
import ftn.tseo.eEducation.repository.ExamRepository;
import ftn.tseo.eEducation.repository.FinancialCardRepository;
import ftn.tseo.eEducation.repository.PaymentRepository;
import ftn.tseo.eEducation.repository.PreExamObligationRepository;
import ftn.tseo.eEducation.repository.StudentRepository;
import ftn.tseo.eEducation.repository.TeachingRepository;
import javassist.expr.NewArray;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	FinancialCardRepository financialCardRepository;

	@Autowired
	TeachingRepository teachingRepository;
	
	@Autowired 
	StudentRepository studentRepository; 
	
	@Autowired
	PreExamObligationRepository preexamRepository;
	
	

	public Exam findOne(Long id) {
		return examRepository.findById(id).orElse(null);
	}


	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	public void remove(Long id) {
		examRepository.deleteById(id);
	}
	
	public List<Exam> findPassedExams(){
		return examRepository.findPassedExams();
	}
	
	public List<Exam> findFailedExams(){
		return examRepository.findFailedExams();
	}
	public List<ExamDTO> getCurrentExams(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		List<Exam> allExams = examRepository.findAll();
		List<Exam> currentExams = new ArrayList<>();
		
	
		Date currentDate = new Date(new java.util.Date().getTime());
		

		if(student != null) {
			for (Exam e : allExams) {
				if(e.getExamPeriod().iterator().next().getEndDate().after(currentDate) && 
						e.getExamPeriod().iterator().next().getStartDate().before(currentDate) && e.isStatus()==false) {
					
						currentExams.add(e);
					
				}
			}
			
			
		}
		List<ExamDTO> currentExamsDTOs = new ArrayList<>();
		
		for( Exam examToDTO : currentExams) {
			currentExamsDTOs.add(new ExamDTO(examToDTO));
		}
		
		return currentExamsDTOs;
	
	}
	
		public List<ExamDTO> findStudentExams(Long id) {
		
		List<Enrollment> enrollment=enrollmentRepository.findByStudentId(id);
		System.out.println("Enrollment"+enrollment);
		List<ExamDTO> examsToDTO=new  ArrayList<ExamDTO>();
		Set<Exam> exams= new  HashSet<Exam>();
		
		for(Enrollment e:enrollment) {
			exams.addAll( e.getExam());
			
		}
		for(Exam ex : exams) {
			examsToDTO.add(new ExamDTO(ex));
		}
		
		return examsToDTO;
	}
	//ova klasa
	public List<ExamDTO> findProffesorExams(Long id) {
		
		Teaching teaching= teachingRepository.findTeachingByProfessorId(id);
		System.out.println("Enrollment"+teaching);
		
		List<ExamDTO> examsToDTO=new  ArrayList<ExamDTO>();
		Set<Exam> exams= teaching.getCourses().getEnrollments().iterator().next().getExam();
		
		
		for(Exam ex : exams) {
			examsToDTO.add(new ExamDTO(ex));
		}
		
		return examsToDTO;
	}
		
//	public List<Exam> examsForRegistration(Student student) {
//		
//		Student s = studentRepository.findById(student.getId()).orElse(null); 
//		boolean passed = true; 
//		List<Exam> exams = new ArrayList<>(examRepository.findByStudentAndDate(s, new Date()));
//		List<Exam> examsForRegistration = new ArrayList<>();
//		
//		for(Exam exam : exams) {
//			List<PreexamObligation> preexamObligations = preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new Date());
//			
//			if(((exam.getPreexamObligation().size()) != preexamObligations.size())) 
//					continue;
//			for(PreexamObligation preexamObligation : preexamObligations) {
//				if(!preexamObligation.isPassed()) {
//					passed = false;
//					break;
//				}
//			}
//			
//			if(passed) {
//				examsForRegistration.add(exam);
//			}
//		}
//		return examsForRegistration; 
//	}
	
//naci ispite za studenta gde je polozeno false i samo po id-ju studenta da nadje ispite examId ne,location i points ne
	//taj ispit za studenta se mora izvuci po id-ju da bi mu se setovale vrednosti
	public Long registerExam(Long studentId, Long examId) {
		//vezati u frontu da ispisuje sve ispite po studentu,a da na osnovu ove metode samo radi registraciju po id-ju
		Exam exam = examRepository.findById(examId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		
		
//		kako cu izvuci za sve ispite naziv kursa kada promenim u jpql
//		String course=exam.getEnrollment().getCourse().getTitle();
		if(exam != null && student != null) {
//			Exam exam1=new Exam();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
//			exam1.setExamDate1(dtf.format(now));
//			exam1.setGrade(0);
//			exam1.setPoints(0);
//			exam1.setStatus(false);
			
//			examRepository.save(exam1);
			
			PreexamObligation examReg = new PreexamObligation();
			examReg.setExam(exam);
			examReg.setDateOfObligation("/");
			examReg.setLocation(null);
			examReg.setPoints(0);
			examReg.setPreexamObligationType(null);
			examReg.setPreexamObligationStatus(null);
			examReg.setStudent(student);
			preexamRepository.save(examReg);
//			
			float cost = exam.getExamPeriod().iterator().next().getPaymentAmount();
			FinancialCard transaction = financialCardRepository.findFinancialCardByStudentId(studentId);
			
			
			Payment payment=new Payment();
			
			payment.setPaymentDate1(dtf.format(now));
			payment.setPaymentAmount((float) cost);
			payment.setPaymentDescription("Prijava ispita");
			payment.setFinancialCard(transaction);
			
			paymentRepository.save(payment);
			//ako se bude bunilo napraviti novi konstruktor
//			transaction.setPayments((Set<Payment>) payment);
			transaction.setStudent(student);
			transaction.setTotalPayout(transaction.getTotalPayout()-cost);
			
			
			transaction.setInitialState(transaction.getInitialState() - cost);
			financialCardRepository.save(transaction);
		
		}
		return  (long) 0;
	}
//public Exam register(ExamRegistrationDTO dto) {
//		
//		Exam exam = findOne(dto.getId()); 
//		Student student = studentRepository.getOne(dto.getStudentId());
//		
//		if(exam == null || student == null || student.getCardAmount() == null || student.getCardAmount() < 200 || 
//				exam.getPreexamObligation().size() != preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new java.util.Date()).size()) {
//			return null;
//		}
//		
//		//testno 
//		exam.setExamDate(null);
//		exam.setExamPeriod(null);
//		
//		if(student.getCardAmount() == null || student.getCardAmount() < 200) {
//			student.setCardAmount(0d);
//			return null;
//		}
//		
//		if(exam.getPoints() == 0) {
//			exam.setPoints(0F);
//		}
//		
//		student.setCardAmount(student.getCardAmount() - 200);
//		
//		for(PreexamObligation preexamObligation : preexamRepository.getLatestResults(student, exam.getEnrollments().getCourses().getId(), new java.util.Date())) {
//			if(!preexamObligation.isPassed()) {
//				return null; 
//			}
//			preexamObligation.setPassed(true);
//		}
//		
//		return save(exam);
//	}
	
	
}



