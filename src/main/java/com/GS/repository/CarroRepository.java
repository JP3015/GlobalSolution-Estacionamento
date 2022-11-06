package com.GS.repository;

import org.springframework.data.repository.CrudRepository;

import com.GS.models.Carro;

public interface CarroRepository extends CrudRepository<Carro, Long>{
	Iterable<Carro> findByEstacionamento(Long estacionamento);
	Carro findByPlaca(String placa);
}
