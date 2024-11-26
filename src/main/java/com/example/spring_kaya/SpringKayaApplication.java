package com.example.spring_kaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.spring_kaya")
@SpringBootApplication(scanBasePackages = "com.example.spring_kaya")
@ComponentScan("com.example.spring_kaya")
@EntityScan("com.example.spring_kaya")
public class SpringKayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKayaApplication.class, args);
	}

}
