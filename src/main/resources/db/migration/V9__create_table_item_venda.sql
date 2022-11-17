CREATE TABLE item_venda
(
    id            UUID    NOT NULL,
    venda_id      UUID,
    qtd_vendida   INTEGER NOT NULL,
    valor_vendido INTEGER NOT NULL,
    CONSTRAINT pk_item_venda PRIMARY KEY (id)
);

ALTER TABLE item_venda
    ADD CONSTRAINT FK_ITEM_VENDA_ON_VENDA FOREIGN KEY (venda_id) REFERENCES venda (id);