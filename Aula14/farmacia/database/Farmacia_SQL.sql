-- use farmacia;

insert into pedido (data,origem) values ('2020/01/02','DrogaRaia');
insert into pedido (data,origem) values ('2020/01/03','Panvel');
insert into pedido (data,origem) values ('2020/01/04','São João');
insert into pedido (data,origem) values ('2020/01/05','Associadas');
insert into pedido (data,origem) values ('2020/01/06','Econômica');

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

insert into ordem_compra (id_pedido,id_produto,quantidade) values (1,1,2);
insert into ordem_compra (id_pedido,id_produto,quantidade) values (1,3,1);
insert into ordem_compra (id_pedido,id_produto,quantidade) values (1,11,5);
insert into ordem_compra (id_pedido,id_produto,quantidade) values (2,4,1);
insert into ordem_compra (id_pedido,id_produto,quantidade) values (2,9,2);
insert into ordem_compra (id_pedido,id_produto,quantidade) values (3,5,6);
insert into ordem_compra (id_pedido,id_produto,quantidade) values (3,6,4);


select * from pedido;
select * from produto;
select  pd.id
       ,pd.data
       ,pd.origem
       ,pr.id
       ,pr.nome
       ,oc.id
       ,oc.quantidade
from   ordem_compra oc
      ,pedido pd
      ,produto pr
where  pd.id      = oc.id_pedido
  and  pr.id      = oc.id_produto;