package com.hcl.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserServiceApplication.class, args);
	}

}
