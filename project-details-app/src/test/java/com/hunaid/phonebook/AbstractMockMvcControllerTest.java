package com.hunaid.phonebook;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@PropertySource("classpath:/application_test.properties")
@ComponentScan("com.hunaid.phonebook")
public class AbstractMockMvcControllerTest {
	

	protected MockMvc mockMvc;
	
	@Test
	public void TestSomething() {
		boolean testVar=true;
		assertTrue(testVar);
	}
}
