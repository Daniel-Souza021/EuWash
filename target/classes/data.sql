CREATE SEQUENCE seq_pk_servicos START 1;



CREATE TABLE Empresas (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_empresas'),
	razao_social varchar(100),
	nome_fantasia varchar(100),
	cnpj varchar(100)


CREATE SEQUENCE seq_pk_empresas START 1;


CREATE TABLE Servicos (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_servicos'),
	descricao varchar(100),
	preco varchar(100),
	categoria varchar(100)
	id_empresa integer,
	FOREIGN KEY (id_empresa) REFERENCES Empresa(id)
);
