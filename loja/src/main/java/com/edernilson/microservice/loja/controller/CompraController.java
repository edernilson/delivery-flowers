package com.edernilson.microservice.loja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.microservice.loja.controller.dto.CompraDTO;
import com.edernilson.microservice.loja.model.Compra;
import com.edernilson.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	private final CompraService compraService;

	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}

	@PostMapping
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		return compraService.realizarCompra(compra);
	}

}
