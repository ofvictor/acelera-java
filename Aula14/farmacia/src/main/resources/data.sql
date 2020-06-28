insert into produto (nome) values ('Aspirina');
insert into produto (nome) values ('Paracetamol 750mg');
insert into produto (nome) values ('Loratadina');
insert into produto (nome) values ('Rivotril');
insert into produto (nome) values ('Nasoclean');
insert into produto (nome) values ('Avamys');
insert into produto (nome) values ('Dorflex');
insert into produto (nome) values ('Fimatosan');
insert into produto (nome) values ('Vitasay');
insert into produto (nome) values ('Biotônico Fontoura');
insert into produto (nome) values ('Olina');

insert into pedido (data,origem) values ('2020-01-02 11:32:23','DrogaRaia');
insert into pedido (data,origem) values ('2020-01-03 15:00:01','Panvel');
insert into pedido (data,origem) values ('2020-01-04 19:53:17','São João');
insert into pedido (data,origem) values ('2020-01-05 00:00:01','Associadas');
insert into pedido (data,origem) values ('2020-01-06 08:19:11','Econômica');

insert into item_pedido (id_pedido,id_produto,quantidade) values (1,1,2);
insert into item_pedido (id_pedido,id_produto,quantidade) values (1,3,1);
insert into item_pedido (id_pedido,id_produto,quantidade) values (1,11,5);
insert into item_pedido (id_pedido,id_produto,quantidade) values (2,4,1);
insert into item_pedido (id_pedido,id_produto,quantidade) values (2,9,2);
insert into item_pedido (id_pedido,id_produto,quantidade) values (3,5,6);
insert into item_pedido (id_pedido,id_produto,quantidade) values (3,6,4);
