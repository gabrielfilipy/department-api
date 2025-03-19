package com.br.api.v1.controller;

import java.util.UUID;

import javax.validation.Valid;

import com.br.api.v1.mapper.DepartamentoModelMapper;
import com.br.api.v1.model.input.DepartamentoModelInput;
import com.br.domain.service.spec.TemplateSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.br.api.v1.mapper.DepartamentoModelMapeerBack;
import com.br.api.v1.model.DepartamentoModel;
import com.br.api.v1.model.input.DepartamentoActiveModelInput;
import com.br.domain.model.Departamento;
import com.br.domain.service.DepartamentoService;
import io.swagger.annotations.Api;

@Api(tags ="departamento")
@CrossOrigin(origins = "*", maxAge = 3600)
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
	public ResponseEntity<DepartamentoModel> getUser(@PathVariable(name = "id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(departamentoModelMapper.toModel(departamentoService.findById(id)));
	}

	@GetMapping("/listar")
	public ResponseEntity<Page<Departamento>> getDepartamentos(TemplateSpec.DepartmentSpec spec,
																	@PageableDefault(page = 0, size = 5) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(departamentoService.findAll(spec, pageable));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<DepartamentoModel> cadastrar(@RequestBody @Valid DepartamentoModelInput departamentoModelInput) {
		Departamento departamento = departamentoModelMapeerBack.toModel(departamentoModelInput);
		DepartamentoModel departamentoModel = departamentoModelMapper.toModel(departamentoService.save(departamento));
		
		String routingKey = "department-created";

		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModel);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<DepartamentoModel> editar(@RequestBody DepartamentoModelInput departamentoModelInput,
			@PathVariable(name = "id") UUID id) {
		Departamento departamentoAtual = departamentoService.findById(id);
		departamentoModelMapeerBack.copyToDomainObject(departamentoModelInput, departamentoAtual);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.save(departamentoAtual)));
	}
	  
	@PatchMapping("/ativar-desativar/{id}")
    public ResponseEntity<DepartamentoModel> activateDepartamento(@RequestBody DepartamentoActiveModelInput departamentoActiveModelInput,
																  @PathVariable(name = "id") UUID id ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				departamentoModelMapper.toModel(departamentoService.activaDepartamento(id, departamentoActiveModelInput.isActive())));
 	}

    @PutMapping("/desativar/{id}")
    public ResponseEntity<DepartamentoModel> deactivateDepartamento(@RequestBody DepartamentoActiveModelInput departamentoActiveModelInput, @PathVariable(name = "id") UUID id ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.deactivateDepartamento(id)));
	}

}
