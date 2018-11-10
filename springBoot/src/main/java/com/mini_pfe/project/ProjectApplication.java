package com.mini_pfe.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.mini_pfe.entities"})
@ComponentScan(basePackages = {"com.mini_pfe.controllers","com.mini_pfe.services"})
@EnableJpaRepositories(basePackages = "com.mini_pfe.dao.repositories")
@SpringBootApplication
public class ProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
