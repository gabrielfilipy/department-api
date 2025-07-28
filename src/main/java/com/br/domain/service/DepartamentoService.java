package com.br.domain.service;

import java.util.UUID;

import com.br.domain.model.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartamentoService {
	
	Page<Departamento> findAll(Pageable pageable);
	Departamento save ( Departamento departamento );
	Departamento deactivateDepartamento(UUID id);
	Departamento activaDepartamento(UUID id, Boolean active);
	Departamento findById(UUID id);
}
