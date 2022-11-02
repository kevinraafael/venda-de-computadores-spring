CREATE TABLE public.pessoa (
    id uuid DEFAULT uuid_generate_v4(),
    cpf varchar(11) UNIQUE NOT NULL,
    nome varchar(200) NULL,
    endereco varchar(200) NULL,
    telefone varchar(14) NULL,
    PRIMARY KEY (id)
);