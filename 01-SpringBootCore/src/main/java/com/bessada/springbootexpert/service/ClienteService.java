package com.bessada.springbootexpert.service;

import com.bessada.springbootexpert.model.Cliente;
import com.bessada.springbootexpert.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClientesRepository repository;

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
    }

    public void validarCliente(Cliente cliente) {
        //validations
    }


}
