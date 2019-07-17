package com.wipro.digital.application.producer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CompositeFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.digital.application.producer.util.Employee;
import com.wipro.digital.application.producer.util.Producer;

@RunWith(MockitoJUnitRunner.Silent.class)
public class WebControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	WebController webController;
	
	@Mock
	Producer producer;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
                .standaloneSetup(webController)
                .addFilters(new CompositeFilter())
                .build();
	}

	
	@Test
	public void sendMsgTest() throws Exception {
		
		Employee emp = new Employee("test",1234,"pune");
		Mockito.doNothing().when(producer).produceMsg(null);
		mockMvc.perform(post("/send")
				.contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(emp)))
		.andExpect(status().isCreated());
		
		
	}
	
	@Test
	public void getStatusTest() throws Exception {
		mockMvc.perform(get("/status"))
		.andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
