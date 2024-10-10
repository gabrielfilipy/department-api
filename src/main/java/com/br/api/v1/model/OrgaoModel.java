package com.br.api.v1.model;

import com.br.api.v1.model.input.EnderecoModelInput;
import lombok.Data;

import java.util.UUID;

@Data
public class OrgaoModel {

    private UUID orgaoId;
    private String nome;
    private boolean active;
    private EnderecoModelInput endereco;

}