package com.bessada.springbootexpert;

import com.bessada.springbootexpert.domain.entity.Cliente;
import com.bessada.springbootexpert.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootExpertApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			System.out.println("Salvando clientes");
			clientes.save(new Cliente("Dougllas"));
			clientes.save(new Cliente("Outro Cliente"));

			/*
          	boolean existe = clientes.existsByNome("Dougllas");
			System.out.println("existe um cliente com o nome Dougllas?" + existe);
			*/

			List<Cliente> result = clientes.encontrarPorNome("Dougllas");
			result.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExpertApplication.class, args);
	}

}
