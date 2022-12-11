package com.bessada.springbootexpert.domain.repository;

import com.bessada.springbootexpert.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

    @Query(value = "select c from Cliente c where c.nome like :nome")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);
    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    //caso queria fazer por query method, é preciso especificar que além da consulta, essse método NÃO É UMA CONSULTA
    //@Query("delete from Cliente c where c.nome = :nome")
    //@Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id = :id") // para trazer somente se o cliente tiver um pedido, retirar o oleft
    Cliente findClienteFetchPedidos(@Param("id") Integer id);


}
