package com.tidz.restTuto.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tidz.restTuto.model.Employee;
import com.tidz.restTuto.repository.EmployeeRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner iniDatabase(EmployeeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Mano", "Maneiro")));
			log.info("Preloading: " + repository.save(new Employee("Truta", "Dahora")));
		};
	}
}
