package com.edernilson.microservice.loja.service;

import org.springframework.stereotype.Service;

import com.edernilson.microservice.loja.client.FornecedorClient;
import com.edernilson.microservice.loja.controller.dto.CompraDTO;
import com.edernilson.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.edernilson.microservice.loja.dto.InfoPedidoDTO;
import com.edernilson.microservice.loja.model.Compra;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompraService {
	
	private final FornecedorClient fornecedorClient;
	
	public CompraService(FornecedorClient fornecedorClient) {
		this.fornecedorClient = fornecedorClient;
	}

	public Compra realizarCompra(CompraDTO compra) {
		String estado = compra.getEndereco().getEstado();
		log.info("Buscando informacoes do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInforPorEstado(estado);
		
		log.info("Realizando um pedido", estado);		
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());

		return compraSalva;	
	}

}
