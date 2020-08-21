/*
Navicat MySQL Data Transfer

Source Server         : people
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : bigdemo

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-08-21 17:16:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class_admin`
-- ----------------------------
DROP TABLE IF EXISTS `class_admin`;
CREATE TABLE `class_admin` (
  `class_id` int(10) NOT NULL,
  `class_name` varchar(15) DEFAULT NULL,
  `vacancie_num` int(15) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `class_leader` varchar(10) DEFAULT NULL,
  `pay_price` int(100) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_admin
-- ----------------------------
INSERT INTO `class_admin` VALUES ('1', 'z', '94', 'z', 'z', '12');

-- ----------------------------
-- Table structure for `course_admin`
-- ----------------------------
DROP TABLE IF EXISTS `course_admin`;
CREATE TABLE `course_admin` (
  `course_id` int(100) NOT NULL,
  `course_name` varchar(10) DEFAULT NULL,
  `course_tch` varchar(10) DEFAULT NULL,
  `course_place` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_admin
-- ----------------------------
INSERT INTO `course_admin` VALUES ('0', 'as', 'as', 'as');
INSERT INTO `course_admin` VALUES ('1', 'as', 'as', 'as');
INSERT INTO `course_admin` VALUES ('2', '2', '2', '2');
INSERT INTO `course_admin` VALUES ('3', '3', '3', '3');
INSERT INTO `course_admin` VALUES ('4', '4', '4', '4');

-- ----------------------------
-- Table structure for `discount_activity`
-- ----------------------------
DROP TABLE IF EXISTS `discount_activity`;
CREATE TABLE `discount_activity` (
  `act_id` int(10) NOT NULL,
  `act_name` varchar(20) DEFAULT NULL,
  `act_num` int(10) DEFAULT NULL,
  `surplus_num` int(10) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `class_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`act_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discount_activity
-- ----------------------------
INSERT INTO `discount_activity` VALUES ('1', 'zz', '12', '94', '2020-08-12', '2020-08-15', '12', '未开始', '1');

-- ----------------------------
-- Table structure for `order_list`
-- ----------------------------
DROP TABLE IF EXISTS `order_list`;
CREATE TABLE `order_list` (
  `order_id` int(50) NOT NULL,
  `stu_id` int(10) DEFAULT NULL,
  `stu_picture` varchar(100) DEFAULT NULL,
  `stu_name` varchar(10) DEFAULT NULL,
  `class_id` int(100) DEFAULT NULL,
  `stu_sex` varchar(10) DEFAULT NULL,
  `stu_age` int(10) DEFAULT NULL,
  `stu_phone` varchar(100) DEFAULT NULL,
  `order_price` int(100) DEFAULT NULL,
  `actual_price` int(100) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_list
-- ----------------------------

-- ----------------------------
-- Table structure for `stu_admin`
-- ----------------------------
DROP TABLE IF EXISTS `stu_admin`;
CREATE TABLE `stu_admin` (
  `stu_id` varchar(20) NOT NULL,
  `stu_password` varchar(100) DEFAULT NULL,
  `stus_id` varchar(100) DEFAULT NULL,
  `perms` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_admin
-- ----------------------------
INSERT INTO `stu_admin` VALUES ('123', 'dd16eb9083ab407f25af3ade4ab0cba9', '1248', 'stu:select');

-- ----------------------------
-- Table structure for `stu_info`
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `stu_id` int(10) NOT NULL,
  `stu_picture` varchar(200) DEFAULT NULL,
  `stu_name` varchar(10) DEFAULT NULL,
  `stu_sex` varchar(10) DEFAULT NULL,
  `stu_class` int(10) DEFAULT NULL,
  `price_state` varchar(10) DEFAULT NULL,
  `stu_phone` varchar(15) DEFAULT NULL,
  `stu_age` int(10) DEFAULT NULL,
  `order_amount` int(10) DEFAULT NULL,
  `actual_amount` int(10) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tch_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tch_admin`;
CREATE TABLE `tch_admin` (
  `tch_id` int(10) NOT NULL,
  `tch_name` varchar(10) DEFAULT NULL,
  `tch_subject` varchar(10) DEFAULT NULL,
  `leader_class` int(10) DEFAULT NULL,
  `tch_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tch_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `timetable`
-- ----------------------------
DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable` (
  `class_id` int(10) NOT NULL,
  `one` varchar(10) DEFAULT NULL,
  `two` varchar(10) DEFAULT NULL,
  `three` varchar(10) DEFAULT NULL,
  `four` varchar(10) DEFAULT NULL,
  `five` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timetable
-- ----------------------------
INSERT INTO `timetable` VALUES ('1', '4', '4', '4', '4', '4');
INSERT INTO `timetable` VALUES ('1111111', '4', '4', '4', '4', '4');
