package com.bessada.springbootexpert.service.impl;

import com.bessada.springbootexpert.domain.entity.Pedido;
import com.bessada.springbootexpert.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedido repository;
}
