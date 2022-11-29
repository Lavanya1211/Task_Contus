package com.contous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class ContousApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContousApplication.class, args);
	}

}
