package com.personaldetail.service;

import com.personaldetail.AbstractPersonalDetailAppTest;
import com.personaldetail.data.modal.PersonalDetail;
import com.personaldetail.data.repository.PersonalDetailRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

class PersonalDetailServiceTests extends AbstractPersonalDetailAppTest {

	@Mock
	private  PersonalDetailRepository personalDetailRepository;

	@InjectMocks
	private PersonalDetailService personalDetailService;

	private Optional<PersonalDetail> personalDetailList;

	@Test
	void testValidPersonalDetail() {
		Long id = 1l;
		String name = "Test1";

		PersonalDetail projectDetails = new PersonalDetail();
		projectDetails.setName("Test1");
		personalDetailList = Optional.of(projectDetails);
		Mockito.doReturn(personalDetailList).when(personalDetailRepository).findById(Mockito.any());

		PersonalDetail result = personalDetailService.findById(id);
		Assertions.assertThat(name).isEqualTo(result.getName());

	}

}
