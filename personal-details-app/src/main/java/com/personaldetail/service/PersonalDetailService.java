package com.personaldetail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personaldetail.data.modal.PersonalDetail;
import com.personaldetail.data.repository.PersonalDetailRepository;

@Service
public class PersonalDetailService {
	
	@Autowired
	private PersonalDetailRepository personalDetailRepository;
	
	public List<PersonalDetail> list(){
		return personalDetailRepository.findAll();
	}
	
	public PersonalDetail findById(Long id) {
		return personalDetailRepository.findById(id).get();
	}
	
	public PersonalDetail save(PersonalDetail personalDetail) {
		return personalDetailRepository.save(personalDetail);
	}
	
	public void delete(PersonalDetail personalDetail) {
		personalDetailRepository.delete(personalDetail);
	}

}
