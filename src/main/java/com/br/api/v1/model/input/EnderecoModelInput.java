package com.br.api.v1.model.input;

import com.br.api.v1.model.CidadeModel;
import lombok.Data;

@Data
public class EnderecoModelInput {

    private String cep;

    private CidadeModel cidade;
}
