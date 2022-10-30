CREATE TABLE public.funcionario (
	id uuid DEFAULT uuid_generate_v4(),
	matricula varchar(11) NOT NULL,
	data_contratacao date NULL,
	comissao numeric NULL,
	pf_gerencia bool NULL,
	pessoaId uuid unique not null,
	PRIMARY KEY (id),
	FOREIGN KEY (pessoaId) REFERENCES public.pessoa(id)
);