package com.br.api.v1.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DepartamentoModelInput {

	private boolean active;
	private String orgao;
	@NotNull
	@NotBlank
	private String nome;
	@NotNull
	@NotBlank
	private String sigla;
	@NotNull
	@NotBlank
	private String unidadePai;
	@NotNull
	@NotBlank
	private String localidade;
}
