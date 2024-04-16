package com.br.domain.service;

import java.util.List;

import com.br.domain.model.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface DepartamentoService {
	
	Departamento save ( Departamento departamento );
	Departamento deactivateDepartamento(Long id);
	Departamento activaDepartamento(Long id, Boolean active);
	Page<Departamento> findAll(Specification<Departamento> spec, Pageable pageable);
	Departamento findById(Long id);
}
