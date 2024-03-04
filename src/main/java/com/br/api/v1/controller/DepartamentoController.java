package com.br.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.v1.mapper.DepartamentoModelMapper;
import com.br.api.v1.mapper.DepartamentoModelMapperBack;
import com.br.api.v1.model.DepartamentoModel;
import com.br.api.v1.model.input.DepartamentoModelInput;
import com.br.domain.model.Departamento;
import com.br.domain.service.DepartamentoService;

import io.swagger.annotations.Api;

@Api(tags ="departamento")
@RestController
@RequestMapping("/v1/departamento")
public class DepartamentoController {
	@Autowired
	DepartamentoService departamentoService;
	@Autowired
	DepartamentoModelMapper departamentoModelMapper;
	@Autowired
	DepartamentoModelMapperBack departamentoModelMapperBack;

//	@GetMapping("/listar")
//	public ResponseEntity<List<Departamento>> getUsers() {
//		return ResponseEntity.status(HttpStatus.OK).body(null);
//	}
	
//	@GetMapping("/buscar/{id}")
//	public ResponseEntity<Departamento> getUser(@PathVariable(name = "id") Long id) {
//		return null;
//	}
//	@GetMapping("/buscar/{matricula}/matricula")
//	public ResponseEntity<UserMatriculaModel> getUser(@PathVariable(name = "matricula")String matricula) {
//			return null;
//		
//	}
	@GetMapping("/listar")
	public ResponseEntity<List<Departamento>> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(departamentoService.findAll());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<DepartamentoModel> cadastrar(@RequestBody @Valid DepartamentoModelInput departamentoModelInput) {
		Departamento departamento = departamentoModelMapperBack.toModel(departamentoModelInput);
		DepartamentoModel departamentoModel = departamentoModelMapper.toModel(departamentoService.save(departamento));
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModel);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Departamento> editar(@RequestBody Departamento departamento, 
			@PathVariable(name = "id") Long id) {
		departamento.setId(id);
		Departamento departamentoNew = departamentoService.save(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoNew);
	}
	
	@PatchMapping("/ativar/{id}")
    public ResponseEntity<Departamento> activateDepartamento(@RequestBody Departamento departamento, @PathVariable(name = "id") Long id ) {
		departamento.setId(id);
		Departamento departamentoNew = departamentoService.activaDepartamento(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoNew);
    
 }
   @PutMapping("/desativar/{id}")
    public ResponseEntity<Departamento> deactivateDepartamento(@RequestBody Departamento departamento, @PathVariable(name = "id") Long id ) {
	   departamento.setId(id);
	   Departamento departamentoNew = departamentoService.deactivateDepartamento(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoNew);
    }

//	}
//	
//	@PutMapping("/editar/{id}")
//	public ResponseEntity<UserModel> editar(@RequestBody UserModelInput userModelInput, 
//			@PathVariable(name = "id") Long id) {
//		return null;
//	}
//	
}