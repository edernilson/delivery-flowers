package com.edernilson.microservice.loja.service;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edernilson.microservice.loja.controller.dto.CompraDTO;
import com.edernilson.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	private final RestTemplate client;
	
	private final DiscoveryClient eurekaClient;

	public CompraService(RestTemplate client, DiscoveryClient eurekaClient) {
		this.client = client;
		this.eurekaClient = eurekaClient;
	}

	public void realizarCompra(CompraDTO compra) {

		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		
		eurekaClient.getInstances("fornecedor").stream()
		.forEach(fornecedor -> {
			System.out.println("localhost: "+fornecedor.getPort());
		});
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
