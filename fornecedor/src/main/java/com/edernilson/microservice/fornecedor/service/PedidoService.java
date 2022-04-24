package com.edernilson.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edernilson.microservice.fornecedor.dto.ItemDoPedidoDTO;
import com.edernilson.microservice.fornecedor.model.Pedido;
import com.edernilson.microservice.fornecedor.model.PedidoItem;
import com.edernilson.microservice.fornecedor.model.Produto;
import com.edernilson.microservice.fornecedor.repository.PedidoRepository;
import com.edernilson.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	private final ProdutoRepository produtoRepository;

	public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {

		if (itens == null) {
			return null;
		}

		List<PedidoItem> pedidoItens = toPedidoItem(itens);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}

	public Pedido getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {

		List<Long> idsProdutos = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

		List<PedidoItem> pedidoItens = itens.stream().map(item -> {
			Produto produto = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setProduto(produto);
			pedidoItem.setQuantidade(item.getQuantidade());
			return pedidoItem;
		}).collect(Collectors.toList());
		return pedidoItens;
	}
}
