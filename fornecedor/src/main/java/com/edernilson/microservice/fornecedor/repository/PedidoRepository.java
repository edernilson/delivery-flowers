package com.edernilson.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import com.edernilson.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
