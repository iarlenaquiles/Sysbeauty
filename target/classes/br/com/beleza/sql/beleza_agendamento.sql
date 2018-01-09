-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: beleza
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendamento` (
  `agendamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `ag_data_servico` varchar(255) DEFAULT NULL,
  `ag_horario_termino` varchar(255) DEFAULT NULL,
  `ag_local` int(11) DEFAULT NULL,
  `ag_observacoes` varchar(255) DEFAULT NULL,
  `ag_qualificacao` int(11) DEFAULT NULL,
  `ag_status` int(11) DEFAULT NULL,
  `profissional_pro_id` int(11) DEFAULT NULL,
  `usuario_usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`agendamento_id`),
  KEY `FKtoklp0kn063kmka266hpfwy34` (`profissional_pro_id`),
  KEY `FKgjikv50k8jopbgtvat3goy0rb` (`usuario_usuario_id`),
  CONSTRAINT `FKgjikv50k8jopbgtvat3goy0rb` FOREIGN KEY (`usuario_usuario_id`) REFERENCES `usuario` (`usuario_id`),
  CONSTRAINT `FKtoklp0kn063kmka266hpfwy34` FOREIGN KEY (`profissional_pro_id`) REFERENCES `profissional` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` VALUES (1,'2018-12-01 10:00',NULL,0,'ok',5,2,12,25),(2,'2019-09-01 11:00',NULL,1,NULL,NULL,0,1,25);
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-09 14:21:31
