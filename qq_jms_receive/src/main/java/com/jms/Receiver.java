package com.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Receiver {

    @JmsListener(destination = Destinations.STRING_DESTINATION_A, containerFactory = "myJmsContainerFactory")
    public void receiveStringDestinationA(String message) {
        System.out.println(Destinations.STRING_DESTINATION_A +  ": <" + message + ">");

    }
    
    @JmsListener(destination = Destinations.STRING_DESTINATION_B, containerFactory = "myJmsContainerFactory")
    public void receiveStringDestinationB(String message) {
    	 System.out.println(Destinations.STRING_DESTINATION_B +  ": <" + message + ">");
     	try {
 			Thread.sleep(300);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
    }
    
    @JmsListener(destination = Destinations.MAP_DESTINATION_A, containerFactory = "myJmsContainerFactory")
    public void receiveMapDestinationA(HashMap<String, String> map) {
        System.out.println("Map received: " + map.toString());
    }
    

}
