package ftn.tseo.eEducation.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.model.Course;
import ftn.tseo.eEducation.model.ExamPeriod;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	
	Page<Course> findAll(Pageable pageable);
	Page<Course> findByTitle(String title, Pageable page);
	List<Course> findByTitle(String title, Sort sort);
}
