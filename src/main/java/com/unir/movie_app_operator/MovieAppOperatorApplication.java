package com.unir.movie_app_operator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
@Slf4j

public class MovieAppOperatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAppOperatorApplication.class, args);
	}

}
