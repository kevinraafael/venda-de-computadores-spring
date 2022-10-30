CREATE TABLE public.cliente (
	id uuid DEFAULT uuid_generate_v4(),
	pessoaId uuid unique not null,
	PRIMARY KEY (id),
	FOREIGN KEY (pessoaId) REFERENCES public.pessoa(id)
);