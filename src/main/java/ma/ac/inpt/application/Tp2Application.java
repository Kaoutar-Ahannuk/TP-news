package ma.ac.inpt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"ma.ac.inpt.model"})
@ComponentScan(basePackages = {"ma.ac.inpt.controller"})
@EnableJpaRepositories(basePackages = {"ma.ac.inpt.repository"})
public class Tp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Application.class, args);
	}

}
