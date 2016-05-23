-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: db_pfc_adsep
-- ------------------------------------------------------
-- Server version	5.5.0-m2-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_categoria` varchar(5) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacto_estabelecimento`
--

DROP TABLE IF EXISTS `contacto_estabelecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacto_estabelecimento` (
  `id_contacto_estabelecimento` varchar(5) NOT NULL,
  `estabelecimento_id` varchar(5) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `telefone_movel` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_contacto_estabelecimento`),
  KEY `fk_contacto_estabelecimento_idx` (`estabelecimento_id`),
  CONSTRAINT `fk_contacto_estabelecimento` FOREIGN KEY (`estabelecimento_id`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto_estabelecimento`
--

LOCK TABLES `contacto_estabelecimento` WRITE;
/*!40000 ALTER TABLE `contacto_estabelecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacto_estabelecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estabelecimento`
--

DROP TABLE IF EXISTS `estabelecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estabelecimento` (
  `id_estabelecimento` varchar(5) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `instituicao_id` varchar(5) DEFAULT NULL,
  `endecero` varchar(200) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `contacto_estabelecimento_id` varchar(5) DEFAULT NULL,
  `horario_abertura` varchar(7) DEFAULT NULL,
  `horario_encerramento` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id_estabelecimento`),
  KEY `fk_estabelecimento_instituicao_idx` (`instituicao_id`),
  KEY `fk_contacto_estabelecimento_id_idx` (`contacto_estabelecimento_id`),
  CONSTRAINT `fk_contacto_estabelecimento_id` FOREIGN KEY (`contacto_estabelecimento_id`) REFERENCES `contacto_estabelecimento` (`id_contacto_estabelecimento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estabelecimento_instituicao` FOREIGN KEY (`instituicao_id`) REFERENCES `instituicao` (`id_instituicao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estabelecimento`
--

LOCK TABLES `estabelecimento` WRITE;
/*!40000 ALTER TABLE `estabelecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `estabelecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estabelecimento_servico`
--

DROP TABLE IF EXISTS `estabelecimento_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estabelecimento_servico` (
  `id_estabelecimento_servico` varchar(5) NOT NULL,
  `estabelecimento_id` varchar(5) DEFAULT NULL,
  `servico_id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_estabelecimento_servico`),
  KEY `fk_es_estabelecimento_idx` (`estabelecimento_id`),
  KEY `fk_es_servico_idx` (`servico_id`),
  CONSTRAINT `fk_es_estabelecimento` FOREIGN KEY (`estabelecimento_id`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_es_servico` FOREIGN KEY (`servico_id`) REFERENCES `servico` (`id_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estabelecimento_servico`
--

LOCK TABLES `estabelecimento_servico` WRITE;
/*!40000 ALTER TABLE `estabelecimento_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `estabelecimento_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituicao` (
  `id_instituicao` varchar(5) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `categoria_id` varchar(5) DEFAULT NULL,
  `logo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_instituicao`),
  KEY `fk_categoria_id_idx` (`categoria_id`),
  CONSTRAINT `fk_categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituicao`
--

LOCK TABLES `instituicao` WRITE;
/*!40000 ALTER TABLE `instituicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `instituicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituicao_servico`
--

DROP TABLE IF EXISTS `instituicao_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituicao_servico` (
  `id_instituicao_servico` varchar(5) NOT NULL,
  `instituicao_id` varchar(5) NOT NULL,
  `servico_id` varchar(5) NOT NULL,
  PRIMARY KEY (`id_instituicao_servico`),
  KEY `f_instituicao_id_idx` (`instituicao_id`),
  KEY `f_servico_id_idx` (`servico_id`),
  CONSTRAINT `fk_instituicao_servico_id` FOREIGN KEY (`instituicao_id`) REFERENCES `instituicao` (`id_instituicao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servico_instituicao_id` FOREIGN KEY (`servico_id`) REFERENCES `servico` (`id_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituicao_servico`
--

LOCK TABLES `instituicao_servico` WRITE;
/*!40000 ALTER TABLE `instituicao_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `instituicao_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito`
--

DROP TABLE IF EXISTS `requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requisito` (
  `id_requisito` varchar(5) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_requisito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito`
--

LOCK TABLES `requisito` WRITE;
/*!40000 ALTER TABLE `requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `id_servico` varchar(5) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `categoria_id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_servico`),
  KEY `fk_servico_id_idx` (`categoria_id`),
  CONSTRAINT `fk_servico_id` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico_requisito`
--

DROP TABLE IF EXISTS `servico_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico_requisito` (
  `id_servico_requisito` int(11) NOT NULL,
  `servico_id` varchar(5) DEFAULT NULL,
  `requisito_id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_servico_requisito`),
  KEY `fk_servico_requisito_id_idx` (`servico_id`),
  KEY `fk_requisito_servico_id_idx` (`requisito_id`),
  CONSTRAINT `fk_servico_requisito_id` FOREIGN KEY (`servico_id`) REFERENCES `servico` (`id_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_requisito_servico_id` FOREIGN KEY (`requisito_id`) REFERENCES `requisito` (`id_requisito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico_requisito`
--

LOCK TABLES `servico_requisito` WRITE;
/*!40000 ALTER TABLE `servico_requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico_requisito` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16 16:26:45
