package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.tseo.eEducation.model.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
	List<ExamPeriod> findByName(String name);
}
