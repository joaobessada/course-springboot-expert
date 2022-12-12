package com.bessada.springbootexpert.service.impl;

import com.bessada.springbootexpert.domain.entity.Cliente;
import com.bessada.springbootexpert.domain.entity.ItemPedido;
import com.bessada.springbootexpert.domain.entity.Pedido;
import com.bessada.springbootexpert.domain.entity.Produto;
import com.bessada.springbootexpert.domain.repository.Clientes;
import com.bessada.springbootexpert.domain.repository.ItensPedido;
import com.bessada.springbootexpert.domain.repository.Pedidos;
import com.bessada.springbootexpert.domain.repository.Produtos;
import com.bessada.springbootexpert.exception.RegraNegocioException;
import com.bessada.springbootexpert.rest.dto.ItemPedidoDTO;
import com.bessada.springbootexpert.rest.dto.PedidoDTO;
import com.bessada.springbootexpert.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItensPedido itensPedidoRepository;

    @Override
    @Transactional // se acontecer um erro no meio da operação, ocorre um rollback - ou faz tudo, ou faz nada
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }


    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens) {
        if(itens.isEmpty()) throw new RegraNegocioException("Não é possível realizar um pedido sem itens");
        return itens
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                                        .findById(idProduto)
                                        .orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).toList();
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }
}
