package com.personaldetail.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personaldetail.data.modal.PersonalDetail;
import com.personaldetail.service.PersonalDetailService;

@RestController()

public class PersonalDetailController {
	
	@Autowired
    private PersonalDetailService personalDetailService;

	@GetMapping("personalDetail")
	public List<PersonalDetail> getAllphonebooks() {
		List<PersonalDetail> personalDetail = personalDetailService.list();
		return personalDetail;
		
	}

	@GetMapping("personalDetail/{personalDetailId}")
	public PersonalDetail getPersonalDetailById(@PathVariable String personalDetailId) {
		return personalDetailService.findById(Long.parseLong(personalDetailId));
	}
	
	@PostMapping("/personalDetail")
    public PersonalDetail createPost(@Valid @RequestBody PersonalDetail personalDetail) {
		System.out.println(personalDetail.getId() + " :: " + personalDetail.getName());
        return personalDetailService.save(personalDetail);
    }
	
	@DeleteMapping("personalDetail/{personalDetailId}")
    public ResponseEntity<?> deletePost(@PathVariable Long personalDetailId) {
        PersonalDetail personalDetail = personalDetailService.findById(personalDetailId);
        personalDetailService.delete(personalDetail);
        return ResponseEntity.ok().build();
    }
}
