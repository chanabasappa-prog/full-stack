package com.personaldetail.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.personaldetail.data.modal.EducationDetail;

@Repository
public interface EducationDetailRepository extends JpaRepository<EducationDetail, Long>{


	List<EducationDetail> findByPersonalDetailId(Long personalDetailId);
	
	EducationDetail findByIdAndPersonalDetailId(Long id, Long personalDetailId);
}
