package ftn.tseo.eEducation.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
	
	Page<ExamPeriod> findAll(Pageable pageable);
	Page<ExamPeriod> findByName(String name, Pageable page);
	List<ExamPeriod> findByName(String name, Sort sort);
}
