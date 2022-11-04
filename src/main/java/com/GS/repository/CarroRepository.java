package com.GS.repository;

import org.springframework.data.repository.CrudRepository;

import com.GS.models.Carro;
import com.GS.models.Estacionamento;

public interface CarroRepository extends CrudRepository<Carro, String>{
	Iterable<Carro> findByEstacionamento(Estacionamento estacionamento);
	Carro findByPlaca(String placa);
}
