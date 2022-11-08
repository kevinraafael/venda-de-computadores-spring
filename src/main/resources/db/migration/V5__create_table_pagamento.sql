create table public.pagamento(
    id uuid default uuid_generate_v4(),
    valor_total numeric not null ,
    tipo_pagamento varchar(10) not null,
    parcelamento int ,
    desconto numeric null,
    primary key (id)

)