package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.DTO.DocumentDTO;
import ftn.tseo.eEducation.DTO.ExamDTO;
import ftn.tseo.eEducation.DTO.ExamRegistrationDTO;
import ftn.tseo.eEducation.DTO.FinancialCardDTO;
import ftn.tseo.eEducation.DTO.PaymentDTO;
import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.PayOut;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;




public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);
    
    Long registeredExam(Long studentId,Long examId,String location,float points);
    List<ExamDTO> findTakenExams(Long id);
    
    List<FinancialCardDTO> getFinancialCardInfo(Long id); 
    
    List<ExamDTO> getCurrentExam(Long id);
    //SELECT e.exam_date, e.points, e.grade FROM student s OUTTER JOIN enrollment en ON s.id = en.student INNER JOIN exam e ON en.enrollment_id = e.enrollment INNER JOIN courses c ON en.course = c.course_id WHERE s.id = ?"
	@Query(value = "SELECT e FROM student s left outer join enrollment en left outer join exam e WHERE s.id=?")
	List<Exam> findStudentExams(Long id);
//	
//	//to do 
//	(value = "SELECT p.date_of_payment, p.payment_amount,p.payment_description FROM student s INNER JOIN financialcard fc ON s.id = fc.student_financial_card INNER JOIN payment p ON fc.id = p.financial_card WHERE s.id = ?")
	@Query(value = "SELECT p FROM student s LEFT OUTER JOIN financialcard fc LEFT OUTER JOIN payment p WHERE s.id=?")
	List<Payment> getStudentFinancialCard(Long id);
	
	@Query(value = "SELECT p FROM student s LEFT OUTER JOIN financialcard fc LEFT OUTER JOIN payout p WHERE s.id=?")
	List<PayOut> getStudentFinancialCardPayout(Long id);
	
    
    //to do kreirati kveri koji za studenta vraca sva njegova dokumenta
    //svi dokumnti od jednog studenta
    @Query(value = "SELECT d FROM Student s LEFT OUTER JOIN Document d WHERE s.id = ?")
    List<Document > getDocumentsForStudents(Long id);
    
    //do to query za finansijsku karticu
    @Query(value = "SELECT f FROM Student s LEFT OUTER JOIN financialCard f WHERE s.id = ?")
    FinancialCard findStudentFinancialCard(Long id);
    
	@Query(value="SELECT * FROM student AS s WHERE s.id IN (SELECT DISTINCT e.student from enrollments e WHERE e.student =s.student AND e.curse = ?)")
	List<Student> getEnrolledStudentsInProfessorsCourse(long id);
    
}
