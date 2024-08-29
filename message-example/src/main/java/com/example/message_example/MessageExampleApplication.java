package com.example.message_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MessageExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageExampleApplication.class, args);
	}

	@Bean
	public Consumer<Message> logMessage() {
	    return ( Message message ) -> {
	        System.out.println( "Received: " + message );
	    };
	}

}
