package com.example.demo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		 SpringApplication.run(DemoApplication.class,args); 
		
	}

}