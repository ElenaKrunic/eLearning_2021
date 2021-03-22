package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Payment;
import ftn.tseo.eEducation.model.Student;




public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);
    
    Long registeredExam(Long studentId,Long examId);
    List<Exam> findTakenExams(Long id);
    
    List<FinancialCard> getFinancialCardInfo(Long id); 
    
    List<Exam > getCurrentExam(Long id);

	@Query(value = "SELECT e.exam_date, e.points, e.grade, c.course_code FROM student s INNER JOIN enrollment en ON s.id = en.student INNER JOIN exam e ON en.enrollment_id = e.enrollment INNER JOIN courses c ON en.course = c.course_id WHERE s.id = ?", nativeQuery = true)
	List<Exam> findStudentExams(Long id);
	
	//to do 
	@Query
	List<Payment> getStudentFinancialCard(Long id);
			
    @Query
    //to do kreirati kveri koji za studenta vraca sva njegova dokumenta
    //svi dokumnti od jednog studenta
    List<Document > getDocumentsForStudents(Long id);
    
   
    FinancialCard findStudentFinancialCard(Long id);
    

}
