package com.br.api.v1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags ="departamento")
@RestController
@RequestMapping("/v1/departamento")
public class DepartamentoController {

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
//	@PostMapping("/cadastrar")
//	public ResponseEntity<UserModel> cadastrar(@RequestBody @Valid UserModelInput userModelInput) {
//		return null;	
//	}
//	
//	@PutMapping("/editar/{id}")
//	public ResponseEntity<UserModel> editar(@RequestBody UserModelInput userModelInput, 
//			@PathVariable(name = "id") Long id) {
//		return null;
//	}
//	
}
