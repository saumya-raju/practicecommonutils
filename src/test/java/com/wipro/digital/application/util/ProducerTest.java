package com.wipro.digital.application.util;


import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.wipro.digital.application.producer.util.Employee;
import com.wipro.digital.application.producer.util.Producer;


@RunWith(MockitoJUnitRunner.Silent.class)
public class ProducerTest {
	
	@Mock
	private RabbitTemplate rabbitTemplate;
	
	@InjectMocks
	Producer producer;
	

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void produceMsgTest() {
		Employee emp = new Employee("trest",1234,"");
		doNothing().when(rabbitTemplate).convertAndSend("test", "test", emp);
		producer.produceMsg(emp);
		
	}
	
	@Test
	public void produceMsgStringTest() {
		doNothing().when(rabbitTemplate).convertAndSend("test", "test", "test");
		producer.produceMsgString("Test");
		
	}
}
