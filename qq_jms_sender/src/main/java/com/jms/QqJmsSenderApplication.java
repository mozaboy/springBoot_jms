package com.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import javax.jms.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJms
public class QqJmsSenderApplication {

	@Bean
		// Strictly speaking this bean is not necessary as boot creates a default
	JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
		SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(QqJmsSenderApplication.class, args);

		for (int i = 0; i < 10; i++) {
			Sender.sendStringToDestination(context,Destinations.STRING_DESTINATION_A,"heyhooo destination-a: " + i);
			Sender.sendStringToDestination(context,Destinations.STRING_DESTINATION_B,"heyhooo destination-b: " + i);
		}

		Map<String, String> message = new HashMap<String, String>();
		message.put("A", "A");
		message.put("B", "B");
		message.put("C", "C");
		Sender.sendObjectToDestination(context, Destinations.MAP_DESTINATION_A,message);


		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
