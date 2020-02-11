USE reserva;

INSERT INTO modalidade(nome) VALUES ('Caminhada');
INSERT INTO modalidade(nome) VALUES ('Escalada');
INSERT INTO modalidade(nome) VALUES ('Mergulho');
INSERT INTO modalidade(nome) VALUES ('Salto de para-quedas');
INSERT INTO modalidade(nome) VALUES ('Corrida');
INSERT INTO modalidade(nome) VALUES ('Museu');
INSERT INTO modalidade(nome) VALUES ('Caminhada Histórica');

INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES
('Privativo', 'Passeio somente para pessoa ou casal');
INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES
('Em Grupo', 'Passeio para grupos abertos');
INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES
('Seletivo', 'Passeio para grupos fechados');

-- PAIS
INSERT INTO pais (nome_pais) VALUES ('Brasil');
INSERT INTO pais (nome_pais) VALUES ('Argentina');
INSERT INTO pais (nome_pais) VALUES ('Uruguai');
INSERT INTO pais (nome_pais) VALUES ('Chile');

-- ESTADO
INSERT INTO estado (nome_estado, id_pais) VALUES
('Rio Grande do Sul', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil'));
INSERT INTO estado (nome_estado, id_pais) VALUES
('Santa Catarina', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil'));
INSERT INTO estado (nome_estado, id_pais) VALUES
('Paraná', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil'));
INSERT INTO estado (nome_estado, id_pais) VALUES
('Mendoza', (SELECT id_pais FROM pais WHERE nome_pais = 'Argentina'));
INSERT INTO estado (nome_estado, id_pais) VALUES
('Santa Fé', (SELECT id_pais FROM pais WHERE nome_pais = 'Argentina'));
INSERT INTO estado (nome_estado, id_pais) VALUES
('Misiones', (SELECT id_pais FROM pais WHERE nome_pais = 'Argentina'));

-- CIDADE
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Porto Alegre', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio Grande do Sul'));
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Caxias do Sul', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio Grande do Sul'));
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Bagé', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio Grande do Sul'));
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Florianópolis', (SELECT id_estado FROM estado WHERE nome_estado = 'Santa Catarina'));
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Imbituba', (SELECT id_estado FROM estado WHERE nome_estado = 'Santa Catarina'));
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Curitiba', (SELECT id_estado FROM estado WHERE nome_estado = 'Paraná'));
INSERT INTO cidade (nome_cidade, id_estado)
VALUES ('Posadas', (SELECT id_estado FROM estado WHERE nome_estado = 'Misiones'));

-- GUIA
INSERT INTO guia (nome_guia, documento_guia, data_nascimento, credencial)
VALUES ('Romeu', '123456', '1980-01-01', '456789');
INSERT INTO guia (nome_guia, documento_guia, data_nascimento, credencial)
VALUES ('Julieta', '654321', '1990-01-01', '987654');
INSERT INTO guia (nome_guia, documento_guia, data_nascimento, credencial)
VALUES ('Hannibal Lecter', '142536', '1985-01-01', '362514');

-- Modalidades ROMEU
INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Caminhada'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Escalada'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Mergulho'));

-- Modalidades Julieta
INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Corrida'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Escalada'));

-- Modalidades Hannibal
INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Museu'));

INSERT INTO guia_modalidade (id_guia, id_modalidade)
VALUES(
(SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'), 
(SELECT id_modalidade FROM modalidade WHERE nome = 'Caminhada Histórica'));

-- Tipos de Passeio ROMEU
INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Privativo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Romeu'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Em Grupo'));

-- Tipos de Passeio JULIETA
INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Seletivo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Julieta'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Em Grupo'));

-- Tipos de Passeio Hannibal
INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Seletivo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Em Grupo'));

INSERT INTO guia_tipo_passeio (id_guia, id_tipo_passeio)
VALUES
((SELECT id_guia FROM guia WHERE nome_guia = 'Hannibal Lecter'),
(SELECT id_tipo_passeio FROM tipo_passeio WHERE nome_passeio = 'Privativo'));

-- VIAJANTE
INSERT INTO viajante (nome_viajante, documento_viajante, data_nascimento)
VALUES ('Jonathan', '123678', '1988-01-08');

INSERT INTO viajante (nome_viajante, documento_viajante, data_nascimento)
VALUES ('Jose', '369147', '1982-05-15');