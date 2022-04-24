package com.edernilson.microservice.fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edernilson.microservice.fornecedor.model.Produto;
import com.edernilson.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

}
