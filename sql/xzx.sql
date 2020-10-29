/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : xzx

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-10-29 08:59:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for inquiry
-- ----------------------------
DROP TABLE IF EXISTS `inquiry`;
CREATE TABLE `inquiry` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '所询价设备名称',
  `brand` varchar(255) DEFAULT '' COMMENT '品牌推荐',
  `params` varchar(255) DEFAULT NULL COMMENT '技术参数',
  `model` varchar(255) DEFAULT NULL COMMENT '品牌型号',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `number` int(10) DEFAULT NULL COMMENT '数量',
  `total_price` double(20,2) DEFAULT NULL COMMENT '报价总价',
  `price` double(20,2) DEFAULT NULL COMMENT '报价单价',
  `sort` int(10) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `pro_detail_id` bigint(40) DEFAULT NULL,
  `device_type_id` bigint(40) DEFAULT NULL,
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inquiry
-- ----------------------------
INSERT INTO `inquiry` VALUES ('110893159', '电话机', null, '带来电显示，TCL', 'TCLHCD868（37）', '台', '50', null, null, '3', null, '275476318', null, '1', '1', '1', '1603426990857');
INSERT INTO `inquiry` VALUES ('574075547', '保安配线箱', null, '300回线', 'DP-1', '套', '1', null, null, '2', null, '275476318', null, '1', '1', '1', '1603426990857');
INSERT INTO `inquiry` VALUES ('920780065', '调度电话总机', null, '容量：用户56门+环路中继16门', 'DCD128M', '套', '2', null, null, '1', null, '275476318', null, '1', '0', '1', '1603845483305');
INSERT INTO `inquiry` VALUES ('1001269108', '电话分线箱(含箱内接线端子)', null, '20对线', '20对线', '只', '10', null, null, '4', null, '275476318', null, '1', '0', '1', '1603426990857');
INSERT INTO `inquiry` VALUES ('1085275955', '电话插座', null, '单口', '单口', '只', '50', null, null, '5', null, '275476318', null, '1', '0', '1', '1603426990857');
INSERT INTO `inquiry` VALUES ('1915891030', '铜芯市话通信电缆', null, 'HYA30X2X0.5', 'HYA30X2X0.5', '米', '550', null, null, '6', null, '275476318', null, '1', '0', '1', '1603426990857');

-- ----------------------------
-- Table structure for quote
-- ----------------------------
DROP TABLE IF EXISTS `quote`;
CREATE TABLE `quote` (
  `id` bigint(40) NOT NULL COMMENT '主键',
  `supplier` varchar(255) DEFAULT NULL,
  `su_model` varchar(255) DEFAULT NULL COMMENT '报价型号',
  `su_params` varchar(255) DEFAULT NULL COMMENT '报价参数',
  `su_price` double(20,2) DEFAULT NULL COMMENT '报价设备单价',
  `su_total_price` double(20,2) DEFAULT NULL COMMENT '报价设备总价',
  `su_delivery` bigint(40) DEFAULT NULL COMMENT '货期',
  `warranty` bigint(40) DEFAULT NULL COMMENT '质保期',
  `su_remark` varchar(255) DEFAULT NULL COMMENT '供应商备注',
  `image` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `inquiry_id` bigint(40) DEFAULT NULL COMMENT '询价id',
  `is_active` int(10) DEFAULT NULL,
  `is_useful` int(10) DEFAULT NULL,
  `operator` bigint(40) DEFAULT NULL,
  `time` bigint(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quote
-- ----------------------------
INSERT INTO `quote` VALUES ('701235873', '供应商1', '实际型号1', '实际参数1', '100.00', '1000.00', '2', '2', '2', 'http://192.168.204.196/images/3af7233b-015c-4d09-bff3-238d5a21be41.png', '110893159', '1', '0', '1', '1603871626418');
INSERT INTO `quote` VALUES ('1524001653', '供应商2', '', '2', '2.00', '2.00', '2', '2', '2', '', '574075547', '1', '0', '1', '1603871626418');

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
INSERT INTO `sys_device_type` VALUES ('1', '笔记本电脑', '1', null, null, null, null);
INSERT INTO `sys_device_type` VALUES ('463667349', '通信电子', '3', null, null, null, null);
INSERT INTO `sys_device_type` VALUES ('160117375509248', '键盘', '2', null, null, null, null);

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL,
  `type` int(10) DEFAULT NULL COMMENT '0-项目文件1-,询价文件,2-技术文件,3-报价文件',
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
INSERT INTO `sys_file` VALUES ('74870406', '165d69d4-b491-41aa-81ee-26e6c48835af.xls', 'http://192.168.204.196/images/165d69d4-b491-41aa-81ee-26e6c48835af.xls', '3', '701235873', '1', '1', '1', '1603871626418');
INSERT INTO `sys_file` VALUES ('547840335', 'devenv.exe', 'http://192.168.204.196/images/9cbeeb3b-50ab-45e3-909c-2a2cd4445507.exe', '2', '1217852782', '1', '1', '1', '1603802350289');
INSERT INTO `sys_file` VALUES ('737166784', '165d69d4-b491-41aa-81ee-26e6c48835af.xls', 'http://192.168.204.196/images/165d69d4-b491-41aa-81ee-26e6c48835af.xls', '3', '1524001653', '1', '1', '1', '1603871626418');
INSERT INTO `sys_file` VALUES ('777853767', '询价模板.xls', 'http://192.168.204.196/images/a7d8a57c-6343-4f36-be7c-b16dbf0bda3a.xls', '3', '214104612', '1', '1', '1', '1603802324519');
INSERT INTO `sys_file` VALUES ('978933030', '新自信.txt', 'http://192.168.204.196/images/717d68de-b60f-4643-8e1e-23340b4cc101.txt', '2', '214104612', '1', '1', '1', '1603802324519');
INSERT INTO `sys_file` VALUES ('1657829029', '询价函汇总.xls', 'http://192.168.204.196/images/68f62807-8b0a-4925-9f59-e53e56318a2e.xls', '3', '1217852782', '1', '1', '1', '1603802350289');

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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_privilege` VALUES ('30', '询价函管理', 'menu', '29', '', '/inquiry/inquiry/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('31', '新增/修改询价', 'hiddenMenu', '29', null, '/inquiry/eidtor', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('32', '查询所有项目', 'method', '18', null, '/project/detail/findByAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('33', '通过项目详情ID查询询价内容', 'method', '29', '', '/inquiry/findByProDetailId', '', null, null, null, null);
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
INSERT INTO `sys_privilege` VALUES ('50', '级联查询询价信息', 'method', '48', null, '/compare/cascadeFindAll', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('51', '级联查询比价信息', 'method', '48', null, '/compare/cascadeFindAllByParams', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('52', '完成一条比价', 'method', '48', null, '/compare/completeCompare', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('53', '批量获取比价信息', 'method', '48', null, '/compare/batchGetCompare', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('54', '新增或修改设备类型', 'method', '37', null, '/deviceType/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('57', '最终审核查询汇总数据', 'method', '42', null, '/finallyCheck/findDraftComparePrice', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('58', '最终审核保存', 'method', '42', null, '/finallyCheck/saveFinallyCheckMessage', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('59', '批量新增询价', 'method', '29', null, '/inquiry/batchAddInquiry', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('60', '报价管理', 'parent', null, null, '/quote/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('61', '查询一条询价下的所有报价', 'method', '60', null, '/quote/findByInquiryId', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('62', '报价单管理', 'menu', '29', null, '/inquiry/quote/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('63', '新增或修改报价', 'method', '60', null, '/quote/saveOrUpdate', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('64', '查询所有询价函', 'method', '29', '', '/inquiry/findAll', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('65', '修改一条询价', 'method', '29', null, '/inquiry/rowSave', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('66', '批量导入报价', 'method', '60', null, '/quote/batchAddQuote', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('67', '报价行内编辑保存', 'method', '60', null, '/quote/rowSave', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('68', '批量逻辑删除询价', 'method', '29', null, '/inquiry/batchSetInvalid', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('69', '按条件查询报价单', 'method', '60', null, '/quote/findBySupplierOrPro', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('70', '批量逻辑删除报价', 'method', '60', null, '/quote/batchSetInvalid', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('71', '验证项目名是否存在', 'method', '18', null, '/project/detail/verifyExistence', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('72', '比价查询', 'method', '48', '', '/compare/findByProIdOrCompareStatus', '', null, null, null, null);

-- ----------------------------
-- Table structure for sys_pro_check
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_check`;
CREATE TABLE `sys_pro_check` (
  `id` bigint(40) NOT NULL COMMENT '项目审核编号',
  `check_status` int(10) DEFAULT NULL COMMENT '审核状态0初始值1通过2未通过',
  `type` varchar(10) DEFAULT NULL COMMENT '比价、xx审核',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `content_id` bigint(40) DEFAULT NULL COMMENT '报价id',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_check
-- ----------------------------
INSERT INTO `sys_pro_check` VALUES ('117755090', '0', '商务审核', null, '1524001653', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('357104080', '0', '最终审核', null, '1524001653', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('968653610', '0', '比价审核', null, '1524001653', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('1211116861', '0', '技术审核', null, '701235873', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('1336949414', '0', '技术审核', null, '1524001653', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('1770777399', '0', '商务审核', null, '701235873', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('2037532668', '0', '最终审核', null, '701235873', '1', '1603871626418');
INSERT INTO `sys_pro_check` VALUES ('2090126488', '0', '比价审核', null, '701235873', '1', '1603871626418');

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
INSERT INTO `sys_pro_detail` VALUES ('275476318', '通信设备采购', null, '通信设备采购', '159909505476470', '2', '1', '0', '1', '1602853824929');
INSERT INTO `sys_pro_detail` VALUES ('1269230258', '1', null, null, '1', '1', '1', '0', '1', '1603090585958');
INSERT INTO `sys_pro_detail` VALUES ('1599777433', '笔记本电脑采购', null, '笔记本电脑采购', '1', '1', '1', '0', '1', '1602853636402');
INSERT INTO `sys_pro_detail` VALUES ('1915620732', '11', null, null, '1', '1', '1', '0', '1', '1603197792503');

-- ----------------------------
-- Table structure for sys_pro_detail_check
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_detail_check`;
CREATE TABLE `sys_pro_detail_check` (
  `id` bigint(40) NOT NULL,
  `pro_detail_id` bigint(40) DEFAULT NULL,
  `check_status` int(10) DEFAULT NULL,
  `check_name` varchar(255) DEFAULT NULL,
  `operator` bigint(40) DEFAULT NULL,
  `time` bigint(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_detail_check
-- ----------------------------
INSERT INTO `sys_pro_detail_check` VALUES ('144660424', '1915620732', '0', '技术审核', '1', '1603197792503');
INSERT INTO `sys_pro_detail_check` VALUES ('873420587', '1915620732', '0', '最终审核', '1', '1603197792503');
INSERT INTO `sys_pro_detail_check` VALUES ('875137048', '1915620732', '0', '商务审核', '1', '1603197792503');
INSERT INTO `sys_pro_detail_check` VALUES ('1083093988', '275476318', '0', '技术审核', '1', '1603715683041');
INSERT INTO `sys_pro_detail_check` VALUES ('1255599427', '275476318', '0', '最终审核', '1', '1603715683041');
INSERT INTO `sys_pro_detail_check` VALUES ('1741815124', '275476318', '0', '商务审核', '1', '1603715683041');

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
INSERT INTO `sys_pro_origin` VALUES ('1', '工程项目', 'B', '1', null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('2', '采购招标', 'C', '1', null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('159903472576303', '工程招标', 'A', '1', null, null, null);

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
INSERT INTO `sys_pro_type` VALUES ('1', '工程项目', null, null, null, null);
INSERT INTO `sys_pro_type` VALUES ('159909505476470', '采购项目', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_role_privilege` VALUES ('79', '1', '50', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('80', '1', '51', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('81', '1', '52', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('82', '1', '53', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('83', '1', '54', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('85', '1', '57', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('86', '1', '58', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('87', '1', '59', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('88', '1', '61', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('89', '1', '62', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('90', '1', '63', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('91', '1', '64', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('92', '1', '65', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('93', '1', '66', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('94', '1', '67', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('95', '1', '68', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('96', '1', '69', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('97', '1', '70', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('98', '1', '71', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('99', '1', '72', null, null, null, null);

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
