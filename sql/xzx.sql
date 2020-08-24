/*
Navicat MySQL Data Transfer

Source Server         : smalllei.cn
Source Server Version : 50535
Source Host           : smalllei.cn:3306
Source Database       : xzx

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2020-08-21 15:54:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for inquiry
-- ----------------------------
DROP TABLE IF EXISTS `inquiry`;
CREATE TABLE `inquiry` (
  `id` bigint(40) NOT NULL COMMENT '项目分类编号',
  `supplier_id` bigint(40) DEFAULT NULL,
  `su_model` varchar(255) DEFAULT NULL,
  `su_remark` text,
  `su_delivery` varchar(255) DEFAULT NULL,
  `su_warranties` varchar(255) DEFAULT NULL,
  `pro_file_id` bigint(40) DEFAULT NULL,
  `pro_detail_id` bigint(40) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `su_require` text,
  `su_price` double(40,3) DEFAULT NULL,
  `su_total_price` double(40,3) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `device` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `require` text,
  `name` varchar(255) DEFAULT NULL COMMENT '项目分类名称',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inquiry
-- ----------------------------

-- ----------------------------
-- Table structure for sys_device_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_device_type`;
CREATE TABLE `sys_device_type` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '设备分类名称',
  `code` int(10) DEFAULT NULL COMMENT '设备分类编码',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_device_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(40) NOT NULL COMMENT '日志编号',
  `content` text COMMENT '日志内容',
  `active_time` bigint(40) DEFAULT NULL COMMENT '日志生成时间',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名',
  `type` varchar(255) DEFAULT NULL COMMENT '权限类型',
  `parent_id` bigint(40) DEFAULT NULL COMMENT '父权限编号',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `route` varchar(255) DEFAULT NULL COMMENT '路由',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', '用户管理', 'parent', null, 'user', '/user/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('2', '角色管理', 'parent', null, 'peoples', '/role/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('3', '权限管理', 'parent', null, 'lock', '/privilege/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('4', '通过token获取用户信息', 'method', '1', null, '/user/info', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('5', '查询用户动态菜单栏', 'method', '1', null, '/user/findMenuByUserId', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('6', '级联查询所有权限', 'method', '2', null, '/role/cascadePrivilegeFindAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('7', '查询权限树', 'method', '3', null, '/privilege/findPrivilegeTree', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('8', '授权', 'method', '2', null, '/role/authorization', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('9', '用户管理菜单', 'menu', '1', null, '/user/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('10', '角色管理菜单', 'menu', '2', null, '/role/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('11', '权限管理菜单', 'menu', '3', null, '/privilege/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('12', '查询所有权限', 'method', '3', null, '/privilege/findByParentId', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('13', '新增/修改权限', 'method', '3', null, '/privilege/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('14', '级联查询所有角色', 'method', '1', null, '/user/cascadeRoleFindAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('15', '新增修改角色', 'method', '2', null, '/role/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('16', '查询所有角色', 'method', '2', null, '/role/findAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('17', '新增/修改用户', 'method', '1', null, '/user/saveOrUpdate', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_pro_check
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_check`;
CREATE TABLE `sys_pro_check` (
  `id` bigint(40) NOT NULL COMMENT '项目审核编号',
  `business_check` int(10) DEFAULT NULL COMMENT '商务审核',
  `engine_check` int(10) DEFAULT NULL COMMENT '工程审核',
  `final_check` int(10) DEFAULT NULL COMMENT '最终审核',
  `pro_detail_id` bigint(40) DEFAULT NULL COMMENT '项目详情编号',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_check
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pro_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_detail`;
CREATE TABLE `sys_pro_detail` (
  `id` bigint(40) NOT NULL COMMENT '项目编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `remark` text COMMENT '项目批注',
  `content` text COMMENT '项目内容',
  `pro_type_id` bigint(40) DEFAULT NULL,
  `pro_origin_id` bigint(40) DEFAULT NULL,
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_detail
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pro_origin
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_origin`;
CREATE TABLE `sys_pro_origin` (
  `id` bigint(40) NOT NULL COMMENT '项目来源编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目来源名称',
  `code` int(10) DEFAULT NULL COMMENT '项目来源编码',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_origin
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pro_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_type`;
CREATE TABLE `sys_pro_type` (
  `id` bigint(40) NOT NULL COMMENT '项目分类编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目分类名称',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', null, null, null, null);
INSERT INTO `sys_role` VALUES ('2', 'test', null, null, null, null);

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(40) DEFAULT NULL COMMENT '角色编号',
  `privilege_id` bigint(40) DEFAULT NULL COMMENT '权限编号',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('4', '1', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('5', '1', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('6', '1', '6', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('7', '1', '7', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('8', '1', '8', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('9', '1', '9', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('10', '1', '10', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('11', '1', '11', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('12', '1', '12', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('13', '1', '13', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('14', '1', '14', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('15', '1', '15', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('16', '1', '16', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('17', '1', '17', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(40) NOT NULL COMMENT '用户编号',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '000000', 'http://smalllei.cn/images/06bad62a-4349-466a-9afb-a11d9d2f6d98.png', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(40) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(40) DEFAULT NULL COMMENT '角色编号',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null);
