package com.personaldetail.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personaldetail.data.modal.PersonalDetail;

@Repository
public interface PersonalDetailRepository extends JpaRepository<PersonalDetail, Long>{

	
}
