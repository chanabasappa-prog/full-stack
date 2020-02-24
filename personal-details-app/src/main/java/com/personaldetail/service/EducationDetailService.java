package com.personaldetail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.personaldetail.data.modal.EducationDetail;
import com.personaldetail.data.repository.EducationDetailRepository;

@Service
public class EducationDetailService {
	@Autowired
	private EducationDetailRepository educationDetailRepository;
	
	public List<EducationDetail> list(){
		return educationDetailRepository.findAll();
	}
	
	public EducationDetail findById(Long id) {
		return educationDetailRepository.findById(id).get();
	}
	
	public EducationDetail save(EducationDetail educationDetail) {
		return educationDetailRepository.save(educationDetail);
	}
	
	public void delete(EducationDetail educationDetail) {
		educationDetailRepository.delete(educationDetail);
	}
	
	public List<EducationDetail> findByPersonalDetailId(Long personalDetailId){
		return educationDetailRepository.findByPersonalDetailId(personalDetailId);
	}
	
	public EducationDetail findByIdAndPersonalDetailId(Long id, Long personalDetailId) {
		return educationDetailRepository.findByIdAndPersonalDetailId(id, personalDetailId);
	}
}
