ALTER TABLE public.item_venda add column computador_id uuid;

ALTER TABLE item_venda
    ADD CONSTRAINT FK_ITEM_VENDA_ON_COMPUTADOR FOREIGN KEY (computador_id) REFERENCES computador (id);