package com.shj.todo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
public class TodoGatewayServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoGatewayServiceApplication.class, args);
	}

}
