-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: ry-vue
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `article_reviews`
--

DROP TABLE IF EXISTS `article_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_reviews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `participant_id` int NOT NULL,
  `reviewer` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `score` double(5,2) DEFAULT NULL,
  `review_comments` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `status` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `evalute_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `participant_id` (`participant_id`),
  KEY `evalute_reference` (`evalute_id`),
  CONSTRAINT `article_reviews_ibfk_1` FOREIGN KEY (`participant_id`) REFERENCES `participants` (`id`),
  CONSTRAINT `evalute_reference` FOREIGN KEY (`evalute_id`) REFERENCES `evaluate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_reviews`
--

LOCK TABLES `article_reviews` WRITE;
/*!40000 ALTER TABLE `article_reviews` DISABLE KEYS */;
INSERT INTO `article_reviews` VALUES (3,1,'John Doe',95.50,'Excellent performance.','2023-06-22 14:00:00','2023-06-23 14:00:00','completed',NULL);
/*!40000 ALTER TABLE `article_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competition_entries`
--

DROP TABLE IF EXISTS `competition_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competition_entries` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `school` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `participant_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contact_info` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `average_score` decimal(5,2) DEFAULT '0.00',
  `submission_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `competition_group` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `information_disclosure` int DEFAULT NULL,
  `class_recordings` int DEFAULT NULL,
  `teaching_plans` int DEFAULT NULL,
  `teaching_implementation_report` int DEFAULT NULL,
  `professional_training_program` int DEFAULT NULL,
  `course_standards` int DEFAULT NULL,
  `textbook_selection` int DEFAULT NULL,
  `register_group` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cover_page` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competition_entries`
--

LOCK TABLES `competition_entries` WRITE;
/*!40000 ALTER TABLE `competition_entries` DISABLE KEYS */;
/*!40000 ALTER TABLE `competition_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluate`
--

DROP TABLE IF EXISTS `evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `school` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `work_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `judge_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `teaching_implementation` decimal(10,2) NOT NULL,
  `lesson_plan` decimal(10,2) NOT NULL,
  `video_materials` decimal(10,2) NOT NULL,
  `professional_training_plan` decimal(10,2) NOT NULL,
  `course_standard` decimal(10,2) NOT NULL,
  `textbook_selection` decimal(10,2) NOT NULL,
  `score` decimal(10,2) NOT NULL,
  `evaluation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluate`
--

LOCK TABLES `evaluate` WRITE;
/*!40000 ALTER TABLE `evaluate` DISABLE KEYS */;
INSERT INTO `evaluate` VALUES (1,'ABC School','Artwork A','Jane Smith',95.50,85.50,90.00,88.50,92.00,89.50,90.50,'2024-06-23 23:00:00');
/*!40000 ALTER TABLE `evaluate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participants` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `school` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `registration_group` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `competition_group` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
INSERT INTO `participants` VALUES (1,'Student','Example University','John Doe','Group A','johndoe123','2023-06-22 14:00:00',NULL,NULL),(2,'学生','北京大学','张三','A组','zhangsan','2024-06-22 15:37:38',NULL,NULL),(4,'asda','asas','saas','dasd','asdas','2024-06-22 15:40:56',NULL,NULL),(15,'教师','asas','saas','思政课程组','asdasda','2024-06-22 15:44:19',NULL,NULL),(16,'评委','北京大学','张三','思政课程组','zhangsaasdasdn','2024-06-22 15:44:44',NULL,NULL),(19,'评委','北京大学','张三','思政课程组','jhifgjhifgh','2024-06-22 15:45:58',NULL,NULL),(20,'评委','北京大学','张三','思政课程组','asdasdasd','2024-06-22 15:46:11',NULL,NULL),(26,'aasdas','北京大学','张三','sdasdadsada','hfjfhfghfghf','2024-06-22 15:59:20',NULL,NULL),(29,'aasdas','北京大学','张三','sdasdadsada','nihao','2024-06-22 16:00:15',NULL,NULL),(31,'aasdas','北京大学','张三','sdasdadsada','ffdssa','2024-06-22 16:02:09',NULL,NULL),(34,'aasdas','北京大学','张三','sdasdadsada','dsafasdf','2024-06-22 16:02:47',NULL,NULL),(68,'Student','Example University','John Doe','Group A','johne123','2024-06-22 17:53:40',NULL,NULL),(69,'asda','asas','saas','dasd','zjhkk','2024-06-22 15:40:56',NULL,NULL),(72,'Student','Example University','John Doe','Group A','johndoe','2024-06-23 11:09:02',NULL,NULL),(74,'Student','Example University','John Doe','Group A','john','2024-06-23 11:16:37','$2a$10$0Py..WhtIpWpysCqKDKbGOOsDqIehu4My3ea5S/zIEYgeZv78oz8C',NULL),(76,'Student','Example University','John Doe','Group A','johnsdfsdf','2024-06-23 11:17:14','$2a$10$9dAdAPXZobAvhtdN6AMu4eGD60g04Hj4UwT2w.SSBM4Rq6PAf/IWm',NULL),(78,'Student','Example University','John Doe','Group A','root','2024-06-23 11:26:06','$2a$10$OD67iAJqSL3I4jeUxsh3Se0x13MR4lJb0e18YnPHcsA6Dfo3Gyj86',NULL);
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refmfiles`
--

DROP TABLE IF EXISTS `refmfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refmfiles` (
  `file_id` bigint NOT NULL AUTO_INCREMENT COMMENT '文件 ID',
  `file_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件路径',
  `file_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件类型',
  `file_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名',
  `file_size` int DEFAULT NULL COMMENT '文件大小',
  `participants_id` bigint NOT NULL COMMENT '店铺 ID',
  `type` int DEFAULT NULL COMMENT '文件 1:图片 2:视频 3:文件',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refmfiles`
--

LOCK TABLES `refmfiles` WRITE;
/*!40000 ALTER TABLE `refmfiles` DISABLE KEYS */;
INSERT INTO `refmfiles` VALUES (1,'/path/to/file','image/jpeg','example.jpg',1024,1001,1),(2,'/path/to/file','image/jpeg','example.jpg',204800,67890,1),(3,'F:\\minioPath736853',NULL,'高中信息技术教学设计模版.docx',32198,1,NULL),(4,'F:\\minioPath550745',NULL,'高中信息技术教学设计模版.docx',32198,1,NULL),(5,'F:\\minioPath268062',NULL,'高中信息技术教学设计模版.docx',32198,1,NULL),(6,'F:\\minioPath620686',NULL,'高中信息技术教学设计模版.docx',32198,1,NULL),(7,'F:\\minioPath438497',NULL,'response.xlsx',3753,1,NULL),(8,'F:/minioPath145347',NULL,'response.xlsx',3753,1,NULL),(9,'minioPath502806',NULL,'response.xlsx',3753,1,NULL),(10,'minioPath658389',NULL,'minioPath658389',3753,1,NULL),(11,'minioPath412673',NULL,'minioPath412673',20859,1,NULL),(12,'minioPath284358',NULL,'minioPath284358',9629908,1,NULL),(13,'minioPath203552',NULL,'minioPath203552',16997,1,NULL),(14,'minioPath991856',NULL,'minioPath991856',28542,1,NULL),(15,'minioPath546186',NULL,'水果与营养.docx',36634,1,NULL);
/*!40000 ALTER TABLE `refmfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '手机号码',
  `sex` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '密码',
  `status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,103,'admin','若依','00','ry@163.com','15888888888','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2024-06-23 22:53:39','admin','2024-06-18 16:26:00','','2024-06-23 22:53:39','管理员'),(2,105,'ry','若依','00','ry@qq.com','15666666666','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2024-06-18 16:26:00','admin','2024-06-18 16:26:00','',NULL,'测试员');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-24 10:18:57
