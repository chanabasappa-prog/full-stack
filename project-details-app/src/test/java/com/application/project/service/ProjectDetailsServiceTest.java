package com.application.project.service;

import com.application.project.data.modal.ProjectDetails;
import com.application.project.data.repository.ProjectDetailsRepository;
import com.application.project.AbstractMockMvcControllerTest;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectDetailsServiceTest extends AbstractMockMvcControllerTest {

    @Mock
    private ProjectDetailsRepository projectDetailsRepository;

    @InjectMocks
    private ProjectDetailsService projectDetailsService;

    private Optional<ProjectDetails> projectDetailsList;


    @Test
    public void whenValidId_thenProjectShouldBeFound() {
        Long id = 1l;
        String name = "Hunaid";

        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setName("Hunaid");
        projectDetailsList = Optional.of(projectDetails);
        Mockito.doReturn(projectDetailsList).when(projectDetailsRepository).findById(Mockito.any());
/*        Mockito.when(projectDetailsRepository.findById(Mockito.any()))
                .thenReturn(projectDetailsList);*/
        ProjectDetails found = null;
        try {
            found = projectDetailsService.findById(id);
        } catch (ProjectDetailsNotFoundException e) {
            e.printStackTrace();
        }

        assertThat(name).isEqualTo(found.getName());
    }
   @Test
   public void whenValidId_thenasdBeFound() {
       String name="A";
       assertThat("A").isEqualTo(name);
   }
}
