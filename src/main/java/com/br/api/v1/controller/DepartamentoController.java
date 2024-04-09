package com.br.api.v1.controller;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.br.api.v1.mapper.DepartamentoModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.br.api.v1.mapper.DepartamentoModelMapeerBack;
import com.br.api.v1.model.DepartamentoModel;
import com.br.api.v1.model.input.DepartamentoModelInput;
import com.br.domain.model.Departamento;
import com.br.domain.service.DepartamentoService;
import io.swagger.annotations.Api;

@Api(tags ="departamento")
@RestController
@RequestMapping("/v1/department")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private DepartamentoModelMapper departamentoModelMapper;
	@Autowired
	private DepartamentoModelMapeerBack departamentoModelMapeerBack;
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<DepartamentoModel> getUser(@PathVariable(name = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(departamentoModelMapper.toModel(departamentoService.findById(id)));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<DepartamentoModel>> getDepartamentos() {
		List<Departamento> departamentos = departamentoService.findAll();
		List<DepartamentoModel> departamentoModel = departamentos.stream()
				.map(departamentoModelMapper::toModel)
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(departamentoModel);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<DepartamentoModel> cadastrar(@RequestBody @Valid DepartamentoModelInput departamentoModelInput) {
		Departamento departamento = departamentoModelMapeerBack.toModel(departamentoModelInput);
		DepartamentoModel departamentoModel = departamentoModelMapper.toModel(departamentoService.save(departamento));
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModel);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<DepartamentoModel> editar(@RequestBody DepartamentoModelInput departamentoModelInput, 
			@PathVariable(name = "id") Long id) {
		Departamento departamentoAtual = departamentoService.findById(id);
		departamentoModelMapeerBack.copyToDomainObject(departamentoModelInput, departamentoAtual);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.save(departamentoAtual)));
	}
	  
	@PatchMapping("/ativar/{id}")
    public ResponseEntity<DepartamentoModel> activateDepartamento(@RequestBody DepartamentoModelInput departamentoModelInput, @PathVariable(name = "id") Long id ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.activaDepartamento(id)));
 	}
   @PutMapping("/desativar/{id}")
   public ResponseEntity<DepartamentoModel> deactivateDepartamento(@RequestBody DepartamentoModelInput departamentoModelInput, @PathVariable(name = "id") Long id ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.deactivateDepartamento(id)));
	}

}
