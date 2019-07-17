package com.wipro.digital.application.producer.util;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class Producer {
	
	/*
	 * @Autowired private AmqpTemplate amqpTemplate;
	 */
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingKey;
	
	public void produceMsgString(String msg){
		rabbitTemplate.convertAndSend(exchange, routingKey, msg);
		System.out.println("Published msg = " + msg);
	}
	
	public void produceMsg(Employee msg){
		rabbitTemplate.convertAndSend(exchange, routingKey, msg);
		System.out.println("Published msg = " + msg);
	}
}

