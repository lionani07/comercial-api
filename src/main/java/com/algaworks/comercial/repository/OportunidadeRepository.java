package com.algaworks.comercial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.comercial.model.Oportunidade;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
	
	Optional<Oportunidade> findByDescricaoAndNomeProspecto(String descricao, String nomeProspecto);

}
