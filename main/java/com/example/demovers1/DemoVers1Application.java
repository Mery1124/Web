package com.example.demovers1;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demovers1.entity")
@EnableJpaRepositories(basePackages = "com.example.demovers1.Repository")

public class DemoVers1Application {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(DemoVers1Application.class, args);
    }

    @Bean
    public CommandLineRunner testEntityManager() {
        return args -> {
            System.out.println("Entities: " + entityManager.getMetamodel().getEntities());
        };
    }



    }


