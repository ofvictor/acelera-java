show databases;

use reserva;

show tables;

select * from modalidade; -- 7
select * from tipo_passeio; -- 3
select * from pais; -- 4
select * from estado; -- 6
select * from cidade; -- 7
select * from guia; -- 3
select * from guia_modalidade; -- 7
select * from guia_tipo_passeio; -- 7
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
        ,t.nome_passeio
from     guia_tipo_passeio gt
        ,guia              g
        ,tipo_passeio      t
where    g.id_guia         = gt.id_guia
  and    t.id_tipo_passeio = gt.id_tipo_passeio
order by g.nome_guia;