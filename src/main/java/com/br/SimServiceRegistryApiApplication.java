package com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SimServiceRegistryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimServiceRegistryApiApplication.class, args);
	}

}
