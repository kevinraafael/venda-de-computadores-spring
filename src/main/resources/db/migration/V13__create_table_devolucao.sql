CREATE TABLE devolucao
(
    id             UUID NOT NULL,
    item_venda_id  UUID,
    funcionario_id UUID,
    motivo         VARCHAR(255),
    dt_devolucao   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_devolucao PRIMARY KEY (id)
);

ALTER TABLE devolucao
    ADD CONSTRAINT FK_DEVOLUCAO_ON_FUNCIONARIO FOREIGN KEY (funcionario_id) REFERENCES funcionario (id);

ALTER TABLE devolucao
    ADD CONSTRAINT FK_DEVOLUCAO_ON_ITEM_VENDA FOREIGN KEY (item_venda_id) REFERENCES item_venda (id);