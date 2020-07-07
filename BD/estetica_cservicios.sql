-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: estetica
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cservicios`
--

DROP TABLE IF EXISTS `cservicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cservicios` (
  `id_serv` int(11) NOT NULL AUTO_INCREMENT,
  `nom_serv` varchar(150) NOT NULL,
  `pre_serv` double(8,2) NOT NULL,
  `dur_serv` int(3) NOT NULL,
  PRIMARY KEY (`id_serv`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cservicios`
--

LOCK TABLES `cservicios` WRITE;
/*!40000 ALTER TABLE `cservicios` DISABLE KEYS */;
INSERT INTO `cservicios` VALUES (1,'Premium Makeup de día',1400.00,60),(2,'Premium Makeup con aerógrafo',1650.00,70),(3,'Premium Makeup de noche',1750.00,80),(4,'Esmalte natural en manos',340.00,20),(5,'Esmalte natural en pies',350.00,20),(6,'Gel en manos',460.00,40),(7,'Gel en pies',480.00,45),(8,'Manicure para caballero',500.00,30),(9,'Manicure',500.00,45),(10,'Pedicure para caballero',520.00,65),(11,'Pedicure',520.00,65),(12,'Gel en manos con decoración',580.00,60),(13,'Acrílico y gel en manos',580.00,60),(14,'Manicure gel',580.00,55),(15,'Pedicure gel',620.00,75),(16,'Gel en manos y pies',650.00,70),(17,'Manicure y pedicure para caballero',720.00,100),(18,'Manicure y pedicure',720.00,120),(19,'Manicure y pedicure gel',880.00,140),(20,'Estilizado de extensiones',140.00,35),(21,'Aplicación de pestañas',210.00,20),(22,'Alaciado con plancha',490.00,50),(23,'Moldeado con secadora',490.00,50),(24,'Ondas surfer',490.00,60),(25,'Ondas vintage',490.00,60),(26,'Peinado sencillo',530.00,45),(27,'Peinado recogido',640.00,60),(28,'Maquillaje de día sin pestañas',800.00,50),(29,'Maquillaje de día con pestañas',920.00,60),(30,'Alto peinado',930.00,60),(31,'Maquillaje de noche sin pestañas',990.00,50),(32,'Maquillaje de noche con pestañas',1160.00,60),(33,'Estilizado de extensiones',140.00,35),(34,'Paquete maquillaje de día y Ondas',1150.00,120),(35,'Paquete maquillaje de día y peinado recogido',1350.00,120),(36,'Paquete maquillaje de noche y ondas',1380.00,130),(37,'Paquete maquillaje de noche y peinado',1600.00,130),(38,'Corte individual',490.00,30),(39,'Paquete 2 cortes',890.00,50),(40,'Paquete 3 cortes',1090.00,70),(41,'Paquete 4 cortes',1190.00,90),(42,'Tratamiento de hidratación con Olaplex',390.00,30);
/*!40000 ALTER TABLE `cservicios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-06 23:22:32
