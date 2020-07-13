select  b.id
       ,b.name    as 'Bank name'
       ,b.number  as 'Bank number'
       ,a.name    as 'Agency name'
       ,a.number  as 'Agency number'
from    bank   b
       ,agency a
where   a.id_bank = b.id;

select  c.name             as 'Customer'
       ,b.name             as 'Bank'
       ,a.name             as 'Agency'
       ,u.account_balance  as 'Balance'
from    customer_account u
       ,customer         c
       ,agency           a
       ,bank             b
where   c.id          = u.id_customer
  and   a.id          = u.id_agency
  and   b.id          = a.id_bank;
  
  
-- Workaround para a aplicação funcionar em docker-compose enquanto não se consegue ajustar corretamente o application.yml.
-- IMPORTANTE: deve ser realizado enquanto a aplicação está 'no ar', após o erro de criação do BD ter ocorrido. 
-- Consultar status do MySQL instalado na máquina e, se necessário, baixá-lo
$ systemctl status mysql
$ systemctl stop mysql
-- Entrar no container do MySQL enquanto a aplicação roda
$ 'docker exec -it mysql-server bash
$ mysql -p
mysql> show databases;
mysql> drop database transaction;

-- Para ajustar data/hora no MySQL
update transaction_account set transaction_moment = STR_TO_DATE('2020-01-01 00:00:01','%Y-%m-%d %H:%i:%s') where id = 1;
