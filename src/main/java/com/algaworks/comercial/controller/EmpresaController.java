package com.algaworks.comercial.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.repository.Empresas;

@CrossOrigin
@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private Empresas empresas;
	
	@GetMapping
	public List<Empresa> listar(){
		return empresas.findAll();
	}
	
	@PostMapping
	public Empresa adicionar(@Valid @RequestBody Empresa empresa){
		Optional<Empresa> empresaExiste = empresas.findByNome(empresa.getNome());
		if(empresaExiste.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa existe");
		}
		return empresas.save(empresa);
	}

}
