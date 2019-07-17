package com.wipro.digital.application.producer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.digital.application.producer.util.Employee;
import com.wipro.digital.application.producer.util.Producer;


@RestController
public class WebController {
	
	final static Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	Producer producer;
	
	
	@PostMapping("/send")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee sendMsg(@Valid @RequestBody Employee emp){
		logger.info("Published massege is "+ emp);
		producer.produceMsg(emp);
		
		return emp;
	}
	
	@GetMapping("/status")
	public String getStatus() {
		
		return "Producer service is running!!";
		
	}
}
