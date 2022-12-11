package com.bessada.springbootexpert.domain.repository;

import com.bessada.springbootexpert.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
