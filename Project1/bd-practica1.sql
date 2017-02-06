-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd-practica1
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `area_specie_jointable`
--

DROP TABLE IF EXISTS `area_specie_jointable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_specie_jointable` (
  `idarea` int(11) NOT NULL,
  `idspecie` int(11) NOT NULL,
  PRIMARY KEY (`idarea`,`idspecie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_specie_jointable`
--

LOCK TABLES `area_specie_jointable` WRITE;
/*!40000 ALTER TABLE `area_specie_jointable` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_specie_jointable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas` (
  `name` varchar(255) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `length` float NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES ('Atlantis','Un mar azul y profundo.',10),('Pantano','Paisaje único y tenebroso.',100),('Sabana','Área amplia similar a la sabana africana.',9.9),('Selva','Peligros y aventuras.',9.8);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parks`
--

DROP TABLE IF EXISTS `parks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parks` (
  `idpark` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpark`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parks`
--

LOCK TABLES `parks` WRITE;
/*!40000 ALTER TABLE `parks` DISABLE KEYS */;
/*!40000 ALTER TABLE `parks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persons` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `job` int(11) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES ('Ana','ana@email.com','ana.jpg',0,'Perez','625859685','916453265'),('Angel','angel@email.com','angel.jpg',2,'Crespo','654656565','916523636'),('Noelia','n@email.com','noelia.jpg',1,'Serrano','654989898','916523636'),('Pao','pao@gmail.com','pao.jpg',3,'Ali','698523147','985236741'),('Pepe','pepe@email.com','pepe.jpg',2,'Garcia','625897413','963258741'),('Rainer','rainer@email.com','ray.jpg',0,'Arencibia','654789321','987456321'),('Silvia','silvi@s.com','silvi.jpg',1,'Garcia','652314789','985632147'),('Sofia','sofia@a.com','sofy.jpg',0,'Serrano','652341789','951234687');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `species` (
  `name` varchar(255) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `scientific_name` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `UK_qth6qeqsd5rvtu100t3uis9n` (`scientific_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES ('Aguila','aguila.jpg','Aquila',0),('Avestruz','avestruz.jpg','Struthio',0),('Bola de nieve','boladenieve.jpg','Agaricus arvensis',2),('Champiñon amarilleante','champiñonamarilleante.jpg','Agaricus xanthodermus',2),('Cocodrilo','cocodrilo.jpg','Crocodylidae',0),('Delfin','delfin.jpg','Delphinidae',0),('Elefante','elefante.jpg','Elephantidae',0),('Gato','gato.jpg','Gatunus',0),('Lirio de agua','liriodeagua.jpg','Nymphaea',1),('Mono','mono.jpg','Primate',0),('Mordisco de rana','mordiscoderana.jpg','Hydrocharis',1),('Oronja','oronja.jpg','Amanita caesarea',2),('Peziza anaranjada','pezizaanaranjada.jpg','Aleuria aurantia',2),('Pino','pino.jpg','Pinus',1),('Roble','roble.jpg','Quercus',1),('Tigre','tigre.jpg','Panthera tigris',0);
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species_areas`
--

DROP TABLE IF EXISTS `species_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `species_areas` (
  `specie_name` varchar(255) NOT NULL,
  `area_name` varchar(255) NOT NULL,
  PRIMARY KEY (`specie_name`,`area_name`),
  KEY `FK_soinrckuinrpf1ftgda4k8tt7` (`area_name`),
  CONSTRAINT `FK_bhkj17x4swxq3ab9anv53lotk` FOREIGN KEY (`specie_name`) REFERENCES `species` (`name`),
  CONSTRAINT `FK_soinrckuinrpf1ftgda4k8tt7` FOREIGN KEY (`area_name`) REFERENCES `areas` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species_areas`
--

LOCK TABLES `species_areas` WRITE;
/*!40000 ALTER TABLE `species_areas` DISABLE KEYS */;
INSERT INTO `species_areas` VALUES ('Delfin','Atlantis'),('Lirio de agua','Atlantis'),('Aguila','Pantano'),('Bola de nieve','Pantano'),('Cocodrilo','Pantano'),('Lirio de agua','Pantano'),('Mordisco de rana','Pantano'),('Oronja','Pantano'),('Bola de nieve','Sabana'),('Elefante','Sabana'),('Gato','Sabana'),('Peziza anaranjada','Sabana'),('Pino','Sabana'),('Tigre','Sabana'),('Avestruz','Selva'),('Champiñon amarilleante','Selva'),('Mono','Selva'),('Peziza anaranjada','Selva'),('Pino','Selva'),('Roble','Selva');
/*!40000 ALTER TABLE `species_areas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-31 13:05:31
