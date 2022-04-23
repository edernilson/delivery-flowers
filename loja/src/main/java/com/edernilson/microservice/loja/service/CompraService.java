package com.edernilson.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edernilson.microservice.loja.controller.dto.CompraDTO;
import com.edernilson.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	public void realizarCompra(CompraDTO compra) {

		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
