package com.bessada.springbootexpert.domain.repository;

import com.bessada.springbootexpert.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
