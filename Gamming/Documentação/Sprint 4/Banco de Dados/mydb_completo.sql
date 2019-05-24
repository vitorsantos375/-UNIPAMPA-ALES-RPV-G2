-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `mydb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mydb`;

--
-- Table structure for table `encaminhamento`
--

DROP TABLE IF EXISTS `encaminhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encaminhamento` (
  `id_encaminhamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_TipoEncaminhamento` int(11) NOT NULL,
  `segundo_Turno` tinyint(1) NOT NULL,
  `item_pauta_id_item_pauta` int(11) NOT NULL,
  `id_reuniao` int(11) NOT NULL,
  PRIMARY KEY (`id_encaminhamento`),
  KEY `idTipoEncaminhamento` (`id_TipoEncaminhamento`),
  KEY `fk_encaminhamento_item_pauta1_idx` (`item_pauta_id_item_pauta`),
  CONSTRAINT `fk_encaminhamento_customizado_item_pauta` FOREIGN KEY (`id_TipoEncaminhamento`) REFERENCES `tipo_encaminhamento` (`id_tipo_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_encaminhamento_item_pauta1` FOREIGN KEY (`item_pauta_id_item_pauta`) REFERENCES `item_pauta` (`id_item_pauta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encaminhamento`
--

LOCK TABLES `encaminhamento` WRITE;
/*!40000 ALTER TABLE `encaminhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `encaminhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pauta`
--

DROP TABLE IF EXISTS `item_pauta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_pauta` (
  `id_item_pauta` int(11) NOT NULL AUTO_INCREMENT,
  `desc_item_pauta` varchar(200) NOT NULL,
  `relator_id_relator` int(11) NOT NULL,
  `item_pauta_votada` tinyint(1) NOT NULL,
  `id_reuniao` int(11) NOT NULL,
  PRIMARY KEY (`id_item_pauta`),
  KEY `fk_item_pauta_relator1_idx` (`relator_id_relator`),
  KEY `id_reuniao` (`id_reuniao`),
  CONSTRAINT `fk_item_pauta_relator1` FOREIGN KEY (`relator_id_relator`) REFERENCES `relator` (`id_relator`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_pauta_ibfk_1` FOREIGN KEY (`id_reuniao`) REFERENCES `reuniao` (`id_reuniao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pauta`
--

LOCK TABLES `item_pauta` WRITE;
/*!40000 ALTER TABLE `item_pauta` DISABLE KEYS */;
INSERT INTO `item_pauta` VALUES (1,'Criação de disciplinas do PPEng',1,0,1),(2,'Perfil docente para concurso em Engenharia de Software',2,0,2),(3,'Alteração de Situação de CCCGs do PPC do Curso de Engenharia Civil',3,0,1),(4,'Alterações nas referências da componente Al0105 - Microcontroladores',4,0,2);
/*!40000 ALTER TABLE `item_pauta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcao_voto`
--

DROP TABLE IF EXISTS `opcao_voto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcao_voto` (
  `id_opcao_voto` int(11) NOT NULL AUTO_INCREMENT,
  `id_encaminhamento` int(11) NOT NULL,
  `desc_opcao_voto` varchar(200) NOT NULL,
  PRIMARY KEY (`id_opcao_voto`),
  KEY `fk_encaminhamento_opcao_voto_encaminhamento1_idx` (`id_encaminhamento`),
  CONSTRAINT `fk_encaminhamento_opcao_voto_encaminhamento1` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcao_voto`
--

LOCK TABLES `opcao_voto` WRITE;
/*!40000 ALTER TABLE `opcao_voto` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcao_voto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relator`
--

DROP TABLE IF EXISTS `relator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relator` (
  `id_relator` int(11) NOT NULL AUTO_INCREMENT,
  `nome_relator` varchar(200) NOT NULL,
  PRIMARY KEY (`id_relator`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relator`
--

LOCK TABLES `relator` WRITE;
/*!40000 ALTER TABLE `relator` DISABLE KEYS */;
INSERT INTO `relator` VALUES (1,'Adriana Gindri Salbego'),(2,'Felipe Eduardo Luedke'),(3,'Hélvio Rech'),(4,'Luis Hamilton Tarrago Pereira Júnior');
/*!40000 ALTER TABLE `relator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reuniao`
--

DROP TABLE IF EXISTS `reuniao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reuniao` (
  `id_reuniao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_reuniao` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `reuniao_aberta` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_reuniao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reuniao`
--

LOCK TABLES `reuniao` WRITE;
/*!40000 ALTER TABLE `reuniao` DISABLE KEYS */;
INSERT INTO `reuniao` VALUES (1,'23ª Reunião Extraordinária do CONSUNI – Bagé',0),(2,'22ª Reunião Extraordinária do CONSUNI – Bagé',0);
/*!40000 ALTER TABLE `reuniao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_encaminhamento`
--

DROP TABLE IF EXISTS `tipo_encaminhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_encaminhamento` (
  `id_tipo_encaminhamento` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo_encaminhamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_encaminhamento`
--

LOCK TABLES `tipo_encaminhamento` WRITE;
/*!40000 ALTER TABLE `tipo_encaminhamento` DISABLE KEYS */;
INSERT INTO `tipo_encaminhamento` VALUES (1,'Simples'),(2,'Customizado');
/*!40000 ALTER TABLE `tipo_encaminhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_reuniao`
--

DROP TABLE IF EXISTS `user_reuniao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_reuniao` (
  `id_user_reuniao` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_reuniao` int(11) NOT NULL,
  `secretario` tinyint(1) NOT NULL,
  `moderador` tinyint(1) NOT NULL,
  `membro` tinyint(1) NOT NULL,
  `registrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_user_reuniao`),
  KEY `id_membro` (`id_user`),
  KEY `id_reuniao` (`id_reuniao`),
  CONSTRAINT `reuniao_membro_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`id_user`),
  CONSTRAINT `reuniao_membro_ibfk_3` FOREIGN KEY (`id_reuniao`) REFERENCES `reuniao` (`id_reuniao`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_reuniao`
--

LOCK TABLES `user_reuniao` WRITE;
/*!40000 ALTER TABLE `user_reuniao` DISABLE KEYS */;
INSERT INTO `user_reuniao` VALUES (1,1,1,1,1,1,0),(2,4,2,1,1,1,0),(3,1,2,0,0,1,0),(4,4,1,0,0,1,0),(5,2,1,0,0,1,0),(6,2,2,0,0,1,0),(7,3,1,0,0,1,0),(8,3,2,0,0,1,0);
/*!40000 ALTER TABLE `user_reuniao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nome_user` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Guilherme Bolfe'),(2,'Filipe Garcia'),(3,'Victor Ribeiro'),(4,'Giliardi Schmidt');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voto`
--

DROP TABLE IF EXISTS `voto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voto` (
  `id_voto` int(11) NOT NULL AUTO_INCREMENT,
  `id_membro` int(11) NOT NULL,
  `id_opcao_voto` int(11) NOT NULL,
  `id_encaminhamento` int(11) NOT NULL,
  PRIMARY KEY (`id_voto`),
  KEY `id_opcao_voto` (`id_opcao_voto`),
  KEY `id_membro` (`id_membro`),
  KEY `id_encaminhamento` (`id_encaminhamento`),
  CONSTRAINT `voto_ibfk_1` FOREIGN KEY (`id_opcao_voto`) REFERENCES `opcao_voto` (`id_opcao_voto`),
  CONSTRAINT `voto_ibfk_2` FOREIGN KEY (`id_membro`) REFERENCES `usuario` (`id_user`),
  CONSTRAINT `voto_ibfk_3` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voto`
--

LOCK TABLES `voto` WRITE;
/*!40000 ALTER TABLE `voto` DISABLE KEYS */;
/*!40000 ALTER TABLE `voto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-29  8:26:21
