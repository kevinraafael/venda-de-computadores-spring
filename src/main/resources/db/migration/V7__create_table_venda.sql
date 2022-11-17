CREATE TABLE public.venda
(
    id              uuid DEFAULT uuid_generate_v4(),
    codigo          int     NOT NULL,
    forma_pagamento uuid    NOT NULL,
    cliente_id      uuid    NOT NULL,
    funcionario_id  uuid    not NULL,
    valor           numeric not null,

    PRIMARY KEY (id),
    FOREIGN KEY (funcionario_id) REFERENCES public.funcionario (id),
    FOREIGN KEY (forma_pagamento) REFERENCES public.pagamento (id),
    FOREIGN KEY (cliente_id) REFERENCES public.cliente (id)
);