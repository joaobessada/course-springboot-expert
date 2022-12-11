package com.bessada.springbootexpert;

import com.bessada.springbootexpert.domain.entity.Cliente;
import com.bessada.springbootexpert.domain.entity.Pedido;
import com.bessada.springbootexpert.domain.repository.Clientes;
import com.bessada.springbootexpert.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootExpertApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos
	) {
		return args -> {
			System.out.println("Salvando clientes");
			Cliente fulano = new Cliente("Fulano");
			clientes.save(fulano);

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

			/* buscando os pedidos de um certo cliente pela classe de CLIENTES
			Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
			System.out.println(cliente);
			System.out.println(cliente.getPedidos());
			*/

			//buscando os pedidos de um certo cliente direto pela classe pedidos
			pedidos.findByCliente(fulano).forEach(System.out::println);

			/*
          	boolean existe = clientes.existsByNome("Dougllas");
			System.out.println("existe um cliente com o nome Dougllas?" + existe);
			*/
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExpertApplication.class, args);
	}

}
