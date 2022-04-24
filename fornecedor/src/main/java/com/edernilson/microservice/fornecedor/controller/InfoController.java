package com.edernilson.microservice.fornecedor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.microservice.fornecedor.model.InfoFornecedor;
import com.edernilson.microservice.fornecedor.service.InfoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/info")
public class InfoController {

	private final InfoService infoService;

	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}

	@GetMapping("/{estado}")
	public InfoFornecedor getInforPorEstado(@PathVariable String estado) {
		log.info("Recebido pedido de informações do fornecedor {}", estado);
		return infoService.getInforPorEstado(estado);
	}
}
