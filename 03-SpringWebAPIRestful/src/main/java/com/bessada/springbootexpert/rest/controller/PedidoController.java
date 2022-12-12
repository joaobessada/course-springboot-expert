package com.bessada.springbootexpert.rest.controller;

import com.bessada.springbootexpert.domain.entity.Pedido;
import com.bessada.springbootexpert.domain.repository.Pedidos;
import com.bessada.springbootexpert.rest.dto.PedidoDTO;
import com.bessada.springbootexpert.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save (@RequestBody PedidoDTO dto) {
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}
