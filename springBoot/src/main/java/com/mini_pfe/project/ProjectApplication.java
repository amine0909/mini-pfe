package com.mini_pfe.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EntityScan(basePackages = {"com.mini_pfe.entities"})
@ComponentScan(basePackages = {
		"com.mini_pfe.controllers",
		"com.mini_pfe.dao.jobs",
		"com.mini_pfe.services",
		"com.mini_pfe.services.Fetchers"
})
@EnableJpaRepositories(basePackages = "com.mini_pfe.dao.repositories")
@SpringBootApplication
public class ProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
