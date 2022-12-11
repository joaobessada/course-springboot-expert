package com.bessada.springbootexpert;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
//@Development - vai herdaer o profile
public class MyConfiguration {

    @Bean(name="applicationName")
    public String applicationName() {
        return "Sistema de Vendas";
    }

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RODANDO A CONF DE DEV");
        };
    }
}
