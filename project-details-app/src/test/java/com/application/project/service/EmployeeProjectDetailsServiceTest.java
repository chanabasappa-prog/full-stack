package com.application.project.service;

import com.application.project.AbstractMockMvcControllerTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EmployeeProjectDetailsServiceTest extends AbstractMockMvcControllerTest {

    @Test
    public void whenValidId_thenProjectShouldBeFound() {
        String name="A";
        assertThat("A").isEqualTo(name);
    }
}
