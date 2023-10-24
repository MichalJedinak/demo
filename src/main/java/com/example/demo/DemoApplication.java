package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.gui.rest.WarehouseClient;
@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		WarehouseClient restClient = new WarehouseClient();       
		
		String response = restClient.getDataFromServer();
		SpringApplication.run(DemoApplication.class,args); 
	
	}
}
