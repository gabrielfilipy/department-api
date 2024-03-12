package com.br.api.v1;
import java.util.List;
import java.util.stream.Collectors;

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
import com.br.api.v1.controller.mapper.DepartamentoModelMapper;
import com.br.api.v1.controller.mapper.DepartamentoModelCopy;
import com.br.api.v1.controller.mapper.DepartamentoModelMapeerBack;
import com.br.api.v1.controller.model.DepartamentoModel;
import com.br.api.v1.controller.model.input.DepartamentoModelInput;
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
	DepartamentoModelMapeerBack departamentoModelMapeerBack;
	@Autowired
	DepartamentoModelCopy departamentoModelCopy;

	
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
		departamentoModelCopy.copyToDomainObject(departamentoModelInput, departamentoAtual);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.save(departamentoAtual)));
	}
	  
	@PatchMapping("/ativar/{id}")
    public ResponseEntity<DepartamentoModel> activateDepartamento(@RequestBody DepartamentoModelInput departamentoModelInput, @PathVariable(name = "id") Long id ) {
		Departamento departamento = departamentoService.findById(id);
		departamentoModelCopy.copyToDomainObject(departamentoModelInput, departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.activaDepartamento(id)));
	    
 }
   @PutMapping("/desativar/{id}")
   public ResponseEntity<DepartamentoModel> deactivateDepartamento(@RequestBody DepartamentoModelInput departamentoModelInput, @PathVariable(name = "id") Long id ) {
		Departamento departamento = departamentoService.findById(id);
		departamentoModelCopy.copyToDomainObject(departamentoModelInput, departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoModelMapper.toModel(departamentoService.deactivateDepartamento(id)));
    }


}
