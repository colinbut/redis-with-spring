package com.mycompany.redis_spring.springbootway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWayApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootWayApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWayApplication.class, args);
	}
}
