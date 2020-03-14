package com.claim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.claim.data.modal.ClaimDetail;
import com.claim.data.repository.ClaimDetailRepository;

@Service
public class ClaimDetailService {
	@Autowired
	private ClaimDetailRepository claimDetailRepository;
	
	public List<ClaimDetail> list(){
		return claimDetailRepository.findAll();
	}
	
	public ClaimDetail findById(Long id) {
		return claimDetailRepository.findById(id).get();
	}
	
	public ClaimDetail save(ClaimDetail claimDetail) {
		return claimDetailRepository.save(claimDetail);
	}
	
	public void delete(ClaimDetail claimDetail) {
		claimDetailRepository.delete(claimDetail);
	}
	
	public List<ClaimDetail> findByEmployeeId(Long employeeId){
		return claimDetailRepository.findByEmployeeId(employeeId);
	}
	

}
