drop database javaweb_project;
create database javaweb_project;
use javaweb_project;

create table usuario(
id_usuario INT auto_increment primary key,
nome VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
senha VARCHAR(255) NOT NULL,
cpf CHAR(14) UNIQUE NOT NULL,
telefone CHAR(14) UNIQUE NOT NULL,
data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
acesso VARCHAR(30) DEFAULT 'cliente'
);

create table endereço(
id_endereco INT auto_increment primary key,
rua VARCHAR(255) NOT NULL,
numero INT NOT NULL,
cep CHAR(9) NOT NULL,
complemento VARCHAR(255) NOT NULL
);

create table pedido(
id_pedido INT auto_increment primary key,
usuario_FK INT,
endereco_FK INT,
metodo_pagamento ENUM('Crédito, Débito, Pix, Boleto'),
valor_total INT NOT NULL,
data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (usuario_FK) REFERENCES usuario (id_usuario),
FOREIGN KEY (endereco_FK) REFERENCES endereço (id_endereco)
);

create table categoria(
id_categoria INT auto_increment primary key,
nome VARCHAR(255) UNIQUE NOT NULL
);

create table setor(
id_setor INT auto_increment primary key,
nome VARCHAR(255) UNIQUE NOT NULL
);

create table produto(
id_produto INT auto_increment primary key,
categoria_FK INT,
setor_FK INT,
nome VARCHAR(255) NOT NULL,
descricao VARCHAR(255) NOT NULL,
setor VARCHAR(255),
imagem LONGBLOB,
valor FLOAT(8,2),
FOREIGN KEY (categoria_FK) REFERENCES categoria(id_categoria),
FOREIGN KEY (setor_FK) REFERENCES setor(id_setor)
);

create table carrinho(
id_carrinho INT auto_increment primary key,
usuario_FK INT,
produto_FK INT,
quantidade INT NOT NULL
);

insert into usuario(nome, email, senha, cpf, telefone)
values
('Henry','yuuki@gmail.com','1234','123456789','43988884444');
    
insert into usuario(nome, email, senha, cpf, telefone, acesso)
values
('Admin','admin@gmail.com','admin','987654321','43999998888','admin');

insert into categoria(nome)
values
('Caixas de Som'),
('Soundbar');

insert into setor(nome)
values
('Recomendações');