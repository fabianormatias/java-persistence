-- -----------------------------------------------------
-- Criar o banco
-- -----------------------------------------------------
CREATE DATABASE hibernate_teste;

-- -----------------------------------------------------
-- Tabelas do Ex OneToOne pai-no-filho
-- -----------------------------------------------------
-- Pai
CREATE TABLE `estado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
-- Filho
CREATE TABLE `cidade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `estado_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a3ta6r7feb5d6qprja71kwh6u` (`estado_id`),
  CONSTRAINT `FK_a3ta6r7feb5d6qprja71kwh6u` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- -----------------------------------------------------
-- Tabelas do Ex OneToOne filho-no-pai
-- -----------------------------------------------------
-- Pai
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `senha` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `id_email` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_crbxfkywl10caeq6glx7bx7u0` (`id_email`),
  CONSTRAINT `FK_crbxfkywl10caeq6glx7bx7u0` FOREIGN KEY (`id_email`) REFERENCES `email` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
-- Filho
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;