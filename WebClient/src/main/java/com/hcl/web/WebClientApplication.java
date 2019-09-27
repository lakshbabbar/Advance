package com.hcl.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class WebClientApplication{
	
	public static final String SERVICE_URL = "http://BANK-USERSERVICE";
	
	public static final String SERVICE_URL_1 = "http://BANK-ACCOUNTSERVICE";

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public UserService userService(){
		return new RemoteUserRepository(SERVICE_URL);
	}
	
	@Bean
	public AccountService accountService(){
		return new RemoteAccRepository(SERVICE_URL_1);
	}
}
