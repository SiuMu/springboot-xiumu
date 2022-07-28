-- MySQL dump 10.13  Distrib 5.7.30, for Win64 (x86_64)
--
-- Host: localhost    Database: xiumu
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `sys_authority`
--

DROP TABLE IF EXISTS `sys_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `auth_code` varchar(32) DEFAULT NULL COMMENT '权限编码',
  `auth_name` varchar(128) DEFAULT NULL COMMENT '权限名称',
  `auth_desc` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `auth_type` tinyint(4) DEFAULT NULL COMMENT '权限类型，0菜单，1按钮',
  `weight` smallint(6) DEFAULT '1' COMMENT '排序权重，越小越靠前',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_By` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_By` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` tinyint(3) unsigned DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_authority`
--

LOCK TABLES `sys_authority` WRITE;
/*!40000 ALTER TABLE `sys_authority` DISABLE KEYS */;
INSERT INTO `sys_authority` VALUES (1,0,'*:*:*','权限菜单','权限菜单',0,1,'2022-07-25 22:08:56','2022-07-26 22:28:38',NULL,NULL,1),(1552637514433519617,0,'sys:*:*','系统设置','系统设置',0,1,'2022-07-28 20:50:04','2022-07-28 21:48:28',NULL,NULL,0),(1552653157606117377,1552637514433519617,'sys:user:*','用户管理','用户管理',0,3,'2022-07-28 21:52:14','2022-07-28 22:24:47',NULL,NULL,0),(1552654641198563330,1552637514433519617,'sys:role:*','角色管理','角色管理',0,1,'2022-07-28 21:58:08','2022-07-28 22:24:39',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_code` varchar(32) NOT NULL COMMENT '角色编码',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_By` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_By` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记，0未删除，1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (12345678,'管理员','admin',NULL,'2021-10-08 22:11:55','2022-07-16 17:36:10',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_auth`
--

DROP TABLE IF EXISTS `sys_role_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_auth` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_By` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_By` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_auth`
--

LOCK TABLES `sys_role_auth` WRITE;
/*!40000 ALTER TABLE `sys_role_auth` DISABLE KEYS */;
INSERT INTO `sys_role_auth` VALUES (1,12345678,1,'2022-07-25 22:10:28','2022-07-25 22:10:28',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_role_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别，0男，1女，2未知',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_By` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_By` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记，0未删除，1已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_username_unique_index` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (92193617981,'xiumu','朽木','e10adc3949ba59abbe56e057f20f883e','https://siumu.github.io/img/avatar.jpg',0,'15038935069','1196606665@qq.com','2021-10-08 20:44:51','2022-07-26 21:22:42',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_By` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_By` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,92193617981,12345678,'2022-07-25 22:11:17','2022-07-25 22:11:17',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'xiumu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-28 22:26:02
