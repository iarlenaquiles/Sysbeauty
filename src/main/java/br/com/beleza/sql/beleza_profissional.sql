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
-- Table structure for table `profissional`
--

DROP TABLE IF EXISTS `profissional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profissional` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_active` bit(1) DEFAULT NULL,
  `pro_celular` varchar(255) DEFAULT NULL,
  `pro_cep` varchar(255) DEFAULT NULL,
  `pro_cidade` varchar(255) DEFAULT NULL,
  `pro_confsenha` varchar(255) DEFAULT NULL,
  `pro_cpf` varchar(255) DEFAULT NULL,
  `pro_data_setting` datetime DEFAULT NULL,
  `pro_descobri` varchar(255) DEFAULT NULL,
  `pro_email` varchar(255) DEFAULT NULL,
  `pro_endereco` varchar(255) DEFAULT NULL,
  `pro_estado` varchar(255) DEFAULT NULL,
  `pro_nome` varchar(255) NOT NULL,
  `pro_num` int(11) DEFAULT NULL,
  `pro_senha` varchar(255) DEFAULT NULL,
  `pro_telefone` varchar(255) DEFAULT NULL,
  `login_login_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FKpvdi5h5q1x3w1nalgecorwbn0` (`login_login_id`),
  CONSTRAINT `FKpvdi5h5q1x3w1nalgecorwbn0` FOREIGN KEY (`login_login_id`) REFERENCES `login` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profissional`
--

LOCK TABLES `profissional` WRITE;
/*!40000 ALTER TABLE `profissional` DISABLE KEYS */;
INSERT INTO `profissional` VALUES (1,'','888','74850330','bh','123','557',NULL,NULL,'pro@email.com',NULL,NULL,'pro',NULL,'123',NULL,11),(2,'','777','74850510',NULL,NULL,NULL,NULL,NULL,NULL,'rua',NULL,'Jonatas',1,NULL,NULL,8),(7,'',NULL,'123','123',NULL,NULL,NULL,NULL,'1452@email.com','123',NULL,'outro@email.com',NULL,'123',NULL,17),(8,'',NULL,'74000000','Goiania',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Teste',NULL,NULL,NULL,19),(9,'',NULL,'74000000','Goiania',NULL,NULL,NULL,NULL,'email@email','a',NULL,'Teste',NULL,'1',NULL,20),(10,'',NULL,'74000000','Goiania',NULL,NULL,NULL,NULL,'email@email','a',NULL,'Teste',NULL,'1',NULL,21),(11,'',NULL,'74000000','Goiania',NULL,NULL,NULL,NULL,'email@email','a',NULL,'Teste',NULL,'1',NULL,22),(12,'',NULL,'123','123',NULL,NULL,NULL,NULL,'je@email.com','123',NULL,'JE',NULL,'123',NULL,23),(13,'','89','788','888','8','7899',NULL,'89','8989','98',NULL,'TESTEPRO',89,'89','99',24);
/*!40000 ALTER TABLE `profissional` ENABLE KEYS */;
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
