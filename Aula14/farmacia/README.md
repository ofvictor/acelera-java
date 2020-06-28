-- To manually load DDL and SQL files 
source src/main/resources/schema.sql;
source src/main/resources/data.sql;

-- How to insert directly in MySQL using STR_TO_DATE (it didn't work on JPA)
insert into pedido (data,origem) values (STR_TO_DATE('2020/01/02 11:32:23','%Y/%m/%d %H:%i:%s'),'DrogaRaia');
insert into pedido (data,origem) values (STR_TO_DATE('2020/01/03 15:00:01','%Y/%m/%d %H:%i:%s'),'Panvel');
insert into pedido (data,origem) values (STR_TO_DATE('2020/01/04 19:53:17','%Y/%m/%d %H:%i:%s'),'São João');
insert into pedido (data,origem) values (STR_TO_DATE('2020/01/05 00:00:01','%Y/%m/%d %H:%i:%s'),'Associadas');
insert into pedido (data,origem) values (STR_TO_DATE('2020/01/06 08:19:11','%Y/%m/%d %H:%i:%s'),'Econômica');

-- SQL command to list Orders and its items
select  pd.id
       ,pd.data
       ,pd.origem
       ,pr.id
       ,pr.nome
       ,ip.quantidade
from    pedido      pd
       ,item_pedido ip
       ,produto     pr
where   ip.id_pedido = pd.id
  and   pr.id        = ip.id_produto;


-- Verificando se o BD está no ar
systemctl status mysql.service
-- Como subir o BD
sudo systemctl start mysql


-- Docker tests and commands
docker run --name mysql-server -e MYSQL_ROOT_PASSWORD=secretapacas -d mysql:latest
docker exec -it mysql-server bash

-- 1. Build the application
$ ./gradlew clean build
-- 2. Run all the containers in the same network orchestrated by docker-compose
$ docker-compose up
