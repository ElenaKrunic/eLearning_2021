package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.PreexamObligation;
import ftn.tseo.eEducation.model.Student;




public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);
    
    Long registeredExam(Long studentId,Long examId,String location,float points);
    List<Exam> findTakenExams(Long id);
    
    List<FinancialCard> getFinancialCardInfo(Long id); 
    
    List<Exam > getCurrentExam(Long id);

	@Query(value = "SELECT e.exam_date, e.points, e.grade, c.course_code FROM student s INNER JOIN enrollment en ON s.id = en.student INNER JOIN exam e ON en.enrollment_id = e.enrollment INNER JOIN courses c ON en.course = c.course_id WHERE s.id = ?", nativeQuery = true)
	List<Exam> findStudentExams(Long id);
	
	//to do 
	@Query(value = "SELECT p.date_of_payment, p.payment_amount,p.payment_description FROM student s INNER JOIN financialcard fc ON s.id = fc.student_financial_card INNER JOIN payment p ON fc.id = p.financial_card WHERE s.id = ?", nativeQuery = true)
	List<Payment> getStudentFinancialCard(Long id);
			
    
    //to do kreirati kveri koji za studenta vraca sva njegova dokumenta
    //svi dokumnti od jednog studenta
    @Query(value = "SELECT d.title, d.url,d.documents_documentstype FROM student s INNER JOIN document dc ON s.id = dc.student WHERE s.id = ?", nativeQuery = true)
    List<Document > getDocumentsForStudents(Long id);
    
    //do to query za finansijsku karticu
    FinancialCard findStudentFinancialCard(Long id);
    
}
