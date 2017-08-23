package com.jms;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Sender {


	public static void sendStringToDestination(ConfigurableApplicationContext context, String destinationName, String text) {
	    JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
	    System.out.println("Sending a new message to: " + destinationName);
	    jmsTemplate.convertAndSend(destinationName, text);
	}
	
	public static void sendObjectToDestination(ConfigurableApplicationContext context, String destinationName, Map<String, String> message) {
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
	    System.out.println("Sending a map to: " + destinationName);
	    jmsTemplate.convertAndSend(destinationName, message);
	}
    
}
