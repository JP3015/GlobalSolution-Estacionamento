package com.GS.repository;

import org.springframework.data.repository.CrudRepository;

import com.GS.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
