package com.br.api.v1.model.input;

import lombok.*;
import java.util.UUID;
import javax.validation.constraints.*;

@Getter
@Setter
public class DepartamentoModelInput {

    private boolean active;
    private UUID orgaoId;
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
