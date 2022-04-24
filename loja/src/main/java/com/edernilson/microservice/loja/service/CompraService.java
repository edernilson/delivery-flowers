package com.edernilson.microservice.loja.service;

import org.springframework.stereotype.Service;

import com.edernilson.microservice.loja.client.FornecedorClient;
import com.edernilson.microservice.loja.controller.dto.CompraDTO;
import com.edernilson.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.edernilson.microservice.loja.dto.InfoPedidoDTO;
import com.edernilson.microservice.loja.model.Compra;

@Service
public class CompraService {
	

	private final FornecedorClient fornecedorClient;
	
	public CompraService(FornecedorClient fornecedorClient) {
		this.fornecedorClient = fornecedorClient;
	}

	public Compra realizarCompra(CompraDTO compra) {
		InfoFornecedorDTO info = fornecedorClient.getInforPorEstado(compra.getEndereco().getEstado());
		
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		System.out.println(info.getEndereco());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
	
		return compraSalva;	
	}

}
