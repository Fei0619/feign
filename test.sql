/*
 Navicat Premium Data Transfer

 Source Server         : fsc本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 15/08/2019 16:36:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ib_subject
-- ----------------------------
DROP TABLE IF EXISTS `ib_subject`;
CREATE TABLE `ib_subject`  (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ib_subject
-- ----------------------------
INSERT INTO `ib_subject` VALUES (1, '语文');
INSERT INTO `ib_subject` VALUES (2, '数学');
INSERT INTO `ib_subject` VALUES (3, '英语');
INSERT INTO `ib_subject` VALUES (4, '物理');
INSERT INTO `ib_subject` VALUES (5, '化学');
INSERT INTO `ib_subject` VALUES (6, '生物');

-- ----------------------------
-- Table structure for ib_user
-- ----------------------------
DROP TABLE IF EXISTS `ib_user`;
CREATE TABLE `ib_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别 0=女，1=男',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ib_user
-- ----------------------------
INSERT INTO `ib_user` VALUES (1, 'feishicheng', 'Fei@0619', '费世程', 0);
INSERT INTO `ib_user` VALUES (2, 'jiangxiaobai', 'Jiang@0824', '小小白', 1);
INSERT INTO `ib_user` VALUES (3, 'zhenpiaoliang', 'Zhen@7801', '甄漂亮', 1);
INSERT INTO `ib_user` VALUES (4, 'jiafugui', 'Jia@0913', '贾富贵', 1);

-- ----------------------------
-- Table structure for ib_user_subject
-- ----------------------------
DROP TABLE IF EXISTS `ib_user_subject`;
CREATE TABLE `ib_user_subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `subject_id` int(11) NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ib_user_subject
-- ----------------------------
INSERT INTO `ib_user_subject` VALUES (1, 1, 6, 66);
INSERT INTO `ib_user_subject` VALUES (2, 1, 3, 98);
INSERT INTO `ib_user_subject` VALUES (3, 2, 3, 87);
INSERT INTO `ib_user_subject` VALUES (4, 3, 5, 96);
INSERT INTO `ib_user_subject` VALUES (5, 3, 5, 96);

-- ----------------------------
-- View structure for man_user
-- ----------------------------
DROP VIEW IF EXISTS `man_user`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `man_user` AS select
id,account,user_name,sex
from ib_user where sex=1
with check option  WITH CASCADED CHECK OPTION;

-- ----------------------------
-- View structure for woman_user
-- ----------------------------
DROP VIEW IF EXISTS `woman_user`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `woman_user` AS select
id,account,user_name,sex
from ib_user where sex=0 ;

SET FOREIGN_KEY_CHECKS = 1;
