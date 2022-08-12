/*
 Navicat Premium Data Transfer

 Source Server         : Local MySQL
 Source Server Type    : MySQL
 Source Server Version : 100421
 Source Host           : localhost:3306
 Source Schema         : java_gestion_departements

 Target Server Type    : MySQL
 Target Server Version : 100421
 File Encoding         : 65001

 Date: 05/01/2022 08:49:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for departement
-- ----------------------------
DROP TABLE IF EXISTS `departement`;
CREATE TABLE `departement`  (
  `id_depart` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_depart`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for professeur
-- ----------------------------
DROP TABLE IF EXISTS `professeur`;
CREATE TABLE `professeur`  (
  `id_prof` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prenom` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adresse` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_depart` bigint NOT NULL,
  `date_recrutement` date NOT NULL,
  PRIMARY KEY (`id_prof`) USING BTREE,
  INDEX `professeur_depart`(`id_depart`) USING BTREE,
  CONSTRAINT `professeur_depart` FOREIGN KEY (`id_depart`) REFERENCES `departement` (`id_depart`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
