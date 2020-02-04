CREATE SCHEMA IF NOT EXISTS `itau` ;
USE `itau` ;

-- -----------------------------------------------------
-- Table `itau`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itau`.`user` (
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL
);

-- -----------------------------------------------------
-- Table `itau`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itau`.`produto` (
  `peso` VARCHAR(45) NOT NULL,
  `comprimento` VARCHAR(45) NOT NULL,
  `altura` VARCHAR(45) NOT NULL,
  `largura` VARCHAR(45) NOT NULL,
  `diametro` VARCHAR(45) NOT NULL,
  `formato` VARCHAR(45) NOT NULL,
  `valor`DOUBLE NOT NULL,
  `cupomDesconto` VARCHAR(45),
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `tipoMidia` VARCHAR(45) NOT NULL);

-- -----------------------------------------------------
-- Table `itau`.`sevico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itau`.`servico` (
  `codigoServico` VARCHAR(45) NOT NULL,
  `servico` VARCHAR(45) NOT NULL
 );
 