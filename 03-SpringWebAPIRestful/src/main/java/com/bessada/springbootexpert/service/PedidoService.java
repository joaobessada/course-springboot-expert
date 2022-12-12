package com.bessada.springbootexpert.service;

import com.bessada.springbootexpert.domain.entity.Pedido;
import com.bessada.springbootexpert.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
