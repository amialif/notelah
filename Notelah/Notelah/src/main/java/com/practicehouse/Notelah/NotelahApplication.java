package com.practicehouse.Notelah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotelahApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotelahApplication.class, args);
	}

}
