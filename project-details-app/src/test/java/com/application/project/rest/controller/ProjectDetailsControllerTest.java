package com.application.project.rest.controller;

import com.application.project.AbstractMockMvcControllerTest;
import com.application.project.data.modal.ProjectDetails;
import com.application.project.service.ProjectDetailsService;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeeProjectDetailsController.class)
@AutoConfigureMockMvc
public class ProjectDetailsControllerTest extends AbstractMockMvcControllerTest {


    @MockBean
    private ProjectDetailsService projectDetailsService;

    @Autowired
    private MockMvc mvc;



    @Test
    public void whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        List<ProjectDetails> projectDetailsList = new ArrayList<>();
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setName("Hunaid");
        projectDetails.setId(1l);
        projectDetailsList.add(projectDetails);

        Mockito.doReturn(projectDetailsList).when(projectDetailsService).list();

        mvc.perform(get("/projectdetails")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is(projectDetails.getName())));
    }

}
