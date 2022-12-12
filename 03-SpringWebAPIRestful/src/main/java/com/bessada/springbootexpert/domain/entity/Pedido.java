package com.bessada.springbootexpert.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    @Column(name="data_pedido")
    private LocalDate dataPedido;
    @Column(name="total", precision = 20, scale = 2) //precision: quantidade de digitos | scale: casas decimais
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private Set<ItemPedido> itens;
}
