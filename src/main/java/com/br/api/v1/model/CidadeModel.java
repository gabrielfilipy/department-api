package com.br.api.v1.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CidadeModel{

    private UUID id;

    private EstadoModel estado;
}