package com.edernilson.microservice.fornecedor.service;

import org.springframework.stereotype.Service;

import com.edernilson.microservice.fornecedor.model.InfoFornecedor;
import com.edernilson.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	private final InfoRepository infoRepository;

	public InfoService(InfoRepository infoRepository) {
		this.infoRepository = infoRepository;
	}

	public InfoFornecedor getInforPorEstado(String estado) {
		return infoRepository.findByEstado(estado);
	}

}
