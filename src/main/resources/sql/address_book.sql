/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost:3306
 Source Schema         : address_book

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : 65001

 Date: 01/04/2018 18:42:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `classes_id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classes_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `header_URI` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `monitorID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`classes_id`, `classes_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '1401', '1401班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (2, '1402', '1402班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (3, '1403', '1403班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (4, '1404', '1404班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (5, '1405', '1405班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (6, '1406', '1406班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (7, '1407', '1407班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (8, '1408', '1408班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (9, '1409', '1409班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (10, '1410', '1410班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (11, '1411', '1411班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (12, '1412', '1412班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (13, '1413', '1413班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (14, '1414', '1414班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (15, '1415', '1415班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (16, '1416', '1416班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (17, '1417', '1417班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (18, '1418', '1418班', '/img/header01.jpg', '1462141947');
INSERT INTO `classes` VALUES (19, '1419', '1419班', '/img/header01.jpg', '1462141947');

-- ----------------------------
-- Table structure for classes_admin
-- ----------------------------
DROP TABLE IF EXISTS `classes_admin`;
CREATE TABLE `classes_admin`  (
  `id` int(11) NOT NULL,
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bind_classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('你好，这是一条帅气的来自mysql的公告');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sid` int(15) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `favorite_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `favorite_food` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `favorite_fruit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `favorite_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `QQ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `classes_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `header_URI` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, 1462141906, '林心如', '3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1411', NULL, NULL);
INSERT INTO `student` VALUES (4, 1462141907, '刘亦菲', '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1410', NULL, NULL);
INSERT INTO `student` VALUES (6, 1462141908, '张涵熙', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1412', NULL, NULL);
INSERT INTO `student` VALUES (7, 1462141909, '张国鑫', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1418', NULL, NULL);
INSERT INTO `student` VALUES (8, 1462141910, '张芙', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1416', NULL, NULL);
INSERT INTO `student` VALUES (9, 1462141911, '张津', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1415', NULL, NULL);
INSERT INTO `student` VALUES (10, 1462141903, '张昊然', '4324', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1417', NULL, NULL);
INSERT INTO `student` VALUES (11, 1462141904, '张雨', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1415', NULL, NULL);
INSERT INTO `student` VALUES (68, 1462141947, '杨尚昆', '男', '玩游戏', '', '', '', '', '', '', '', '', NULL, NULL, '/img/1462141901.png');
INSERT INTO `student` VALUES (69, 1462141902, '王茜', '女', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1419', NULL, '/img/1462141902.png');
INSERT INTO `student` VALUES (70, 45646, '213255', '12355', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1417', NULL, '/img/45646.png');
INSERT INTO `student` VALUES (71, 1462141939, '大苏打', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1411', NULL, '/img/1462141939.png');
INSERT INTO `student` VALUES (73, 123, '231', '2313', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1414', NULL, '/img/123.png');
INSERT INTO `student` VALUES (76, 1234, '1234', '12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1414', NULL, '/img/1234.png');
INSERT INTO `student` VALUES (77, 1233434, '123', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1414', NULL, '/img/1233434.png');
INSERT INTO `student` VALUES (79, 432, '4324234', '234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1414', NULL, '/img/432.png');
INSERT INTO `student` VALUES (82, 1462140501, '杨尚昆', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1405', NULL, '/img/1462140501.png');
INSERT INTO `student` VALUES (83, 1462140502, '小明', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1405', NULL, '/img/1462140502.png');
INSERT INTO `student` VALUES (84, 1462140503, '小红', '女', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1405', NULL, '/img/1462140503.png');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `available` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL,
  `role_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', NULL);
INSERT INTO `sys_role` VALUES (2, 'monitor', '班长', NULL);
INSERT INTO `sys_role` VALUES (3, 'user', '用户', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1462141947', '202cb962ac59075b964b07152d234b70', '1');

SET FOREIGN_KEY_CHECKS = 1;
