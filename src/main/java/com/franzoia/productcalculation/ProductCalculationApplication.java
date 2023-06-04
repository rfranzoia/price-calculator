package com.franzoia.productcalculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCalculationApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/product-calculator");
		SpringApplication.run(ProductCalculationApplication.class, args);
	}

}
