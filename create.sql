create sequence hibernate_sequence start with 1 increment by 1
create table movimento_manual (dat_mes integer not null, num_lancamento integer not null, dat_ano integer not null, des_descricao varchar(255), dat_movimento timestamp, cod_usuario varchar(255), val_valor float, cod_produto integer, cod_cosif integer, primary key (dat_mes, num_lancamento, dat_ano))
create table produto (cod_produto integer not null, des_produto varchar(255), sta_status varchar(255), primary key (cod_produto))
create table produto_cosif (cod_cosif integer not null, cod_classificacao varchar(255), sta_status varchar(255), cod_produto integer, primary key (cod_cosif))
alter table movimento_manual add constraint fk_movimento_manual_produto foreign key (cod_produto) references produto
alter table movimento_manual add constraint fk_movimento_manual_produto_cosif foreign key (cod_cosif) references produto_cosif
alter table produto_cosif add constraint fk_produto_cosif_produto foreign key (cod_produto) references produto