package com.claim.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.claim.data.modal.ClaimDetail;
import com.claim.service.ClaimDetailService;

@RestController()
public class ClaimDetailController {
	
	@Autowired
    private ClaimDetailService claimDetailService;

	@GetMapping("claimDetail/{employeeId}/claim")
	public List<ClaimDetail> getClaimByEmpoyeeId(@PathVariable String employeeId) {
		return claimDetailService.findByEmployeeId(Long.parseLong(employeeId));
	}
		

}
