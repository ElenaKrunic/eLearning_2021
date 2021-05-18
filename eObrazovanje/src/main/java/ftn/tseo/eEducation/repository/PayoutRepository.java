package ftn.tseo.eEducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.tseo.eEducation.DTO.PayoutDTO;
import ftn.tseo.eEducation.model.PayOut;

public interface PayoutRepository extends JpaRepository<PayOut, Long> {

}
