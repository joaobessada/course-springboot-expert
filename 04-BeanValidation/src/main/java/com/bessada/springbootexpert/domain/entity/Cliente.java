package com.bessada.springbootexpert.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome", length=100)
    @NotEmpty(message="Campo nome é obrigatório!")
    private String nome;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message="Campo CPF é obrigatório!")
    @CPF(message = "Informe um CPF válido.")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch=FetchType.LAZY) // para que seja possivel acessar todos os pedidos de um cliente diretamente do cliente | LAZY OFF, EAGER ON
    private Set<Pedido> pedidos;

    public Cliente(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }
}