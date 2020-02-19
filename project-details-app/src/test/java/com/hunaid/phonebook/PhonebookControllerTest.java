package com.hunaid.phonebook;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.application.project.rest.controller.ProjectDetailsController;

public class PhonebookControllerTest extends AbstractMockMvcControllerTest {

	@InjectMocks
	private ProjectDetailsController phoneBookController;
	
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";


	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(phoneBookController).build();

	}
	
	 @Test
	    public void givenBookId_whenMockMVC_thenVerifyResponse() throws Exception {
	        this.mockMvc
	            .perform(get("/phonebooks"))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(CONTENT_TYPE));
	            
	    }

}
