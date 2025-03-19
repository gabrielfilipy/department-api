package com.br.domain.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

@Data
@Table(name = "TBL_DEPARTAMENTO")
@Entity
public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID departamentoId;
	
	private boolean active;
	 
	@Column(name = "orgao_id")
	private UUID orgaoId;

	@NotNull
	@NotBlank
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
