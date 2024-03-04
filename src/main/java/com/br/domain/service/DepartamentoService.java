package com.br.domain.service;

import java.util.List;

import com.br.domain.model.Departamento;

public interface DepartamentoService {
	
	Departamento save ( Departamento departamento );
	Departamento findByID (Long id);
	Departamento deactivateDepartamento(Long id);
	Departamento activaDepartamento(Long id);
	List<Departamento> findAll();
}
