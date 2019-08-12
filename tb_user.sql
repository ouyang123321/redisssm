/*
 Navicat Premium Data Transfer

 Source Server         : Connection
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 25/07/2019 15:52:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '1a', '1', 1);
INSERT INTO `tb_user` VALUES (2, '2b', '2', 2);
INSERT INTO `tb_user` VALUES (3, '3c', '3', 3);
INSERT INTO `tb_user` VALUES (4, '4d', '4', 4);
INSERT INTO `tb_user` VALUES (5, '5e', '5', 5);
INSERT INTO `tb_user` VALUES (6, '6f', '6', 6);
INSERT INTO `tb_user` VALUES (7, '7g', '7', 7);
INSERT INTO `tb_user` VALUES (8, '8h', '8', 8);
INSERT INTO `tb_user` VALUES (9, '9i', '9', 9);
INSERT INTO `tb_user` VALUES (10, '10j', '10', 10);

SET FOREIGN_KEY_CHECKS = 1;
