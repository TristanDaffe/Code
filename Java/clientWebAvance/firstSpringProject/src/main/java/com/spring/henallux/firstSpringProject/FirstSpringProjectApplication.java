package com.spring.henallux.firstSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FirstSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjectApplication.class, args);
	}

}
