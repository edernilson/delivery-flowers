package com.edernilson.microservice.loja.model;

import lombok.Data;

@Data
public class Compra {

	private Long pedidoId;
	
	private Integer tempoDePreparo;
	
	private String enderecoDestino;
}
