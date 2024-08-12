/*!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.6.18-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cuentas
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `persona_id` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `edad` int NOT NULL,
  `identificacion` varchar(15) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cliente_idx` (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'1231','Nombre Prueba','M',12,'12311111','dur','11111111','adadada',1),(2,'asd12','Paul Ruales','M',14,'1233331157','monjas alma lojana','2939111','ejemploeventual',0),(3,'b8cd109e970035eab867c32622b89598','Christian Ruales','M',14,'1233331157','monjas alma lojana','2939111','ejemploeventual',0),(5,'554eff2203563216903ba3062a2b5260','Juan Rosales','M',14,'1786223567','Calle J y Avenida Los santos','02260829','bfac8ee40f13357680192291edeed8d5',0),(7,'f202877b5cf8327984678270b80f3c50','Romina Caisaguano','F',14,'12312311111','Mariano Campo s2-445','02241893','644de5129b34335599711dd15950d55e',1),(9,'5dbac72886183a5fb4bded4bbdd751f9','Juan Ramirez','M',14,'1786223567','Calle J y Avenida Los santos','02260829','f41eec174664324386998a0530635609',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_id` int NOT NULL,
  `numero_cuenta` varchar(25) NOT NULL,
  `tipo_cuenta` varchar(25) NOT NULL,
  `saldo_inicial` decimal(16,2) NOT NULL,
  `saldo_actual` decimal(16,2) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_cuenta_fk` (`cliente_id`),
  CONSTRAINT `cliente_cuenta_fk` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (3,1,'11100011111','DEBTO',1344.12,1382.09,0),(5,1,'123111','DEBTO',11111.12,0.00,1),(6,1,'13171311218','AHORRO',11111.12,11498.67,1),(7,3,'16131813410','AHORRO',11111.12,0.00,1),(8,2,'9253119','CORRIENTE',11111.12,0.00,1),(9,3,'14817171111','AHORROS',11111.12,0.00,1),(10,1,'1419148117','DEBTO',11111.12,11111.12,1),(11,1,'1871312154','AHORROS',3999.09,3999.09,1),(12,5,'1811117115','AHORROS',12222.09,3999.09,1),(14,3,'187131643','AHORROS',9901.12,9901.12,1);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cuenta_id` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `tipo_movimiento` varchar(100) DEFAULT NULL,
  `valor` decimal(16,2) NOT NULL,
  `saldo` decimal(16,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cuenta_movimiento_fk` (`cuenta_id`),
  CONSTRAINT `cuenta_movimiento_fk` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento`
--

LOCK TABLES `movimiento` WRITE;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` VALUES (1,3,'2024-08-11','RETIRO',12.12,1231.10),(3,6,'2024-08-11','RETIRO',12.45,11098.67),(4,6,'2024-08-11','DEPOSITO',200.00,11298.67),(5,6,'2024-08-11','DEPOSITO',200.00,11498.67),(7,3,'2024-08-11','DEPOSITO',150.99,1382.09),(8,3,'2024-08-11','DEPOSITO',150.99,1533.08),(9,6,'2024-08-11','DEPOSITO',200.00,11698.67);
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-11 22:37:33
