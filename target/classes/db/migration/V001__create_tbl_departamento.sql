CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_DEPARTAMENTO (
    departamento_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    active BOOLEAN,
    orgao_id UUID,
    nome VARCHAR(255) NOT NULL,
    sigla VARCHAR(50) NOT NULL,
    unidade_pai VARCHAR(255) NOT NULL,
    localidade VARCHAR(255) NOT NULL
);
