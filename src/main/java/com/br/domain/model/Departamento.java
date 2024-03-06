package com.br.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "TBL_DEPARTAMENTO")
@Entity
public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean active;

	@NotNull
	@NotBlank
	@Column(name = "orgao")
	private String orgao;
	

	@NotNull
	@NotBlank
	@JsonIgnore
	@Column(name = "nome")
	private String nome;
	
	
	@NotNull
	@NotBlank
	@Column(name = "sigla")
	private String sigla;
	
	
	@NotNull
	@NotBlank
	@Column(name = "unidadePai")
	private String unidadePai;
	
	
	@NotNull
	@NotBlank
	@Column(name = "localidade")
	private String localidade;

}
