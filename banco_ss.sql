create database javaweb_project;
use javaweb_project;

create table usuario(
id_usuario INT auto_increment primary key,
nome VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
senha VARCHAR(255) NOT NULL,
cpf CHAR(11) UNIQUE NOT NULL,
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
status ENUM('Em-andamento','Finalizado'),
metodo_pagamento ENUM('Crédito, Débito, Pix, Boleto'),
valor_total INT NOT NULL,
data_hora datetime NOT NULL,
FOREIGN KEY (usuario_FK) REFERENCES usuario (id_usuario),
FOREIGN KEY (endereco_FK) REFERENCES endereço (id_endereco)
);

create table categoria(
id_categoria INT auto_increment primary key,
nome VARCHAR(255) UNIQUE NOT NULL
);

create table produto(
id_produto INT auto_increment primary key,
categoria_FK INT,
nome VARCHAR(255) NOT NULL,
imagem BLOB,
valor FLOAT(8,2),
FOREIGN KEY (categoria_FK) REFERENCES categoria(id_categoria)
);

create table pedido_produto(
id_pedido_produto INT auto_increment primary key,
pedido_FK INT,
produto_FK1 INT,
quantidade TINYINT,
preco_unitario FLOAT(8,2),
FOREIGN KEY (pedido_FK) REFERENCES pedido(id_pedido),
FOREIGN KEY (produto_FK1) REFERENCES produto(id_produto)
);

create table estoque(
id_estoque INT auto_increment primary key,
produto_FK2 INT,
quantidade_estoque INT,
FOREIGN KEY (produto_FK2) REFERENCES produto(id_produto)
);

insert into usuario(nome, email, senha, cpf, telefone)
values
('Henry','yuuki@gmail.com','1234','123456789','43988884444');

insert into usuario(nome, email, senha, cpf, telefone, acesso)
values
('Admin','admin@gmail.com','admin','987654321','43999998888','admin');
