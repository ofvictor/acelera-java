show databases;

use reserva;

show tables;

select * from tipo_passeio; -- 3
select * from modalidade; -- 7
select * from pais; -- 1
select * from estado; -- 1
select * from cidade; -- 1
select * from guia; -- 3
select * from viajante; -- 2

select   g.nome_guia
        ,m.nome
from     guia_modalidade gm
	    ,guia            g
        ,modalidade      m
where    g.id_guia       = gm.id_guia
  and    m.id_modalidade = gm.id_modalidade
order by g.nome_guia;

select   g.nome_guia
        ,t.nome
from     guia_tipo gt
        ,guia      g
        ,tipo      t
where    g.id_guia = gt.id_guia
  and    t.id_tipo = gt.id_tipo
order by g.nome_guia;