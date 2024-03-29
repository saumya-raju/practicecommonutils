package com.wipro.digital.application.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.digital.application.producer.config.StudentJdbcRepository;
import com.wipro.digital.application.producer.util.Student;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner{

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	    @Autowired
	    StudentJdbcRepository repository;
	    
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
	
	    @Override
	    public void run(String...args) throws Exception {
	        //logger.info("Student id 10001 -> {}", repository.findById("10001"));
	        logger.info("All users 1 -> {}", repository.findAll());
	        logger.info("Inserting -> {}", repository.insert(new Student("10010", "John", "A1234657")));
	        logger.info("Update 10001 -> {}", repository.update(new Student("10001", "Name-Updated", "New-Passport")));
	        repository.deleteById("10002");
	        logger.info("All users 2 -> {}", repository.findAll());
	    }

}
