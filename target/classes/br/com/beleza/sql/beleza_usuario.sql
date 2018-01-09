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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_celular` varchar(255) DEFAULT NULL,
  `usuario_cep` varchar(255) DEFAULT NULL,
  `usuario_cidade` varchar(255) DEFAULT NULL,
  `usuario_confsenha` varchar(255) DEFAULT NULL,
  `usuario_cpf` varchar(255) DEFAULT NULL,
  `usuario_data_setting` datetime DEFAULT NULL,
  `usuario_descobri` varchar(255) DEFAULT NULL,
  `usuario_email` varchar(255) DEFAULT NULL,
  `usuario_endereco` varchar(255) DEFAULT NULL,
  `usuario_estado` varchar(255) DEFAULT NULL,
  `usuario_nome` varchar(255) NOT NULL,
  `usuario_num` int(11) DEFAULT NULL,
  `usuario_senha` varchar(255) DEFAULT NULL,
  `usuario_telefone` varchar(255) DEFAULT NULL,
  `usuario_active` bit(1) DEFAULT NULL,
  `login_login_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`usuario_id`),
  KEY `FK76kwl2jonkr80gk5a12t3omh7` (`login_login_id`),
  CONSTRAINT `FK76kwl2jonkr80gk5a12t3omh7` FOREIGN KEY (`login_login_id`) REFERENCES `login` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (25,'0000','74850330','Goianai','123','55769292253',NULL,'0000','jonatas@email.com','Rua Almirante barroso','GO','Jonatas Edward ',0,'123','0000','',3),(26,NULL,'74850510','Goiania',NULL,'74850410',NULL,NULL,'teste@email.com','Endereço',NULL,'Teste',NULL,'123',NULL,'',4),(28,NULL,'74850410','BH',NULL,'74850510',NULL,NULL,'novo@email.com','Endereco',NULL,'Novo',NULL,'123',NULL,'',6),(29,NULL,'74850290','Bh',NULL,NULL,NULL,NULL,'tu@email.com','Endereço',NULL,'Tu',NULL,'123',NULL,'',7),(30,NULL,'74000000','Goiania',NULL,NULL,NULL,NULL,'email@email','r 1',NULL,'Teste',NULL,'123',NULL,'',18);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
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
