package ftn.tseo.eEducation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Document;
import ftn.tseo.eEducation.model.Exam;
import ftn.tseo.eEducation.model.FinancialCard;
import ftn.tseo.eEducation.model.Student;




public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	Student findOneByCardNumber(String cardNumber);
    List<Student> findAllByLastName(String lastName);
    
    int registeredExam(Long studentId,Long examId);
    List<Exam> findTakenExams(Long id);
    
    List<FinancialCard> getFinancialCardInfo(Long id); 
    
    List<Exam > getCurrentExam(Long id);
    
    @Query
    //to do kreirati kveri koji za studenta vraca sva njegova dokumenta
    List<Document > getDocumentsForStudents(Long id);
    

}
