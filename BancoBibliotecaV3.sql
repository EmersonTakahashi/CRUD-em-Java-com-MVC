create database biblioteca;
use biblioteca;

create table tbl_leitores(
	
    cod_leitores int not null primary key auto_increment,
    nome varchar(100) not null,
    email varchar(50) not null,
    telefone int not null    
);

create table tbl_livros(

	cod_livros int not null primary key auto_increment,
    titulo varchar(100) not null,
    autor varchar(100) not null,
    editora varchar(100) not null,
    dataLancamento varchar(10) not null
);
select * from tbl_livros;

create table tbl_endereco(

	cod_endereco int not null primary key auto_increment,
    rua varchar(100) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    numero int not null
);

create table tbl_emprestimo(

	cod_emprestimo int not null primary key auto_increment,
    qnt int not null,
    dataEmprestimo varchar(20) not null,
    dataDevolucao varchar(20) not null
);


select * from tbl_livros;

#aisaisdaoksdako

select * from tbl_livros;