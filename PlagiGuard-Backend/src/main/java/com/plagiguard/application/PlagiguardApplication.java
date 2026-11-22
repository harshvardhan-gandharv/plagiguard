package com.plagiguard.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(scanBasePackages = "com.plagiguard")
@EntityScan(basePackages = "com.plagiguard.entity")
@EnableJpaRepositories(basePackages = "com.plagiguard.repository")
@EnableScheduling
public class PlagiguardApplication {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure()
                .directory("./")
                .ignoreIfMissing()
                .load();
        
        dotenv.entries().forEach(entry ->
            System.setProperty(
                entry.getKey(),
                entry.getValue()
            )
        );
        
        SpringApplication.run(PlagiguardApplication.class, args);
    }
}
