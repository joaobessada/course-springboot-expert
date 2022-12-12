package com.bessada.springbootexpert;

import com.bessada.springbootexpert.domain.entity.Cliente;
import com.bessada.springbootexpert.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootExpertApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExpertApplication.class, args);
	}

}
