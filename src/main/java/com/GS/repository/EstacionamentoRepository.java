package com.GS.repository;

import org.springframework.data.repository.CrudRepository;

import com.GS.models.Estacionamento;

public interface EstacionamentoRepository extends CrudRepository<Estacionamento, Long>{
	Estacionamento findByCodigo(long codigo);
}
