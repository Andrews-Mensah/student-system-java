package com.example.Student.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.example.Student")
@CrossOrigin
public class StudentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSystemApplication.class, args);
	}

}
