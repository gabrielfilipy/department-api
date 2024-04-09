package com.br.api.v1.model;

import lombok.Data;

@Data
public class DepartamentoModel {
	
    private String orgao;
	private String nome;
	private String sigla;
	private String unidadePai;
	private String localidade;

}