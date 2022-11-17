CREATE TABLE computador
(
    id            UUID NOT NULL,
    modelo        VARCHAR(255),
    processador   VARCHAR(255),
    memoria       VARCHAR(255),
    armazenamento VARCHAR(255),
    so            VARCHAR(255),
    valor         DOUBLE PRECISION,
    CONSTRAINT pk_computador PRIMARY KEY (id)
);