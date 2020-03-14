package com.claim.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.claim.data.modal.ClaimDetail;

@Repository
public interface ClaimDetailRepository extends JpaRepository<com.claim.data.modal.ClaimDetail, Long>{


	List<ClaimDetail> findByEmployeeId(Long employeeId);
	

}
