package com.edernilson.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edernilson.microservice.loja.controller.dto.CompraDTO;
import com.edernilson.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	private final RestTemplate client;

	public CompraService(RestTemplate client) {
		this.client = client;
	}

	public void realizarCompra(CompraDTO compra) {

		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
