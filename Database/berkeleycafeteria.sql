-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: berkeleycafeteria
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `cafeteria_order`
--

DROP TABLE IF EXISTS `cafeteria_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cafeteria_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `is_complete` bit(1) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `pickup_time` datetime DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `status` varchar(14) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_r38ssjr50rbivv4v01uft12gd` (`user_id`),
  CONSTRAINT `FK_r38ssjr50rbivv4v01uft12gd` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafeteria_order`
--

LOCK TABLES `cafeteria_order` WRITE;
/*!40000 ALTER TABLE `cafeteria_order` DISABLE KEYS */;
INSERT INTO `cafeteria_order` VALUES (3,4,'','2015-09-05 12:00:00','2015-09-05 15:37:04',1,'Picked Up'),(4,5,'','2015-09-05 21:29:32','2015-09-24 01:00:00',1,'Picked Up'),(5,5,'','2015-09-05 21:31:44','2015-09-05 13:00:00',1,'Missed'),(6,4,'','2015-09-05 21:48:37','2015-09-08 21:00:00',1,'Picked Up'),(7,11,'','2015-09-05 22:13:14','2015-09-17 14:00:00',1,'Picked Up'),(8,5,'','2015-09-05 22:51:07','2015-09-18 13:00:00',1,'Missed'),(9,4,'','2015-09-05 22:56:08','2015-09-25 19:00:00',1,'Picked Up'),(10,3,'','2015-09-05 22:56:20','2015-09-23 13:00:00',1,'Picked Up'),(11,3,'','2015-09-05 22:56:34','2015-09-08 17:00:00',1,'Picked Up'),(12,3,'','2015-09-05 22:56:53','2015-09-24 12:00:00',1,'Picked Up'),(13,6,'','2015-09-05 23:04:24','2015-09-24 21:00:00',2,'Missed'),(14,6,'','2015-09-05 23:34:00','2015-09-17 12:00:00',2,'Picked Up'),(15,5,'','2015-09-05 23:44:25','2015-09-17 19:00:00',2,'Missed'),(16,4,'','2015-09-05 23:44:58','2015-09-20 15:00:00',2,'Picked Up'),(17,6,'','2015-09-05 23:45:46','2015-10-01 12:00:00',2,'Picked Up'),(18,15,'','2015-09-06 01:35:11','2015-09-16 05:00:00',2,'Picked Up'),(19,3,'','2015-09-06 01:37:50','2015-09-15 08:00:00',2,'Picked Up'),(20,10,'','2015-09-06 14:03:53','2015-09-16 15:30:00',2,'Picked Up'),(21,4,'','2015-09-06 11:03:30','2015-09-15 15:00:00',1,'Missed'),(25,8,'','2015-09-06 14:37:21','2015-09-23 15:30:00',1,'Picked Up'),(26,3,'','2015-09-06 14:13:04','2015-09-16 14:00:00',2,'Picked Up'),(27,7,'','2015-09-06 14:38:09','2015-09-22 16:30:00',1,'Missed');
/*!40000 ALTER TABLE `cafeteria_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafeteria_order_menu_item`
--

DROP TABLE IF EXISTS `cafeteria_order_menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cafeteria_order_menu_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `cafeteria_order_id` bigint(20) NOT NULL,
  `menu_item_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5tss3itqx5jp3mwqpiecwenqa` (`cafeteria_order_id`),
  KEY `FK_gr6do1xqaxgwb51r3xl962x38` (`menu_item_id`),
  CONSTRAINT `FK_5tss3itqx5jp3mwqpiecwenqa` FOREIGN KEY (`cafeteria_order_id`) REFERENCES `cafeteria_order` (`id`),
  CONSTRAINT `FK_gr6do1xqaxgwb51r3xl962x38` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafeteria_order_menu_item`
--

LOCK TABLES `cafeteria_order_menu_item` WRITE;
/*!40000 ALTER TABLE `cafeteria_order_menu_item` DISABLE KEYS */;
INSERT INTO `cafeteria_order_menu_item` VALUES (1,2,3,1,2),(2,2,3,2,6),(3,5,4,4,6),(4,0,4,2,1),(5,0,5,2,1),(6,0,5,4,1),(7,0,5,5,1),(8,0,6,10,1),(9,0,6,13,1),(10,0,7,3,1),(11,0,7,1,1),(14,0,7,11,1),(15,0,7,2,1),(16,0,7,4,1),(18,0,8,2,1),(19,0,8,1,1),(20,0,8,3,1),(21,1,9,3,2),(22,1,9,8,2),(23,0,10,2,1),(24,0,11,4,1),(25,0,12,12,1),(26,0,13,2,1),(27,0,13,3,1),(28,0,13,13,1),(29,0,13,15,1),(30,1,14,3,5),(31,0,14,16,1),(32,0,14,6,1),(33,1,14,1,2),(34,0,15,1,1),(35,0,15,7,1),(36,0,15,12,1),(37,0,16,4,1),(38,0,16,3,1),(39,0,17,1,1),(40,0,17,2,1),(41,0,17,6,1),(42,0,17,15,1),(49,0,18,2,1),(50,0,19,4,1),(52,0,21,2,1),(53,0,21,4,6),(55,1,20,2,2),(56,0,20,15,1),(57,0,20,1,1),(58,0,20,6,1),(63,0,26,2,1),(64,0,25,2,1),(65,0,25,4,1),(66,1,27,4,2),(67,0,27,11,1),(68,0,27,2,1),(69,0,27,1,1),(70,0,27,3,1);
/*!40000 ALTER TABLE `cafeteria_order_menu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_item`
--

DROP TABLE IF EXISTS `menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `price` double NOT NULL,
  `store_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f2p7tbf2chbuo73bj4qlckpp3` (`store_id`),
  CONSTRAINT `FK_f2p7tbf2chbuo73bj4qlckpp3` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_item`
--

LOCK TABLES `menu_item` WRITE;
/*!40000 ALTER TABLE `menu_item` DISABLE KEYS */;
INSERT INTO `menu_item` VALUES (1,8,7.5,1,'Hamburger And Fries','Hamburger.jpg'),(2,23,7.75,1,'Cheeseburger And Fries','Cheeseburger.jpg'),(3,20,6,1,'Chicken Fingers And Fries','ChickenFingers.jpg'),(4,10,6,1,'Grilled Cheese And Fries','GrilledCheese.jpg'),(5,1,8,3,'Plain Pizza','Plain.jpg'),(6,5,8,3,'Pepperoni Pizza','Pepperoni.jpg'),(7,1,7.75,3,'Margarita Pizza','Margarita.jpg'),(8,1,8.5,3,'Meat Lovers Pizza','MeatLovers.jpg'),(9,0,8,2,'Beef and Broccoli','BeefBroccoli.jpg'),(10,1,6,2,'Chicken Fried Rice','FriedRice.jpg'),(11,2,7.5,2,'Orange Chicken','OrangeChicken.jpg'),(12,4,7.5,2,'General Tso\'s Chicken','GeneralTsos.jpg'),(13,2,8,4,'Assorted Sushi','AssortedSushi.jpg'),(14,0,7.5,4,'California Roll','CaliforniaRoll.jpg'),(15,3,8,4,'Rainbow Roll','RainbowRoll.jpg'),(16,1,8,4,'Spicy Tuna Roll','SpicyTuna.jpeg');
/*!40000 ALTER TABLE `menu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,0,'American'),(2,0,'Chinese'),(3,0,'Pizza'),(4,0,'Sushi');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `is_student` tinyint(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,1,'Arun','berkeley1234'),(2,0,0,'Cashier','money1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-06 15:04:08
