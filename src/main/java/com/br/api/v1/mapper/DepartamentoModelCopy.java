package com.br.api.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.api.v1.model.input.DepartamentoModelInput;
import com.br.domain.model.Departamento;

@Component
public class DepartamentoModelCopy {

	@Autowired
	private ModelMapper modelMapper;
	
	public void copyToDomainObject(DepartamentoModelInput departamentoModelInput, Departamento departamento) {
		modelMapper.map(departamentoModelInput, departamento);
	}
}
