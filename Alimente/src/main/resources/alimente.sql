-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: alimente
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `alimente`
--

DROP TABLE IF EXISTS `alimente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimente` (
  `nume_aliment` varchar(255) NOT NULL,
  `protein` double DEFAULT NULL,
  `carbs` double DEFAULT NULL,
  `fat` double DEFAULT NULL,
  PRIMARY KEY (`nume_aliment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimente`
--

LOCK TABLES `alimente` WRITE;
/*!40000 ALTER TABLE `alimente` DISABLE KEYS */;
INSERT INTO `alimente` VALUES ('Boiled Chicken Breast',29,0,3),('Boiled Potatoes',1.9,20.1,0.1),('Boiled Rice',2.7,28,1),('Cottage Cheese',13,3,4.5),('Egg white',10.9,0.7,0.2),('Fine Oat Flakes',13,68,6.9),('Kiwi',1.1,14.7,0.2),('Medium Banana',1,30,0),('Medium Egg',5.5,0.3,4.2),('Milk 3,5%',3.2,4.5,3.5),('Omega 3 Softgels',0,0,1),('Orange',0.9,11.8,0.1),('Smooth Peanut Butter',28.9,12.2,48.6),('Soft Wrap Tortilla (Whole Wheat)',4.8,27.2,3.5),('Sugar',0,100,0),('Sweet Potato',1.6,20.1,0.1);
/*!40000 ALTER TABLE `alimente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-05 11:46:34
