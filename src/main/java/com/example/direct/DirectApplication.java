package com.example.direct;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DirectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectApplication.class, args);
	}
	
	@Component
	class DirectRoute extends RouteBuilder {

		@Override
		public void configure() throws Exception {
			from("direct:log-file")
					.log("Log: ${header.CamelFileName}");
			
			from("file:C:\\Users\\ruank\\Documents\\apache-camel\\input")
					.to("direct:log-file");
			
		}
		
	}
	
}
