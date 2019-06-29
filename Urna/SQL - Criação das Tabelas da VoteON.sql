create schema urna;
drop schema urna;
use urna;

create table usuario (
nome varchar(30) not null,
nascimento date not null,
emissao_titulo date not null,
cpf varchar(11) not null,
senha varchar(20) not null,
fk_id_zona int not null,
fk_id_secao int not null,
fk_nivel int not null,
habilitado boolean not null,
votado boolean not null,
titulo varchar (12) not null primary key
);


insert into usuario values('Junior','1996-07-25','2007-07-12','42032538877','1234',1,1,1,0,0,'012345678910');
insert into usuario values('Kelvin','1996-07-25','2007-07-12','42032538844','1234',1,1,1,0,0,'012345678911');

insert into usuario values('Pedro','1989-07-31','2005-05-05','42032538845','1234',1,1,2,0,0,'012345678912');

insert into usuario values('Alex','1978-03-17','2002-12-15','42032538846','1234',1,1,3,0,0,'012345678913');

create table secao_eleitoral (
id_secao int primary key not null,
fk_id_zona int not null
);

insert into secao_eleitoral values(01,01);

create table zona (
id_zona int primary key not null,
nome varchar(50) not null,
fk_id_cidade int not null
);

insert into zona values (01, 'E.E. Prof. Jessen Vidal', 01);

create table cidade (
id_cidade int primary key not null,
nome varchar(50) not null,
fk_id_uf int not null
);

insert into cidade values (01,'Caçapava', 10);

create table uf (
id_uf int primary key not null,
nome varchar(50) not null
);

insert into uf values (10, 'sp');
insert into uf values (11, 'rj');

create table permissao_usr (
nome varchar (35) not null,
nivel int primary key not null
);

insert into permissao_usr values ('eleitor',1);
insert into permissao_usr values ('mesario',2);
insert into permissao_usr values ('chefe',3);

create table auditoria (
data_alteracao date not null,
fk_titulo varchar(12) not null,
descricao varchar(100) not null,
id int primary key not null auto_increment
);

create table candidatos (
id int not null primary key auto_increment,
nome varchar (50) not null,
partido varchar (15) not null,
votos int not null,
numero int (2) unique,
link varchar (1000) 
);

insert into candidatos values (null,'Kratos','Sony',0,8,'https://pm1.narvii.com/6821/ac5c009801812b7b43c3e12c55bcfaca96234383v2_hq.jpg');
insert into candidatos values (null,'Goku','DBZ',0,51,'https://p2.trrsf.com/image/fget/cf/940/0/images.terra.com/2018/05/09/goku2.jpg');
insert into candidatos values (null,'Chaves','SBT',0,4, 'https://www.ocanal.com.br/wp-content/uploads/2019/06/chaves-1000x600.jpg');
insert into candidatos values (null,'Naruto','TOKYO',0,15, 'https://vignette.wikia.nocookie.net/naruto/images/3/33/Naruto_Uzumaki_%28Parte_I_-_HD%29.png/revision/latest?cb=20160316113315&path-prefix=pt-br');

ALTER TABLE usuario
ADD FOREIGN KEY (fk_id_zona) REFERENCES zona(id_zona);

ALTER TABLE usuario
ADD FOREIGN KEY (fk_id_secao) REFERENCES secao_eleitoral(id_secao);

ALTER TABLE usuario
ADD FOREIGN KEY (fk_nivel) REFERENCES permissao_usr(nivel);

ALTER TABLE cidade
ADD FOREIGN KEY (fk_id_uf) REFERENCES uf(id_uf);

ALTER TABLE zona
ADD FOREIGN KEY (fk_id_cidade) REFERENCES cidade(id_cidade);

ALTER TABLE secao_eleitoral
ADD FOREIGN KEY (fk_id_zona) REFERENCES zona(id_zona);

ALTER TABLE auditoria
ADD FOREIGN KEY (fk_titulo) REFERENCES usuario(titulo);