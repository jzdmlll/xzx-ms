/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : xzx

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-09-23 10:52:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for compare
-- ----------------------------
DROP TABLE IF EXISTS `compare`;
CREATE TABLE `compare` (
  `id` bigint(40) NOT NULL,
  `inquiry_id` bigint(40) DEFAULT NULL COMMENT '询价id外键',
  `status` int(20) DEFAULT NULL COMMENT '状态0未比价1选用2未选用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of compare
-- ----------------------------

-- ----------------------------
-- Table structure for inquiry
-- ----------------------------
DROP TABLE IF EXISTS `inquiry`;
CREATE TABLE `inquiry` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `device_type_id` bigint(40) DEFAULT NULL,
  `warranty` bigint(40) DEFAULT NULL COMMENT '质保期',
  `su_model` varchar(255) DEFAULT NULL COMMENT '供应商设备型号',
  `su_remark` text COMMENT '供应商备注',
  `su_delivery` varchar(255) DEFAULT NULL COMMENT '货期',
  `su_warranties` varchar(255) DEFAULT NULL COMMENT '资质',
  `pro_detail_id` bigint(40) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `su_params` text COMMENT '技术参数',
  `su_price` double(40,3) DEFAULT NULL COMMENT '供应商单价',
  `su_total_price` double(40,3) DEFAULT NULL COMMENT '供应商总价',
  `number` int(10) DEFAULT NULL COMMENT '数量',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `device` varchar(255) DEFAULT NULL COMMENT '设备名',
  `model` varchar(255) DEFAULT NULL COMMENT '询价设备型号',
  `params` text COMMENT '技术参数',
  `name` varchar(255) DEFAULT NULL COMMENT '所询价设备名称',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inquiry
-- ----------------------------
INSERT INTO `inquiry` VALUES ('160074795769611', '1', '1', '1600963200000', '111', '1', '1600963200000', '1', '1', '111', '111', '11.000', '121.000', '11', '美的', '空调', '美的空调MD1', '111', '空调', null, null, '1', null);

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
INSERT INTO `sys_device_type` VALUES ('1', '设备1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL,
  `type` int(10) DEFAULT NULL COMMENT '0-项目详情,',
  `other_id` bigint(40) DEFAULT NULL COMMENT '外键',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('160032707633487', 'a78b9e4c-546f-4916-b2c9-a9a8304ac37c.zip', 'http://192.168.204.196/images/a78b9e4c-546f-4916-b2c9-a9a8304ac37c.zip', '0', '160032708697072', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160032763410437', '微信图片_20200903194147.png', 'http://192.168.204.196/images/2306ca20-da7c-4d77-b33e-a2cd19393191.png', '0', '160032768801293', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160032764483332', '询价模板(1).xls', 'http://192.168.204.196/images/92ecf6fb-8d6c-46f3-8eef-276bbbd27657.xls', '0', '160032768801293', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160032766689791', 'xzx.sql', 'http://192.168.204.196/images/83ca3634-909b-4116-830d-e2bfc95876d4.sql', '0', '160032768801293', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160032768086683', '新自信项目详细设计.docx', 'http://192.168.204.196/images/67250f09-32f1-4138-ad43-f8c915151321.docx', '0', '160032768801293', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160032901985544', '新自信项目详细设计.docx', 'http://192.168.204.196/images/625af319-871d-42ba-aa77-8a2aac0d6a18.docx', '0', '160032902166081', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160033070370839', '新自信项目详细设计.docx', 'http://192.168.204.196/images/ae611eca-a183-4a02-88f0-359c673467a0.docx', '0', '160033070502448', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160039453798166', '新自信项目详细设计.docx', 'http://192.168.204.196/images/230969bc-9390-41ef-9008-d7207aa73f80.docx', '0', '160039454985386', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160039454168585', '新自信项目详细设计.docx', 'http://192.168.204.196/images/973c8763-06fc-4175-b1ef-0340b938553b.docx', '0', '160039454985386', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160039486006008', '新自信项目详细设计.docx', 'http://192.168.204.196/images/756df6bf-1689-4f14-bf45-c887f8d53454.docx', '0', '160039505820394', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160039505210002', '新自信项目详细设计.docx', 'http://192.168.204.196/images/680b8c62-a0a0-4fff-aad7-72c1537496e1.docx', '0', '160039505820394', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160039538913534', 'apache-tomcat-9.0.13-windows-x64.zip', 'http://192.168.204.196/images/22e2f3b0-f1a1-4d00-befa-0279118a54fd.zip', '0', '160039539885088', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160039902493333', 'libstdc++-6.dll', 'http://192.168.204.196/images/80ea51e2-8e97-4634-8159-06fb8cec8946.dll', '0', '160039902877277', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160065283710836', 'Qt5Core.dll', 'http://192.168.204.196/images/f39a8ebb-f958-43ba-902f-4d9c412d4fa9.dll', '0', '160065285292808', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160065512831440', 'libssh2-1.dll', 'http://192.168.204.196/images/96ee33db-5ab9-4245-815f-107563214999.dll', '0', '160065513529049', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160065538754703', 'settings.xml', 'http://192.168.204.196/images/32246ab3-18c6-4fe4-922b-ea414b462e15.xml', '0', '160065539444562', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160065556373884', 'settings.xml', 'http://192.168.204.196/images/810130cb-1ca3-4493-b30f-ff7aae80196a.xml', '0', '160065557001177', null, null, null, null);
INSERT INTO `sys_file` VALUES ('160074795135938', 'settings.xml', 'http://192.168.204.196/images/5cb172ba-a7dc-4a91-97cc-cc3543ec114f.xml', '0', '160074795769611', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_privilege` VALUES ('9', '用户管理', 'menu', '1', '', '/user/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('10', '角色管理', 'menu', '2', '', '/role/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('11', '权限管理', 'menu', '3', '', '/privilege/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('12', '查询所有权限', 'method', '3', null, '/privilege/findByParentId', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('13', '新增/修改权限', 'method', '3', null, '/privilege/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('14', '级联查询所有角色', 'method', '1', null, '/user/cascadeRoleFindAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('15', '新增修改角色', 'method', '2', null, '/role/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('16', '查询所有角色', 'method', '2', null, '/role/findAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('17', '新增/修改用户', 'method', '1', null, '/user/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('18', '项目管理', 'parent', null, 'clipboard', '/project/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('19', '项目分类管理', 'menu', '18', '', '/project/type/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('20', '给用户设置角色', 'method', '1', null, '/user/setRoles', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('21', '项目来源管理', 'menu', '18', null, '/project/origin/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('22', '项目详情管理', 'menu', '18', null, '/project/detail/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('23', '查询所有项目来源', 'method', '18', null, '/project/origin/findAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('24', '新增或修改项目来源', 'method', '18', '', '/project/origin/saveOrUpdate', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('25', '逻辑删除项目来源', 'method', '18', '', '/project/origin/logicDeleteById', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('26', '查询所有项目分类', 'method', '18', null, '/project/type/findAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('27', '新增或修改项目分类', 'method', '18', null, '/project/type/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('28', '逻辑删除项目分类', 'method', '18', null, 'project/type/logicDeleteById', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('29', '询价管理', 'parent', null, 'message', '/inquiry/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('30', '询价管理', 'menu', '29', null, '/inquiry/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('31', '新增/修改询价', 'hiddenMenu', '29', null, '/inquiry/eidtor', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('32', '查询所有项目', 'method', '18', null, '/project/detail/findByAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('33', '通过项目详情ID查询询价内容', 'method', '29', '', '/inquiry/findByDetailId', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('34', '刷新token', 'method', '1', null, '/user/refreshToken', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('35', '新增或修改询价内容', 'method', '29', null, '/inquiry/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('36', '新增或修改项目详情', 'method', '18', null, '/project/detail/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('37', '设备类型管理', 'parent', null, 'example', '/deviceType/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('38', '模糊查询设备类型', 'method', '37', null, '/deviceType/findAllLike', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('39', '设备类型管理', 'menu', '37', null, '/deviceType/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('40', '级联角色查询项目审核信息', 'method', '18', null, '/project/check/cascadeRoleFindAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('41', '查询所有审核名', 'method', '2', null, '/role/selectAllHasCheckName', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('42', '审核管理', 'parent', null, 'eye-open', '/proCheck/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('43', '技术审核', 'menu', '42', '', '/proCheck/technology', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('44', '商务审核', 'menu', '42', null, '/proCheck/business', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('45', '最终审核', 'menu', '42', '', '/proCheck/final', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('46', '级联角色、询价（或项目）查询所有信息', 'method', '42', null, '/proCheck/cascadeFindAllByCheckName', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('47', '批量审核', 'method', '42', null, '/proCheck/batchCheck', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('48', '比价管理', 'parent', null, 'chart', '/compare/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('49', '比价管理', 'menu', '48', null, '/compare/list', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_pro_check
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_check`;
CREATE TABLE `sys_pro_check` (
  `id` bigint(40) NOT NULL COMMENT '项目审核编号',
  `check_status` int(10) DEFAULT NULL COMMENT '审核状态',
  `sort` int(10) DEFAULT NULL COMMENT '顺序',
  `type` int(10) DEFAULT NULL COMMENT '项目详情编号',
  `content_id` bigint(40) DEFAULT NULL COMMENT '询价或项目外键',
  `role_id` bigint(40) DEFAULT NULL COMMENT '角色id',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_check
-- ----------------------------
INSERT INTO `sys_pro_check` VALUES ('160074795808607', '0', '1', '0', '160074795769611', '3', '1', '1600747958086');
INSERT INTO `sys_pro_check` VALUES ('160074795808700', '0', '2', '0', '160074795769611', '4', '1', '1600747958087');
INSERT INTO `sys_pro_check` VALUES ('160074795808734', '0', '3', '0', '160074795769611', '5', '1', '1600747958087');

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
INSERT INTO `sys_pro_detail` VALUES ('1', '项目1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO `sys_pro_detail` VALUES ('2', '项目2', '1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sys_pro_origin
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_origin`;
CREATE TABLE `sys_pro_origin` (
  `id` bigint(40) NOT NULL COMMENT '项目来源编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目来源名称',
  `code` varchar(10) DEFAULT NULL COMMENT '项目来源编码',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_origin
-- ----------------------------
INSERT INTO `sys_pro_origin` VALUES ('1', '1', 'B', '0', null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('159903472576303', 'test', 'A', null, null, null, null);

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
INSERT INTO `sys_pro_type` VALUES ('1', '2', null, null, null, null);
INSERT INTO `sys_pro_type` VALUES ('159909505476470', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `check_name` varchar(255) DEFAULT NULL,
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '', null, null, null, null);
INSERT INTO `sys_role` VALUES ('2', 'test', null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('3', '技术部', '技术审核', null, null, null, null);
INSERT INTO `sys_role` VALUES ('4', '市场部', '商务审核', null, null, null, null);
INSERT INTO `sys_role` VALUES ('5', '领导', '最终审核', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_role_privilege` VALUES ('18', '1', '19', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('19', '1', '20', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('20', '1', '21', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('21', '1', '22', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('22', '1', '23', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('23', '1', '24', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('24', '1', '25', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('25', '1', '26', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('26', '1', '27', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('27', '1', '28', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('28', '1', '30', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('29', '1', '32', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('30', '1', '31', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('31', '1', '33', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('32', '1', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('33', '1', '35', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('34', '1', '36', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('35', '1', '38', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('36', '1', '39', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('37', '2', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('38', '2', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('39', '2', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('40', '1', '40', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('41', '1', '41', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('42', '1', '43', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('43', '1', '44', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('44', '1', '45', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('45', '1', '46', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('46', '3', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('47', '3', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('48', '3', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('49', '3', '43', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('50', '3', '46', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('61', '1', '47', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('62', '3', '47', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('63', '3', '32', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('64', '4', '32', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('65', '4', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('66', '4', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('67', '4', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('68', '5', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('69', '5', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('70', '5', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('71', '5', '32', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('72', '5', '45', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('73', '5', '46', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('74', '5', '47', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('75', '4', '44', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('76', '4', '46', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('77', '4', '47', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('78', '1', '49', null, null, null, null);

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
INSERT INTO `sys_user` VALUES ('160033564240903', 'test', '000000', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('160069265124036', '技术部', '000000', null, null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('4', '160033564240903', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('6', '160069265124036', '3', null, null, null, null);
