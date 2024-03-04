package com.br.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoModelInput {
	
    private String orgao;
	private String nome;
	private String sigla;
	private String unidadePai;
	private String localidade;
	
	
}