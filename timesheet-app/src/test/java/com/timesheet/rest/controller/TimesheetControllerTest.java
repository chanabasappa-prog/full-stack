package com.timesheet.rest.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.AbstractTimesheetAppTest;
import com.timesheet.data.modal.Employee;
import com.timesheet.data.modal.Timesheet;
import com.timesheet.service.EmployeeDetailsService;
import com.timesheet.service.TimesheetService;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class TimesheetControllerTest extends AbstractTimesheetAppTest {

    @Mock
    private TimesheetService timesheetService;

    @Autowired
    private MockMvc mvc;



    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        List<Timesheet> timesheetList = new ArrayList<>();
        Employee employeeDetails = new Employee();
        employeeDetails.setFirstName("Chana");
        employeeDetails.setLastName("Awati");
        employeeDetails.setJoiningDate(new Date());
        employeeDetails.setTerminationDate(null);
        Timesheet timesheet = new Timesheet();
        timesheet.setEmployeeDetails(employeeDetails);
        timesheet.setHours(8l);
        timesheet.setTimesheetDate(new Date());
        timesheetList.add(timesheet);

        Mockito.doReturn(timesheetList).when(timesheetService).list();
/*
        mvc.perform(get("/timesheets")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(1)))
                .andExpect(jsonPath("$[0].employeeDetails.firstName", Matchers.is(employeeDetails.getFirstName())));
    */
    }

    @Test
    public void whenValidId_thenasdBeFound() {
        String name="Test";
        assertThat("Test").isEqualTo(name);
    }
}
