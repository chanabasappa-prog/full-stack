package com.personaldetail.rest.controller;
import com.personaldetail.AbstractPersonalDetailAppTest;
import com.personaldetail.data.modal.PersonalDetail;
import com.personaldetail.service.PersonalDetailService;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

@AutoConfigureMockMvc
public class PersonalDetailControllerTest extends AbstractPersonalDetailAppTest {
    @MockBean
    private PersonalDetailService personalDetailService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenGetPersonalDetail_thenReturnJsonArray()
            throws Exception {

        List<PersonalDetail> personalDetailList = new ArrayList<>();
        PersonalDetail personalDetail = new PersonalDetail();
        personalDetail.setName("Test");
        personalDetailList.add(personalDetail);

        Mockito.doReturn(personalDetailList).when(personalDetailService).list();
        mvc.perform(get("/personalDetail")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is(personalDetail.getName())));
    }

}
