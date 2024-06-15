package com.br.api.v1.model.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DepartamentoModelInput {

    private boolean active;
    private Long orgaoId;
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
