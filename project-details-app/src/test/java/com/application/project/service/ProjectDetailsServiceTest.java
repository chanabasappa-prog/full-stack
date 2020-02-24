package com.application.project.service;

import com.application.project.data.modal.ProjectDetails;
import com.application.project.data.repository.ProjectDetailsRepository;
import com.application.project.rest.controller.AbstractMockMvcControllerTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectDetailsServiceTest extends AbstractMockMvcControllerTest {

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @MockBean
    private ProjectDetailsRepository projectDetailsRepository;

    private Optional<ProjectDetails> projectDetailsList;


    @Test
    public void whenValidId_thenProjectShouldBeFound() {
        Long id = 1l;
        String name = "Hunaid";

        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setName("Hunaid");
        projectDetailsList = Optional.of(projectDetails);

        Mockito.when(projectDetailsRepository.findById(Mockito.any()))
                .thenReturn(projectDetailsList);
        ProjectDetails found = projectDetailsService.findById(id);

        assertThat(name).isEqualTo(found.getName());
    }
}
