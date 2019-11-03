/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : cxl_diancan

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-11-03 22:18:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rel_product_ingredients
-- ----------------------------
DROP TABLE IF EXISTS `rel_product_ingredients`;
CREATE TABLE `rel_product_ingredients` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品id',
  `INGREDIENTS_ID` int(11) NOT NULL COMMENT '原料id',
  `IS_ENABLE` int(11) NOT NULL DEFAULT '1' COMMENT '是否可用（1：可用，2：不可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品原料关系表';

-- ----------------------------
-- Table structure for tbl_ingredients
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ingredients`;
CREATE TABLE `tbl_ingredients` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `TYEP` int(11) NOT NULL COMMENT '类型（1：咖啡，2：辅料包）',
  `IS_ENABLE` int(11) NOT NULL DEFAULT '1' COMMENT '是否可用（1：可用，2：不可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='原料表';

-- ----------------------------
-- Table structure for tbl_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_detail`;
CREATE TABLE `tbl_order_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` varchar(255) NOT NULL COMMENT '订单id',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品id',
  `PRODUCT_NAME` varchar(255) NOT NULL DEFAULT '' COMMENT '产品名称',
  `PRODUCT_NUM` int(11) NOT NULL DEFAULT '1' COMMENT '购买件数',
  `PRODUCT_PRICE` decimal(10,0) NOT NULL COMMENT '产品单价',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细表';

-- ----------------------------
-- Table structure for tbl_order_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_info`;
CREATE TABLE `tbl_order_info` (
  `ORDER_ID` varchar(50) NOT NULL COMMENT '订单号',
  `USER_ID` int(11) NOT NULL COMMENT '用户id',
  `AMOUNT` decimal(10,0) NOT NULL COMMENT '订单总额',
  `ADD_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `STATUS` int(11) NOT NULL COMMENT '订单状态（1：初始，2：进行中，3：完成）',
  `REMARK` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `IS_ENABLE` int(11) NOT NULL DEFAULT '1' COMMENT '是否可用（1：可用，2：不可用）',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Table structure for tbl_product
-- ----------------------------
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE `tbl_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `PRICE` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '单价',
  `IS_ENABLE` int(11) NOT NULL DEFAULT '1' COMMENT '是否可用（1：可用，2：不可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

-- ----------------------------
-- Table structure for tbl_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_info`;
CREATE TABLE `tbl_user_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `NAME` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `PHONE` varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
  `ADDRESS` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  `TYPE` int(11) NOT NULL DEFAULT '1' COMMENT '1：顾客；2：管理员',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
