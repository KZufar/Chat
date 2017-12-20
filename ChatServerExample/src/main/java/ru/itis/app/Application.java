package ru.itis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 14.10.2017
 * Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("ru.itis")
@EnableJpaRepositories(basePackages = "ru.itis.repositories")
@EntityScan(basePackages = "ru.itis.models", basePackageClasses = Jsr310JpaConverters.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
