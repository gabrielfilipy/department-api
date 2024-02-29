package com.br.api.v1.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoModel {
	
    private String orgao;
	private String nome;
	private String sigla;
	private String unidadePai;
	private String localidade;

}