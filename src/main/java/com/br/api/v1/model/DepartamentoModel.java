package com.br.api.v1.model;

import java.util.UUID;

import lombok.Data;

@Data
public class DepartamentoModel {

	private UUID departamentoId;
	private UUID orgaoId;
	private String nome;
	private String sigla;
	private String unidadePai;
	private String localidade;
	private boolean active;

}