CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `project`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.6.35

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
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `CAT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CAT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (2,'Laptops'),(3,'CellPhones'),(4,'Tablet');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item` (
  `ITEM_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ITEM_PRICE` double DEFAULT NULL,
  `PRODUCT_NAME` varchar(255) DEFAULT NULL,
  `PRODUCT_PRICE` double DEFAULT NULL,
  `ITEM_QUANTITY` bigint(20) DEFAULT NULL,
  `ORDERS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `FK42aqils8fuv7rm66sp5gahm0n` (`ORDERS_ID`),
  CONSTRAINT `FK42aqils8fuv7rm66sp5gahm0n` FOREIGN KEY (`ORDERS_ID`) REFERENCES `Orders` (`ORDERS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
INSERT INTO `Item` VALUES (2,100000,'Macbook',50000,2,2),(3,100000,'Macbook',50000,2,2),(5,60000,'Toshiba',20000,3,4),(6,800000,'iMac',80000,10,4),(7,200000,'Macbook',50000,4,5),(8,600000,'Toshiba',20000,30,6),(9,8000000,'iMac',80000,100,6),(10,100000,'Macbook',50000,2,7);
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `ORDERS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORDERS_COOKIE` varchar(255) DEFAULT NULL,
  `ORDERS_STATUS` varchar(255) DEFAULT NULL,
  `ORDERS_PRICE` double DEFAULT NULL,
  PRIMARY KEY (`ORDERS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (2,'61CF912A543DAB566F81AAF2E8391992','IN_PROGRESS',200000),(4,'695711DE2CFF314398C88D0A58D462B0','NEW',860000),(5,'6AA704D33514AC0C08FA79C6E7BC50BF','NEW',200000),(6,'0719896ADD84CEBBF7B62947276D67C5','NEW',8600000),(7,'C957E97A17CDB999F7B36279E502C095','NEW',100000);
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Owner`
--

DROP TABLE IF EXISTS `Owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Owner` (
  `OWNER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `OWNER_EMAIL` varchar(255) DEFAULT NULL,
  `OWNER_NAME` varchar(255) DEFAULT NULL,
  `OWNER_PHONE` varchar(255) DEFAULT NULL,
  `ORDER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`OWNER_ID`),
  KEY `FKqf76h8kpvr5j7f1d66ueby2ix` (`ORDER_ID`),
  CONSTRAINT `FKqf76h8kpvr5j7f1d66ueby2ix` FOREIGN KEY (`ORDER_ID`) REFERENCES `Orders` (`ORDERS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Owner`
--

LOCK TABLES `Owner` WRITE;
/*!40000 ALTER TABLE `Owner` DISABLE KEYS */;
INSERT INTO `Owner` VALUES (2,'alex1999@mail.com','Alex','123235324',NULL),(4,'mouse777@mail.com','Jonson','42342342',NULL),(5,'nikitos9@mail.com','Nikita','132342234',NULL),(6,'fox3443@mail.com','Lisa','4234234234',NULL),(7,'alex1999@mail.com','Alex','123235232324',NULL);
/*!40000 ALTER TABLE `Owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `PRODUCT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(255) DEFAULT NULL,
  `PRODUCT_PRICE` double DEFAULT NULL,
  `CAT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `FKoi6rn1awbhef2wytpkjgw7g51` (`CAT_ID`),
  CONSTRAINT `FKoi6rn1awbhef2wytpkjgw7g51` FOREIGN KEY (`CAT_ID`) REFERENCES `Category` (`CAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (4,'Macbook',50000,2),(5,'Toshiba',20000,2),(6,'iMac',80000,2),(7,'iPhone7',10000,3),(8,'iPhoneX',80000,3),(9,'iPhone8',60000,3),(10,'iPad2',10000,4),(11,'iPad_Mini',30000,4),(12,'iPad_Air',50000,4),(13,'iPad_Pro',100000,4);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `USER_ID` bigint(20) NOT NULL,
  `ADMIN` char(3) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (1,'no','Mickey','Mouse','$2a$10$kSqU.ek5pDRMMK21tHJlceS1xOc9Kna4F0DD2ZwQH/LAzH0ML0p6.','mickey'),(2,'no','Minnie','Mouse','$2a$10$MnHcLn.XdLx.iMntXsmdgeO1B4wAW1E5GOy/VrLUmr4aAzabXnGFq','minnie'),(3,'no','Donald','Duck','$2a$10$0UCBI04PCXiK0pF/9kI7.uAXiHNQeeHdkv9NhA1/xgmRpfd4qxRMG','donald'),(4,'no','Daisy','Duck','$2a$10$aNoR88g5b5TzSKb7mQ1nQOkyEwfHVQOxHY0HX7irI8qWINvLDWRyS','daisy'),(5,'no','Clarabelle','Cow','$2a$10$cuTJd2ayEwXfsPdoF5/hde6gzsPx/gEiv8LZsjPN9VPoN5XVR8cKW','clarabelle'),(6,'yes','Super','Admin','$2a$10$JQOfG5Tqnf97SbGcKsalz.XpDQbXi1APOf2SHPVW27bWNioi9nI8y','admin');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-05 14:39:53
