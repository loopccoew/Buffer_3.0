-- MySQL dump 10.13  Distrib 5.7.20, for Win32 (AMD64)
--
-- Host: localhost    Database: OrganDonation
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `areaCode` int(11) NOT NULL,
  `areaName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`areaCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (101,'Katraj'),(102,'Hadapsar'),(103,'Kondhwa'),(104,'Kothrud'),(105,'Swargate');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `citycode` int(11) NOT NULL,
  `cityName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`citycode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (400,'Mumbai'),(401,'Pune'),(402,'Nagpur'),(403,'Kolhapur'),(404,'Nashik'),(405,'Dhule');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor`
--

DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donor` (
  `donorUserID` int(11) NOT NULL,
  `donorName` varchar(10) DEFAULT NULL,
  `donorBloodGroup` varchar(3) DEFAULT NULL,
  `birthDate` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `organName` varchar(30) DEFAULT NULL,
  `donorAddress` varchar(30) DEFAULT NULL,
  `mobileNo` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`donorUserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `hospitalCode` int(11) NOT NULL,
  `hospitalName` varchar(20) DEFAULT NULL,
  `areaCode` int(11) DEFAULT NULL,
  `cityCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`hospitalCode`),
  KEY `areaCode` (`areaCode`),
  KEY `cityCode` (`cityCode`),
  CONSTRAINT `hospital_ibfk_1` FOREIGN KEY (`areaCode`) REFERENCES `area` (`areaCode`),
  CONSTRAINT `hospital_ibfk_2` FOREIGN KEY (`cityCode`) REFERENCES `city` (`citycode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (9001,'Sahyadri Hospital',103,401),(9002,'Kaveri Hospital',103,401),(9003,'Nawale Hospital',101,401),(9004,'Suyog Hospital',102,402),(9005,'Sasoon Hospital',104,401),(9006,'Poona Hospital',104,401),(9007,'City Hospital',104,401);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_edges`
--

DROP TABLE IF EXISTS `hospital_edges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital_edges` (
  `hospital1_code` int(11) NOT NULL,
  `hospital2_code` int(11) NOT NULL,
  `distance` int(11) DEFAULT NULL,
  PRIMARY KEY (`hospital1_code`,`hospital2_code`),
  KEY `hospital2_code` (`hospital2_code`),
  CONSTRAINT `hospital_edges_ibfk_1` FOREIGN KEY (`hospital1_code`) REFERENCES `hospital` (`hospitalCode`),
  CONSTRAINT `hospital_edges_ibfk_2` FOREIGN KEY (`hospital2_code`) REFERENCES `hospital` (`hospitalCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_edges`
--

LOCK TABLES `hospital_edges` WRITE;
/*!40000 ALTER TABLE `hospital_edges` DISABLE KEYS */;
INSERT INTO `hospital_edges` VALUES (9001,9002,4),(9001,9003,12),(9001,9005,18),(9002,9003,5),(9002,9004,10),(9003,9004,15),(9004,9005,3);
/*!40000 ALTER TABLE `hospital_edges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiver`
--

DROP TABLE IF EXISTS `receiver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receiver` (
  `receiverUserID` int(11) NOT NULL AUTO_INCREMENT,
  `receiverName` varchar(50) DEFAULT NULL,
  `receiverBloodGroup` varchar(3) DEFAULT NULL,
  `birthDate` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `organName` varchar(30) DEFAULT NULL,
  `receiverAddress` varchar(30) DEFAULT NULL,
  `mobileNo` decimal(10,0) DEFAULT NULL,
  `approvalStaus` int(11) DEFAULT NULL,
  `hospital_reg` int(11) DEFAULT NULL,
  `emergency` int(11) DEFAULT NULL,
  `allotmentStatus` varchar(20) DEFAULT 'not alloted',
  `donorAlloted` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`receiverUserID`),
  KEY `hospital_reg` (`hospital_reg`),
  CONSTRAINT `receiver_ibfk_1` FOREIGN KEY (`hospital_reg`) REFERENCES `hospital` (`hospitalCode`)
) ENGINE=InnoDB AUTO_INCREMENT=2020 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiver`
--

LOCK TABLES `receiver` WRITE;
/*!40000 ALTER TABLE `receiver` DISABLE KEYS */;
INSERT INTO `receiver` VALUES (2001,'Sonali Kendale','O-','01-02-1995','F',70,'Brain','Pune',9848334188,1,9005,7,'not alloted',NULL),(2003,'Samir Gore','AB-','12-04-2001','M',75.5,'Kidney','Katraj',9823337050,1,9001,5,'not alloted',NULL),(2009,'Shruti','A+',NULL,'F',65,'Kidney',NULL,9921447403,NULL,9004,10,'alloted','Shalini'),(2010,'Shriya','A+',NULL,'F',60,'Kidney',NULL,7776059484,NULL,9003,10,'alloted','Supriya'),(2011,'Jenifer','A+',NULL,'F',70,'Liver',NULL,9921445568,NULL,9001,8,'alloted','Shalini Vaidya'),(2012,'Swati Modak','O+',NULL,'F',56,'Kidney',NULL,8990567831,NULL,9004,6,'alloted','Shalini Vaidya'),(2013,'Suresh Bhat','B+',NULL,'M',78,'Liver',NULL,7895679992,NULL,9006,4,'not alloted','asadfghj'),(2014,'Ram Sharma','AB+',NULL,'M',90,'Kidney',NULL,9876704477,NULL,9006,9,'not alloted',NULL),(2015,'Priya Marathe','O-',NULL,'F',56,'Liver',NULL,8769995768,NULL,9006,10,'not alloted',NULL),(2016,'Shriya Mhetre','B+',NULL,'F',67,'Kidney',NULL,9921447403,NULL,9004,6,'not alloted',NULL),(2017,'Swara Bhaskar','A-',NULL,'F',78,'Liver',NULL,9921445689,NULL,9005,8,'not alloted',NULL),(2018,'Kumar Verma','B+',NULL,'M',88,'Liver',NULL,9897867545,NULL,9006,8,'alloted','Shalini Vaidya'),(2019,'Sachin Belsare','A-',NULL,'M',67,'Kidney',NULL,9898675689,NULL,9004,8,'not alloted',NULL);
/*!40000 ALTER TABLE `receiver` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 23:37:12
