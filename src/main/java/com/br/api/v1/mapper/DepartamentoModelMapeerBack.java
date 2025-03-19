package com.br.api.v1.mapper;
import com.br.api.v1.model.input.DepartamentoActiveModelInput;
import com.br.api.v1.model.input.DepartamentoModelInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.domain.model.Departamento;

@Component
public class DepartamentoModelMapeerBack {

	@Autowired
	private ModelMapper modelMapper;

	public Departamento toModel(DepartamentoModelInput departamentoModelInput) {
		Departamento departamento =
				modelMapper.map(departamentoModelInput, Departamento.class);
		return departamento;
	}
	
	public Departamento toModel(DepartamentoActiveModelInput departamentoActiveModelInput) {
		Departamento departamento =
				modelMapper.map(departamentoActiveModelInput, Departamento.class);
		return departamento;
	}

	public void copyToDomainObject(DepartamentoModelInput departamentoModelInput, Departamento departamento) {
		modelMapper.map(departamentoModelInput, departamento);
	}

}
