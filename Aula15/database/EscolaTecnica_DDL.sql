-- drop database escola_tecnica;

-- show databases;

-- create database escola_tecnica;

-- use escola_tecnica;

show tables;

-- CURSO
CREATE TABLE curso (
  id                       int          NOT NULL AUTO_INCREMENT,
  nome                     varchar(50)  NOT NULL,
  descricao                varchar(100) NOT NULL,
  requisitos               varchar(100) NOT NULL,
  modalidade               char(01)     NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ALUNO
CREATE TABLE aluno (
  id                       int          NOT NULL AUTO_INCREMENT,
  nome                     varchar(100) NOT NULL,
  cpf                      char(11)     NOT NULL,
  data_nascimento          char(08)     NOT NULL,
  telefone                 varchar(12)  NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- TURMA
CREATE TABLE turma (
  id                       int          NOT NULL AUTO_INCREMENT,
  id_curso                 int          NOT NULL,
  data_ini                 char(08)     NOT NULL,
  data_fim                 char(08)     NOT NULL,
  PRIMARY KEY (id),
  KEY FK_CURSO_IDX (id_curso),
  CONSTRAINT FK_CURSO FOREIGN KEY (id_curso) REFERENCES curso (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- MATRICULA
CREATE TABLE matricula (
  id                       int          NOT NULL AUTO_INCREMENT,
  id_turma                 int          NOT NULL,
  id_aluno                 int          NOT NULL,
  PRIMARY KEY (id),
  KEY FK_TURMA_IDX (id_turma),
  CONSTRAINT FK_TURMA FOREIGN KEY (id_turma) REFERENCES turma (id),
  KEY FK_ALUNO_IDX (id_aluno),
  CONSTRAINT FK_ALUNO FOREIGN KEY (id_aluno) REFERENCES aluno (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;