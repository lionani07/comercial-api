package com.algaworks.comercial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.comercial.model.Empresa;

@Repository
public interface Empresas extends JpaRepository<Empresa, Long>{
	
	Optional<Empresa> findByNome(String nome);

}
