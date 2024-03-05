package com.br.api.v1.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.api.v1.controller.model.DepartamentoModel;
import com.br.domain.model.Departamento;

@Component
public class DepartamentoModelMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	public DepartamentoModel toModel(Departamento departamento) {
		DepartamentoModel departamentoModel =
				modelMapper.map(departamento, DepartamentoModel.class);
		return departamentoModel;
		
		
	}
	

}
