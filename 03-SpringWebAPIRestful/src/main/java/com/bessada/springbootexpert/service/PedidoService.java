package com.bessada.springbootexpert.service;

import com.bessada.springbootexpert.domain.entity.Pedido;
import com.bessada.springbootexpert.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
