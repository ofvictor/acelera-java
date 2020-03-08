-- drop database farmacia;

-- show databases;

-- create database farmacia;

-- use farmacia;

-- show tables;

-- PEDIDO
CREATE TABLE pedido (
  id                       int          NOT NULL AUTO_INCREMENT,
  data                     varchar(10)  NOT NULL,
  origem                   varchar(20)  NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- PRODUTO
CREATE TABLE produto (
  id                       int          NOT NULL AUTO_INCREMENT,
  nome                     varchar(50)  NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ORDEM DE COMPRA
CREATE TABLE ordem_compra (
  id                       int          NOT NULL AUTO_INCREMENT,
  id_pedido                int          NOT NULL,
  id_produto               int          NOT NULL,
  quantidade               int          NOT NULL,
  PRIMARY KEY (id),
  KEY FK_PEDIDO_IDX (id_pedido),
  CONSTRAINT FK_PEDIDO FOREIGN KEY (id_pedido) REFERENCES pedido (id),
  KEY FK_PRODUTO_IDX (id_produto),
  CONSTRAINT FK_PRODUTO FOREIGN KEY (id_produto) REFERENCES produto (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;