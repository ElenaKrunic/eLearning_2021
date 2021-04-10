package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.Student;




public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);
    
 
//    //proveriti kako cu odraditi da se proveri da li je student vec polagao odredjeni ispit4
//    List<ExamDTO> findTakenExams(Long id);
    
    
  
    //SELECT e.exam_date, e.points, e.grade FROM student s OUTTER JOIN enrollment en ON s.id = en.student INNER JOIN exam e ON en.enrollment_id = e.enrollment INNER JOIN courses c ON en.course = c.course_id WHERE s.id = ?"
	
	
//	(value = "SELECT p.date_of_payment, p.payment_amount,p.payment_description FROM student s INNER JOIN financialcard fc ON s.id = fc.student_financial_card INNER JOIN payment p ON fc.id = p.financial_card WHERE s.id = ?")

    
    //to do kreirati kveri koji za studenta vraca sva njegova dokumenta
    //svi dokumnti od jednog studenta
   
    //do to query za finansijsku karticu
  
//	@Query(value="SELECT s FROM Student AS s WHERE s.id IN (SELECT DISTINCT e.student from Enrollment e WHERE e.student =s.student AND e.courses = :id)")
//	List<Student> getEnrolledStudentsInProfessorsCourse(long id);
    
}
