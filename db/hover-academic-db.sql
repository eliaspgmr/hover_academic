-- MySQL Script for hover-academic-system
-- Sun Sep  9 23:43:13 2018
-- Model: New Model    Version: 1.0 Beta
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema hover_academic
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `hover_academic` DEFAULT CHARACTER SET utf8 ;
USE `hover_academic` ;

-- -----------------------------------------------------
-- Table `hover_academic`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `login` VARCHAR(45) NOT NULL UNIQUE,
  `senha` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`responsavel` (
  `id_responsavel` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `rg` VARCHAR(20) NOT NULL UNIQUE,
  `cpf` VARCHAR(11) NOT NULL UNIQUE,
  PRIMARY KEY (`id_responsavel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`alunos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`alunos` (
  `id_aluno` INT NOT NULL AUTO_INCREMENT,
  `usuarios_id_usuario` INT NOT NULL,
  `responsavel_id_responsavel` INT NULL,
  `nome` VARCHAR(70) NOT NULL,
  `data_nascimento` DATE NULL,
  `rg` VARCHAR(20) NULL UNIQUE,
  `cpf` VARCHAR(11) NULL UNIQUE,
  `sexo` CHAR(1) NULL,
  `obs` VARCHAR(255) NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_aluno`),
  FOREIGN KEY (`usuarios_id_usuario`)
  REFERENCES `hover_academic`.`usuarios` (`id_usuario`),
  FOREIGN KEY (`responsavel_id_responsavel`)
  REFERENCES `hover_academic`.`responsavel` (`id_responsavel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`financeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`financeiro` (
  `id_financeiro` INT NOT NULL AUTO_INCREMENT,
  `alunos_id_aluno` INT NOT NULL,
  `data_inicio` DATE NOT NULL,
  `vencimento` DATE NOT NULL,
  `num_parcelas` INT NOT NULL,
  `valor` DOUBLE(6,2) NOT NULL,
  `taxa_juros` DOUBLE(4,2) NOT NULL,
  `multa` DOUBLE(5,2) NOT NULL,
  `matricula` DOUBLE(6,2) NOT NULL,
  PRIMARY KEY (`id_financeiro`),
  FOREIGN KEY (`alunos_id_aluno`)
  REFERENCES `hover_academic`.`alunos` (`id_aluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`cancelamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`cancelamento` (
  `financeiro_id_financeiro` INT NOT NULL,
  `data` DATE NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`financeiro_id_financeiro`),
    FOREIGN KEY (`financeiro_id_financeiro`)
    REFERENCES `hover_academic`.`financeiro` (`id_financeiro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`parcelas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`parcelas` (
  `financeiro_id_financeiro` INT NOT NULL,
  `numero` INT NOT NULL,
  `valor` DOUBLE(5,2) NOT NULL,
  `juros` DOUBLE(5,2) NULL,
  `multa` DOUBLE(5,2) NULL,
  `data_pagamento` DATE NOT NULL,
  PRIMARY KEY (`financeiro_id_financeiro`, `numero`),
    FOREIGN KEY (`financeiro_id_financeiro`)
    REFERENCES `hover_academic`.`financeiro` (`id_financeiro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`curos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`curos` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `nivel` VARCHAR(15) NOT NULL,
  `duracao` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`id_curso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`turma` (
  `id_turma` INT NOT NULL AUTO_INCREMENT,
  `usuarios_id_usuario` INT NOT NULL,
  `curos_id_curso` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL UNIQUE,
  `dia` VARCHAR(15) NOT NULL,
  `horario` TIME NOT NULL,
  `data_inicio` DATE NOT NULL,
  PRIMARY KEY (`id_turma`),
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `hover_academic`.`usuarios` (`id_usuario`),
    FOREIGN KEY (`curos_id_curso`)
    REFERENCES `hover_academic`.`curos` (`id_curso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`alunos_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`alunos_turma` (
  `id_aluno_turma` INT NOT NULL AUTO_INCREMENT,
  `turma_id_turma` INT NOT NULL,
  `alunos_id_aluno` INT NOT NULL,
  PRIMARY KEY (`id_aluno_turma`),
    FOREIGN KEY (`turma_id_turma`)
    REFERENCES `hover_academic`.`turma` (`id_turma`),
    FOREIGN KEY (`alunos_id_aluno`)
    REFERENCES `hover_academic`.`alunos` (`id_aluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`boletim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`boletim` (
  `id_boletim` INT NOT NULL AUTO_INCREMENT,
  `alunos_turma_id_aluno_turma` INT NOT NULL,
  `bo_av1` DOUBLE(4,2) NULL,
  `bo_av2` DOUBLE(4,2) NULL,
  `bo_av3` DOUBLE(4,2) NULL,
  `bo_av4` DOUBLE(4,2) NULL,
  PRIMARY KEY (`id_boletim`),
    FOREIGN KEY (`alunos_turma_id_aluno_turma`)
    REFERENCES `hover_academic`.`alunos_turma` (`id_aluno_turma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`frequencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`frequencia` (
  `id_frequencia` INT NOT NULL AUTO_INCREMENT,
  `alunos_turma_id_aluno_turma` INT NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id_frequencia`),
    FOREIGN KEY (`alunos_turma_id_aluno_turma`)
    REFERENCES `hover_academic`.`alunos_turma` (`id_aluno_turma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`cotatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`cotatos` (
  `id_contato` INT NOT NULL AUTO_INCREMENT,
  `alunos_id_aluno` INT NOT NULL,
  `telefone` INT(11) NOT NULL,
  `celular` INT(11) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_contato`),
    FOREIGN KEY (`alunos_id_aluno`)
    REFERENCES `hover_academic`.`alunos` (`id_aluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hover_academic`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hover_academic`.`endereco` (
  `id_endereco` INT NOT NULL AUTO_INCREMENT,
  `alunos_id_aluno` INT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT(6) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NULL,
  `cep` INT(8) NULL,
  PRIMARY KEY (`id_endereco`),
    FOREIGN KEY (`alunos_id_aluno`)
    REFERENCES `hover_academic`.`alunos` (`id_aluno`))
ENGINE = InnoDB;

