package com.br.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.domain.exception.EntidadeNaoExisteException;
import com.br.domain.model.Departamento;
import com.br.domain.repository.DepartamentoRepository;
import com.br.domain.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	@Override
	public Departamento activaDepartamento(Long id) {
		Departamento departamento = departamentoRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	        departamento.setActive(true);
	        return departamentoRepository.save(departamento);
	    }
    @Override
		public Departamento deactivateDepartamento (Long id) {
		Departamento departamento = departamentoRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	        departamento.setActive(false);
	        return departamentoRepository.save(departamento);
	    }
	
	@Override
	public Departamento save (Departamento departamento) {
		departamento.setActive(true);
		return departamentoRepository.save(departamento);
	}

	@Override
	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}
	
	@Override
	public Departamento findByID(Long id) {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		if(!departamento.isPresent()) {
			throw new EntidadeNaoExisteException("Departamento não encontrado com o ID: " + id);
		}
		return departamento.get();
	}
}
