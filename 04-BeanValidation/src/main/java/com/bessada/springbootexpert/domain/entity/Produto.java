package com.bessada.springbootexpert.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="descricao")
    @NotEmpty(message="Campo descrição é obrigatório.")
    private String descricao;

    @Column(name="preco_unitario")
    @NotNull(message="Campo preço é obrigatório.")
    private BigDecimal preco;
}
