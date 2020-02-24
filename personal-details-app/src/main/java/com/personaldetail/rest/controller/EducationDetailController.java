package com.personaldetail.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.personaldetail.data.modal.EducationDetail;
import com.personaldetail.service.EducationDetailService;

@RestController()
public class EducationDetailController {
	
	@Autowired
    private EducationDetailService educationDetailService;

	@GetMapping("personalDetail/{personalDetailId}/education")
	public List<EducationDetail> getPersonalDetailById(@PathVariable String personalDetailId) {
		return educationDetailService.findByPersonalDetailId(Long.parseLong(personalDetailId));
	}
		

}
