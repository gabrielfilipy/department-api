package com.br.domain.service;

import java.util.UUID;

import com.br.domain.model.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface DepartamentoService {
	
	Departamento save ( Departamento departamento );
	Departamento deactivateDepartamento(UUID id);
	Departamento activaDepartamento(UUID id, Boolean active);
	Page<Departamento> findAll(Specification<Departamento> spec, Pageable pageable);
	Departamento findById(UUID id);
}
