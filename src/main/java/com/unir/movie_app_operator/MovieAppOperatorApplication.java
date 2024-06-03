package com.unir.movie_app_operator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MovieAppOperatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAppOperatorApplication.class, args);
	}

}
