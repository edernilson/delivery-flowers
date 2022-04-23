package com.edernilson.microservice.fornecedor.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.microservice.fornecedor.model.InfoFornecedor;
import com.edernilson.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

	private final InfoService infoService;

	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}

	@RequestMapping("/{estado}")
	public InfoFornecedor getInforPorEstado(@PathVariable String estado) {
		return infoService.getInforPorEstado(estado);
	}
}
