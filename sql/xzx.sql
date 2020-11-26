/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : xzx

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-11-26 08:10:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for inquiry
-- ----------------------------
DROP TABLE IF EXISTS `inquiry`;
CREATE TABLE `inquiry` (
  `id` bigint(40) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '所询价设备名称',
  `real_brand` varchar(255) DEFAULT '' COMMENT '品牌',
  `brand` varchar(255) DEFAULT '' COMMENT '品牌推荐',
  `params` varchar(10000) DEFAULT NULL COMMENT '技术参数',
  `model` varchar(10000) DEFAULT NULL COMMENT '品牌型号',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `number` int(10) DEFAULT NULL COMMENT '数量',
  `total_price` double(20,2) DEFAULT NULL COMMENT '报价总价',
  `price` double(20,2) DEFAULT NULL COMMENT '报价单价',
  `sort` int(10) DEFAULT NULL,
  `isInquiry` int(11) DEFAULT '1' COMMENT '是否需要询价 1需要/0不需要',
  `veto` int(10) DEFAULT NULL COMMENT '否决标识 0未否决/1已否决',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `pro_detail_id` bigint(40) DEFAULT NULL,
  `device_type_id` bigint(40) DEFAULT NULL,
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效 0是无效/1是有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inquiry
-- ----------------------------
INSERT INTO `inquiry` VALUES ('280382064', '46寸高清监控专用显示器', '1', null, 'DS-D5046QD', '1', '台', '1', '2950.00', '2950.00', '4', '1', '0', null, '1737005095', null, '1', '0', '1', '1605680943894');
INSERT INTO `inquiry` VALUES ('310007395', 'NVR硬盘录像机', '1', null, '2U标准机架式IP存储，嵌入式处理器，嵌入式软硬件设计；支持24路高清，256M带宽网络视频接入，256M网络带宽输出；支持8个SATA盘位；支持RAID0、1、5、6、10多种RAID模式及全局热备，多重保护数据安全；2个千兆以太网口等；配硬盘2个2T。', '1', '台', '1', '2244.00', '2244.00', '3', '1', '0', null, '1565074093', null, '1', '0', '1', '1605495092256');
INSERT INTO `inquiry` VALUES ('591207456', '46寸高清监控专用显示器', '1', '', 'DS-D5046QD', '1', '台', '1', '3245.00', '3246.00', '4', '1', '0', '打回重新询价', '1565074093', null, '1', '0', '1', '1606185672330');
INSERT INTO `inquiry` VALUES ('696644478', '高清视频线', '1', null, 'HDMI高清视频线，10米', '1', '根', '1', '660.00', '660.00', '7', '1', '0', null, '1565074093', null, '1', '0', '1', '1605495121030');
INSERT INTO `inquiry` VALUES ('801584492', '枪机支架', null, null, '壁装支架/ 海康白/ 铝合金，\n尺寸70×97.1×181.8mm', null, '台', '12', null, null, '2', '1', '0', null, '1737005095', null, '1', '0', '1', '1605680943894');
INSERT INTO `inquiry` VALUES ('917701022', '46寸高清监控专用显示器', '1', '', 'DS-D5046QD', '1', '台', '1', '3000.00', '3000.00', '4', '1', '0', '打回重新询价', '1565074093', null, '0', '0', '1', '1606115787463');
INSERT INTO `inquiry` VALUES ('989407068', '单模POE视频光端机', '1', null, '1个FC光口，8个RJ45电口', '1', '对', '2', '0.00', '0.00', '5', '1', '0', null, '1737005095', null, '1', '0', '1', '1605755800992');
INSERT INTO `inquiry` VALUES ('1020844082', '硬盘录像机硬盘', '1', null, '4T', '1', '块', '4', null, null, '6', '1', '0', null, '1737005095', null, '1', '0', '1', '1605680943894');
INSERT INTO `inquiry` VALUES ('1381828833', '高清视频线', '1', null, 'HDMI高清视频线，10米', '1', '根', '1', null, null, '7', '1', '0', null, '1737005095', null, '1', '0', '1', '1605680943894');
INSERT INTO `inquiry` VALUES ('1537119181', '硬盘录像机硬盘', '1', null, '4T', '1', '块', '4', '2684.00', '671.00', '6', '1', '0', null, '1565074093', null, '1', '0', '1', '1605579062063');
INSERT INTO `inquiry` VALUES ('1540990428', '46寸高清监控专用显示器', '1', '', 'DS-D5046QD', '1', '台', '1', '3000.00', '3000.00', '4', '1', '0', '打回重新询价', '1565074093', null, '0', '0', '1', '1606115619452');
INSERT INTO `inquiry` VALUES ('1611342730', '200万高清网络\n红外枪机', '1', null, '200万像素   1/2.8”CMOS，\n1920×1080，H.265，数字宽动态，镜头4mm，30米红外，智能分析，DC12V/POE供电，不含支架', '1', '台', '12', null, null, '1', '1', '0', null, '1737005095', null, '1', '0', '1', '1605680983676');
INSERT INTO `inquiry` VALUES ('1711719106', '单模POE视频光端机', '1', null, '1个FC光口，8个RJ45电口', '1', '对', '2', '0.00', '0.00', '5', '1', '0', null, '1565074093', null, '1', '0', '1', '1605755789149');
INSERT INTO `inquiry` VALUES ('1752310728', '46寸高清监控专用显示器', '1', '', 'DS-D5046QD', '1', '台', '1', '3000.00', '3000.00', '4', '1', '1', '打回重新询价', '1565074093', null, '1', '0', '1', '1605670254826');
INSERT INTO `inquiry` VALUES ('1826822167', '200万高清网络\n红外枪机', '1', null, '200万像素   1/2.8”CMOS，\n1920×1080，H.265，数字宽动态，镜头4mm，30米红外，智能分析，DC12V/POE供电，不含支架', '1', '台', '12', '1.00', '1.00', '1', '0', '0', '', '1565074093', null, '1', '0', '1', '1606093973919');
INSERT INTO `inquiry` VALUES ('1924170699', '枪机支架', null, null, '壁装支架/ 海康白/ 铝合金，\n尺寸70×97.1×181.8mm', null, '台', '12', '264.00', '22.00', '2', '1', '0', null, '1565074093', null, '1', '0', '1', '1605495105858');
INSERT INTO `inquiry` VALUES ('1966154724', '46寸高清监控专用显示器', '1', null, 'DS-D5046QD', '1', '台', '1', '3000.00', '3000.00', '4', '1', '1', '打回重新询价', '1565074093', null, '1', '0', '1', '1605583143829');
INSERT INTO `inquiry` VALUES ('2007901732', 'NVR硬盘录像机', '1', null, '2U标准机架式IP存储，嵌入式处理器，嵌入式软硬件设计；支持24路高清，256M带宽网络视频接入，256M网络带宽输出；支持8个SATA盘位；支持RAID0、1、5、6、10多种RAID模式及全局热备，多重保护数据安全；2个千兆以太网口等；配硬盘2个2T。', '1', '台', '1', null, null, '3', '1', '0', null, '1737005095', null, '1', '0', '1', '1605680943894');

-- ----------------------------
-- Table structure for inquiry_pool
-- ----------------------------
DROP TABLE IF EXISTS `inquiry_pool`;
CREATE TABLE `inquiry_pool` (
  `id` bigint(11) NOT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `equipment_name` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `technical_require` varchar(5000) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `quote_model` varchar(255) DEFAULT NULL,
  `technical_params` varchar(10000) DEFAULT NULL,
  `quote_brand` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `delivery` varchar(255) DEFAULT NULL,
  `warranty` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `pro_detail_id` bigint(20) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `operator` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inquiry_pool
-- ----------------------------

-- ----------------------------
-- Table structure for product_pool
-- ----------------------------
DROP TABLE IF EXISTS `product_pool`;
CREATE TABLE `product_pool` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '设材代码',
  `name` varchar(255) DEFAULT '' COMMENT '设备名',
  `brand` varchar(255) DEFAULT '' COMMENT '品牌',
  `supplier` varchar(255) DEFAULT '' COMMENT '供应商',
  `model` varchar(1000) DEFAULT '' COMMENT '设备型号',
  `params` varchar(1000) DEFAULT '' COMMENT '技术参数',
  `price` double(10,2) DEFAULT '0.00' COMMENT '供应商报价',
  `delivery` varchar(255) DEFAULT '' COMMENT '货期',
  `image` varchar(255) DEFAULT '',
  `quote` varchar(255) DEFAULT '' COMMENT '报价（销售单价）',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `purchase_date` bigint(20) DEFAULT NULL,
  `purchase_contract_no` varchar(255) DEFAULT NULL COMMENT '采购合同编号',
  `sale_contract_no` varchar(255) DEFAULT NULL COMMENT '销售合同编号',
  `pro_detail_id` bigint(20) DEFAULT NULL COMMENT '项目详情ID',
  `choose` int(11) DEFAULT '0' COMMENT '选用标识 1选用/0不选用',
  `is_active` int(255) DEFAULT NULL,
  `is_useful` int(255) DEFAULT NULL,
  `operator` bigint(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_pool
-- ----------------------------

-- ----------------------------
-- Table structure for quote
-- ----------------------------
DROP TABLE IF EXISTS `quote`;
CREATE TABLE `quote` (
  `id` bigint(40) NOT NULL COMMENT '主键',
  `supplier` varchar(255) DEFAULT NULL,
  `su_model` varchar(10000) DEFAULT NULL COMMENT '报价型号',
  `su_brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `su_params` varchar(10000) DEFAULT NULL COMMENT '报价参数',
  `su_price` double(20,2) DEFAULT NULL COMMENT '报价设备单价',
  `su_total_price` double(20,2) DEFAULT NULL COMMENT '报价设备总价',
  `su_delivery` varchar(255) DEFAULT '' COMMENT '货期',
  `warranty` varchar(255) DEFAULT '' COMMENT '质保期',
  `su_remark` varchar(255) DEFAULT NULL COMMENT '供应商备注',
  `image` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `data_source` int(11) DEFAULT NULL COMMENT '1外部数据/0产品池数据',
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
INSERT INTO `quote` VALUES ('110822450', 'test1', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '2950.00', '', '24个月', '', 'http://218.87.96.53:8006/images/d6f09c16-3836-45d0-bb75-a9012987371e.jpeg', '1', '1966154724', '0', '0', '1', '1605342907703');
INSERT INTO `quote` VALUES ('115792757', 'test4', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '2040.00', '', '24个月', '', 'http://218.87.96.53:8006/images/fe719957-52b7-45db-85f2-6a8dfef0f39f.jpeg', '1', '310007395', '0', '0', '1', '1605842552637');
INSERT INTO `quote` VALUES ('170513618', 'test1', 'DS-2CD2T25-I3', '海康威视', '200万 1/2.7\" CMOS ICR红外阵列筒型网络摄像机\n最低照度: 0.01 Lux @（F1.2，AGC ON），0 Lux with IR\n宽动态: 120 dB \n焦距&视场角:  \n4 mm @F2.0，水平视场角：87.2°，垂直视场角：46.2°，对角线视场角：104.8°\n6 mm @F2.0，水平视场角：53.9°，垂直视场角：28.8°，对角线视场角：62.8°\n8 mm @F1.6，水平视场角：40.9°，垂直视场角：22.5°，对角线视场角：47.4°\n12 mm @F1.6，水平视场角：25.4°，垂直视场角：14.4°，对角线视场角：29.1°\n红外距离: 最远可达30 m\n波长范围: 850 nm\n防补光过曝: 支持\n最大图像尺寸: 1920 × 1080\n视频压缩标准: 主码流：H.265/H.264\n网络存储: NAS（NFS，SMB/CIFS均支持）\n网络: 1个RJ45 10 M/100 M自适应以太网口\n存储温湿度: -30 ℃~60 ℃，湿度小于95%（无凝结）\n启动及工作温湿度: -30 ℃~60 ℃，湿度小于95%（无凝结）\n供电方式: DC：12 V ± 25%，支持防反接保护；PoE(802.3af)\n电流及功耗: DC：12 V，0.34 A，最大功耗：4 W；PoE：802.3af，36 V~57 V，0.13 A~0.08 A，最大功耗：5 W \n电源接口类型: Ø5.5 mm圆口\n产品尺寸: 194 × 93.9 × 93.5 mm\n包装尺寸: 235 × 120 × 125 mm\n设备重量: 750 g\n带包装重量: 870 g\n防护: IP67', '265.00', '3180.00', '', '24个月', '', 'http://218.87.96.53:8006/images/a43c19b2-bd21-45d7-a963-5c3224f4e7a8.jpeg', '1', '1611342730', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('186808124', 'test2', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '2950.00', '', '24个月', '', 'http://218.87.96.53:8006/images/007a7664-8298-4096-9859-e24ea74110a7.jpeg', '1', '1752310728', '0', '0', '1', '1605841518386');
INSERT INTO `quote` VALUES ('198346864', 'test1', '', '海康威视', 'HDMI电缆,15m,黑色', '600.00', '600.00', '', '12个月', '', '', '1', '1381828833', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('198857559', 'test3', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '2950.00', '', '24个月', '', 'http://218.87.96.53:8006/images/599bb5b1-04cd-43f7-aa1d-3d7f51f43a7f.jpeg', '1', '1752310728', '0', '0', '1', '1605842603817');
INSERT INTO `quote` VALUES ('234297497', 'test2', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '2440.00', '', '24个月', '', '', '1', '1537119181', '0', '0', '1', '1605841518386');
INSERT INTO `quote` VALUES ('388836054', 'test2', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '240.00', '', '24个月', '', 'http://218.87.96.53:8006/images/91a4af7a-bca1-4067-b66a-b3e7de3e7a92.jpeg', '1', '1924170699', '0', '0', '1', '1605841518386');
INSERT INTO `quote` VALUES ('413884602', 'test2', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1', '1711719106', '0', '0', '1', '1605841518386');
INSERT INTO `quote` VALUES ('415401120', 'test3', '', '海康威视', 'HDMI电缆,15m,黑色', '600.00', '600.00', '', '12个月', '', '', '1', '696644478', '0', '0', '1', '1605842603817');
INSERT INTO `quote` VALUES ('466145458', 'test1', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '2040.00', '', '24个月', '', 'http://218.87.96.53:8006/images/59f2e89f-47fe-4362-a457-419000ca3816.jpeg', '1', '310007395', '0', '0', '1', '1605342907703');
INSERT INTO `quote` VALUES ('616017958', 'test3', '', '海康威视', 'HDMI电缆,15m,黑色', '600.00', '600.00', '', '12个月', '', '', '1', '696644478', '1', '0', '1', '1606117454184');
INSERT INTO `quote` VALUES ('799523126', 'test3', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '240.00', '', '24个月', '', 'http://218.87.96.53:8006/images/0da3e7c8-1186-4f42-9a40-406fd1d327cd.jpeg', '1', '1924170699', '0', '0', '1', '1605842603817');
INSERT INTO `quote` VALUES ('834781366', 'test3', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '2040.00', '', '24个月', '', 'http://218.87.96.53:8006/images/6e96616c-76be-4b61-ab55-972739d79fe1.jpeg', '1', '310007395', '1', '0', '1', '1606117454184');
INSERT INTO `quote` VALUES ('846393932', 'test1', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '240.00', '', '24个月', '', 'http://218.87.96.53:8006/images/e39930db-a9f0-4843-afba-e1989a2a3d82.jpeg', '1', '801584492', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('1074293065', 'test1', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1', '1711719106', '0', '0', '1', '1605342907703');
INSERT INTO `quote` VALUES ('1126034733', 'test2', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '2040.00', '', '24个月', '', 'http://218.87.96.53:8006/images/6e44870e-c04e-4667-8eca-bba225a9719a.jpeg', '1', '310007395', '0', '0', '1', '1605841518386');
INSERT INTO `quote` VALUES ('1133302093', 'test4', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '2950.00', '', '24个月', '', 'http://218.87.96.53:8006/images/50286680-d6f5-47f7-87b3-1a9ccff29e79.jpeg', '1', '1752310728', '0', '0', '1', '1605842552637');
INSERT INTO `quote` VALUES ('1147751337', 'test3', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '2040.00', '', '24个月', '', 'http://218.87.96.53:8006/images/74736be7-f6ea-4791-9244-989f0b4b57e2.jpeg', '1', '310007395', '0', '0', '1', '1605842603817');
INSERT INTO `quote` VALUES ('1277693777', 'test3', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1', '1711719106', '1', '0', '1', '1606117454184');
INSERT INTO `quote` VALUES ('1320719020', 'test1', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '2440.00', '', '24个月', '', '', '1', '1020844082', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('1513642942', 'test1', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '2950.00', '', '24个月', '', 'http://218.87.96.53:8006/images/d5a5b83b-c042-47b5-a196-e4a65a893796.jpeg', '1', '280382064', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('1553669641', 'test3', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1', '1711719106', '0', '0', '1', '1605842603817');
INSERT INTO `quote` VALUES ('1563505204', 'test4', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1', '1711719106', '0', '0', '1', '1605842552637');
INSERT INTO `quote` VALUES ('1596470232', 'test3', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '2440.00', '', '24个月', '', '', '1', '1537119181', '0', '0', '1', '1605842603817');
INSERT INTO `quote` VALUES ('1723248167', 'test1', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '2040.00', '', '24个月', '', 'http://218.87.96.53:8006/images/2256067e-7c14-4638-93b6-d909837d8cb0.jpeg', '1', '2007901732', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('1795829205', 'test1', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '2440.00', '', '24个月', '', '', '1', '1537119181', '0', '0', '1', '1605342907703');
INSERT INTO `quote` VALUES ('1810263994', 'test1', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1', '989407068', '0', '0', '1', '1605681148466');
INSERT INTO `quote` VALUES ('1814639779', 'test3', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '240.00', '', '24个月', '', 'http://218.87.96.53:8006/images/5d3d7193-4993-4789-970d-88add46cafae.jpeg', '1', '1924170699', '1', '0', '1', '1606117454184');
INSERT INTO `quote` VALUES ('1846757526', 'test3', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '2440.00', '', '24个月', '', '', '1', '1537119181', '1', '0', '1', '1606117454184');
INSERT INTO `quote` VALUES ('1853027126', 'test3', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '2950.00', '', '24个月', '', 'http://218.87.96.53:8006/images/e15073f8-e607-4539-8d67-1a6d44fd053d.jpeg', '1', '591207456', '1', '0', '1', '1606117454184');
INSERT INTO `quote` VALUES ('1893625432', 'test2', '', '海康威视', 'HDMI电缆,15m,黑色', '600.00', '600.00', '', '12个月', '', '', '1', '696644478', '0', '0', '1', '1605841518386');
INSERT INTO `quote` VALUES ('1918953147', 'test1', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '240.00', '', '24个月', '', 'http://218.87.96.53:8006/images/27185962-f196-4107-b035-235e88f7ffc5.jpeg', '1', '1924170699', '0', '0', '1', '1605342907703');
INSERT INTO `quote` VALUES ('1968333688', 'test4', '', '海康威视', 'HDMI电缆,15m,黑色', '600.00', '600.00', '', '12个月', '', '', '1', '696644478', '0', '0', '1', '1605842552637');
INSERT INTO `quote` VALUES ('1980744683', 'test4', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '240.00', '', '24个月', '', 'http://218.87.96.53:8006/images/27e47a13-1d21-471d-a27b-40599bef10b3.jpeg', '1', '1924170699', '0', '0', '1', '1605842552637');
INSERT INTO `quote` VALUES ('2051658943', '1', '1', '', '1', '1.00', null, '1', null, '', '', '0', '1826822167', '0', '0', '1', '1605755760692');
INSERT INTO `quote` VALUES ('2060109227', 'test4', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '2440.00', '', '24个月', '', '', '1', '1537119181', '0', '0', '1', '1605842552637');
INSERT INTO `quote` VALUES ('2060475082', 'test1', '', '海康威视', 'HDMI电缆,15m,黑色', '600.00', '600.00', '', '12个月', '', '', '1', '696644478', '0', '0', '1', '1605342907703');

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
INSERT INTO `sys_file` VALUES ('32381243', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1929987896', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('50056872', 'c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', 'http://218.87.96.53:8006/images/c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', '3', '1563505204', '1', '1', '1', '1605842552637');
INSERT INTO `sys_file` VALUES ('56432523', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1653455753', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('66229753', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '2060475082', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('133730523', 'c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', 'http://218.87.96.53:8006/images/c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', '3', '115792757', '1', '1', '1', '1605842552637');
INSERT INTO `sys_file` VALUES ('148633591', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '2010732366', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('190789943', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '491903872', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('218727311', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '1810263994', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('230701664', 'c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', 'http://218.87.96.53:8006/images/c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', '3', '799523126', '1', '1', '1', '1605842603817');
INSERT INTO `sys_file` VALUES ('235115758', 'fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', 'http://218.87.96.53:8006/images/fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', '3', '1853027126', '1', '1', '1', '1606117454184');
INSERT INTO `sys_file` VALUES ('241150868', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '799489470', '1', '1', '1', '1605342288399');
INSERT INTO `sys_file` VALUES ('270542431', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '1911791959', '1', '1', '1', '1605342288399');
INSERT INTO `sys_file` VALUES ('278443916', 'c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', 'http://218.87.96.53:8006/images/c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', '3', '1968333688', '1', '1', '1', '1605842552637');
INSERT INTO `sys_file` VALUES ('308160515', '13e57268-35e5-4ed2-9098-8f459b0d024a.xls', 'http://218.87.96.53:8006/images/13e57268-35e5-4ed2-9098-8f459b0d024a.xls', '3', '1345377544', '1', '1', '1', '1604892194846');
INSERT INTO `sys_file` VALUES ('332878490', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '844467957', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('333763486', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1007956111', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('343204863', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '29707147', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('403013508', '9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', 'http://218.87.96.53:8006/images/9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', '3', '413884602', '1', '1', '1', '1605841518386');
INSERT INTO `sys_file` VALUES ('409843109', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '668352014', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('425724951', 'c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', 'http://218.87.96.53:8006/images/c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', '3', '415401120', '1', '1', '1', '1605842603817');
INSERT INTO `sys_file` VALUES ('426724966', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '1322319333', '1', '1', '1', '1605342288399');
INSERT INTO `sys_file` VALUES ('440046139', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '1513642942', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('445473769', '询价模板.xls', 'http://218.87.96.53:8006/images/b6e613d9-5da2-4a95-96f1-7fdabe2f33d6.xls', '0', '1737005095', '1', '1', '1', '1605680932083');
INSERT INTO `sys_file` VALUES ('446215638', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '421507167', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('483445112', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1277090124', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('486451148', '9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', 'http://218.87.96.53:8006/images/9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', '3', '186808124', '1', '1', '1', '1605841518386');
INSERT INTO `sys_file` VALUES ('489483375', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '2138136186', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('544497618', '9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', 'http://218.87.96.53:8006/images/9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', '3', '234297497', '1', '1', '1', '1605841518386');
INSERT INTO `sys_file` VALUES ('561236671', '新自信.txt', 'http://218.87.96.53:8006/images/e4472914-1cde-448a-84fa-087496d8683e.txt', '0', '1219561420', '1', '1', '1', '1605320071431');
INSERT INTO `sys_file` VALUES ('687872749', 'fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', 'http://218.87.96.53:8006/images/fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', '3', '1846757526', '1', '1', '1', '1606117454184');
INSERT INTO `sys_file` VALUES ('707795898', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1276397528', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('722635526', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1606359448', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('804255966', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '102301927', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('807563395', 'c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', 'http://218.87.96.53:8006/images/c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', '3', '1980744683', '1', '1', '1', '1605842552637');
INSERT INTO `sys_file` VALUES ('842123834', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1042197098', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('858012715', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '466145458', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('867206538', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '1723248167', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('872758879', '9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', 'http://218.87.96.53:8006/images/9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', '3', '1126034733', '1', '1', '1', '1605841518386');
INSERT INTO `sys_file` VALUES ('932774970', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '2133574226', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('936172384', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1973393708', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('940167458', 'c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', 'http://218.87.96.53:8006/images/c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', '3', '1553669641', '1', '1', '1', '1605842603817');
INSERT INTO `sys_file` VALUES ('981157501', 'fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', 'http://218.87.96.53:8006/images/fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', '3', '834781366', '1', '1', '1', '1606117454184');
INSERT INTO `sys_file` VALUES ('984905826', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '2017028571', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1012554348', 'c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', 'http://218.87.96.53:8006/images/c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', '3', '1133302093', '1', '1', '1', '1605842552637');
INSERT INTO `sys_file` VALUES ('1018523401', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1574033667', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1093111027', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1532483870', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1099881660', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '742317574', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1131093394', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '170513618', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('1167614825', 'fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', 'http://218.87.96.53:8006/images/fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', '3', '1277693777', '1', '1', '1', '1606117454184');
INSERT INTO `sys_file` VALUES ('1173376907', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '243472280', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1195503914', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '1320719020', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('1222797813', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1873675229', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1243132940', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '1995903149', '1', '1', '1', '1605342288399');
INSERT INTO `sys_file` VALUES ('1266043076', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '520236204', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1303751541', 'c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', 'http://218.87.96.53:8006/images/c6355853-0cc0-4f57-b8f9-38c2f4b19cbc.xls', '3', '2060109227', '1', '1', '1', '1605842552637');
INSERT INTO `sys_file` VALUES ('1306719744', 'fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', 'http://218.87.96.53:8006/images/fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', '3', '1814639779', '1', '1', '1', '1606117454184');
INSERT INTO `sys_file` VALUES ('1315072907', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '110822450', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('1324328596', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '1269989429', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1348537476', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '853876038', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1366908943', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '13204963', '1', '1', '1', '1605342288399');
INSERT INTO `sys_file` VALUES ('1386754752', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '134803518', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1389735154', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1088276707', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1415690207', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '435588006', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1449192638', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '846393932', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('1451876954', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '1606005763', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1465387069', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '1074293065', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('1493181999', 'c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', 'http://218.87.96.53:8006/images/c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', '3', '198857559', '1', '1', '1', '1605842603817');
INSERT INTO `sys_file` VALUES ('1494973960', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '561096163', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1553400687', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '41099127', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('1567885615', 'fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', 'http://218.87.96.53:8006/images/fa91e7c4-bacb-4c34-a646-4bf9ace184b6.xls', '3', '616017958', '1', '1', '1', '1606117454184');
INSERT INTO `sys_file` VALUES ('1588849536', '9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', 'http://218.87.96.53:8006/images/9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', '3', '388836054', '1', '1', '1', '1605841518386');
INSERT INTO `sys_file` VALUES ('1649056395', '750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', 'http://218.87.96.53:8006/images/750d62e4-6ac9-4f44-a1ec-5619f088aa32.xls', '3', '198346864', '1', '1', '1', '1605681148466');
INSERT INTO `sys_file` VALUES ('1686728322', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '1795829205', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('1692647630', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '415261060', '1', '1', '1', '1605342288399');
INSERT INTO `sys_file` VALUES ('1698375950', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1994092734', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1724841370', 'c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', 'http://218.87.96.53:8006/images/c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', '3', '1147751337', '1', '1', '1', '1605842603817');
INSERT INTO `sys_file` VALUES ('1775321293', 'c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', 'http://218.87.96.53:8006/images/c423ff59-32cf-4ac2-aa3c-b213f6e36615.xls', '3', '1596470232', '1', '1', '1', '1605842603817');
INSERT INTO `sys_file` VALUES ('1811631241', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '1503517772', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1840059713', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1169379670', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1845413575', '13e57268-35e5-4ed2-9098-8f459b0d024a.xls', 'http://218.87.96.53:8006/images/13e57268-35e5-4ed2-9098-8f459b0d024a.xls', '3', '1825942783', '1', '1', '1', '1604892194846');
INSERT INTO `sys_file` VALUES ('1869113122', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1449630645', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1931554401', '1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', 'http://218.87.96.53:8006/images/1f48de10-aabc-4770-81d8-f1ee9393c7d9.xls', '3', '1918953147', '1', '1', '1', '1605342907703');
INSERT INTO `sys_file` VALUES ('2027158034', '9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', 'http://218.87.96.53:8006/images/9fee51fc-3311-4a89-86c0-5a47acf1ee2d.xls', '3', '1893625432', '1', '1', '1', '1605841518386');
INSERT INTO `sys_file` VALUES ('2054569153', '469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', 'http://218.87.96.53:8006/images/469fba3d-d78e-4403-b93b-fa84e9d36a08.xls', '3', '966126653', '1', '1', '1', '1605342288399');

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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_privilege` VALUES ('47', '批量审核', 'method', '42', '', '/proCheck/updateTechnicalStatus', '', null, null, null, null);
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
INSERT INTO `sys_privilege` VALUES ('73', '查询项目详情审核', 'method', '18', null, '/project/detail/findProDetailCheck', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('74', '产品池管理', 'parent', null, 'star', '/pool/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('75', '产品池管理', 'menu', '74', '', '/pool/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('76', '产品池查询', 'method', '74', null, '/pool/findByParams', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('77', '根据设备名和型号查询历史单价', 'method', '74', null, '/pool/findHistoryPrices', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('78', '项目逻辑删除', 'method', '18', null, '/project/detail/setInvalid', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('79', '批量设置是否需要询价', 'method', '29', null, '/inquiry/batchSetIsNotInquiry', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('80', '查询技术审核', 'method', '42', null, '/proCheck/findTechnicalCheck', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('81', '查询商务审核', 'method', '42', null, '/proCheck/findBusinessCheck', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('82', '选用此条产品池数据', 'method', '29', null, '/inquiry/inquiryChoosePool', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('83', '终审拒绝询价（重新询价）', 'method', '42', null, '/finallyCheck/refuseInquiry', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('84', '首页', 'parent', null, null, '/sysIndex/list', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('85', '首页查询数据数量', 'method', '84', null, '/sysIndex/findProAndSupplier', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('86', '查询当前年份个月项目总数', 'method', '84', null, '/sysIndex/findYearPro', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('87', '查询当前年份个月供应商数', 'method', '84', null, '/sysIndex/findYearSupplier', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('88', '查询比价待办事项', 'method', '84', null, '/sysIndex/findCompareAuditDeal', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('89', '查询商务审核待办事项', 'method', '84', null, '/sysIndex/findBusinessAuditDeal', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('90', '查询技术审核待办事项', 'method', '84', null, '/sysIndex/findTechnicalAuditDeal', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('91', '查询终审待办事项', 'method', '84', null, '/sysIndex/findFinallyAuditDeal', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_pro_check
-- ----------------------------
DROP TABLE IF EXISTS `sys_pro_check`;
CREATE TABLE `sys_pro_check` (
  `id` bigint(40) NOT NULL COMMENT '项目审核编号',
  `technical_audit` int(10) DEFAULT NULL COMMENT '审核状态0初始值1通过2未通过',
  `business_audit` int(10) DEFAULT NULL,
  `compare_audit` int(10) DEFAULT NULL,
  `finally_audit` int(10) DEFAULT NULL COMMENT '终审状态',
  `technical_remark` varchar(5000) DEFAULT NULL COMMENT '技术审核备注',
  `business_remark` varchar(5000) DEFAULT NULL COMMENT '商务审核备注',
  `compare_remark` varchar(5000) DEFAULT NULL COMMENT '比价审核备注',
  `finally_remark` varchar(5000) DEFAULT NULL COMMENT '最终审核备注',
  `quote_id` bigint(40) DEFAULT NULL COMMENT '报价id',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_check
-- ----------------------------
INSERT INTO `sys_pro_check` VALUES ('5239631', '1', '1', '1', '0', '', '', '', '', '1853027126', '1', '1606185326357');
INSERT INTO `sys_pro_check` VALUES ('69320007', '0', '0', '0', '0', '', '', '', '', '1995903149', '1', '1605342288399');
INSERT INTO `sys_pro_check` VALUES ('74945580', '0', '0', '0', '0', '', '', '', '', '13204963', '1', '1605342288399');
INSERT INTO `sys_pro_check` VALUES ('197745161', '1', '1', '1', '0', '', '', '', '', '616017958', '1', '1606185326357');
INSERT INTO `sys_pro_check` VALUES ('253442187', '0', '0', '0', '0', '', '', '', '', '415261060', '1', '1605342288399');
INSERT INTO `sys_pro_check` VALUES ('426628395', '0', '0', '0', '0', '', '', '', '', '966126653', '1', '1605342288399');
INSERT INTO `sys_pro_check` VALUES ('476578984', '1', '1', '1', '0', '', '', '', '', '834781366', '1', '1606185326357');
INSERT INTO `sys_pro_check` VALUES ('750342553', '1', '1', '0', '1', '', '', '', '', '29827496', '1', '1605581791490');
INSERT INTO `sys_pro_check` VALUES ('830404332', '0', '0', '0', '0', '', '', '', '', '1322319333', '1', '1605342288399');
INSERT INTO `sys_pro_check` VALUES ('1127161074', '0', '0', '0', '0', '', '', '', '', '799489470', '1', '1605342288399');
INSERT INTO `sys_pro_check` VALUES ('1184294747', '1', '1', '1', '0', '', '', '', '', '1814639779', '1', '1606185326357');
INSERT INTO `sys_pro_check` VALUES ('1604917410', '1', '1', '1', '0', '', '', '', '', '1846757526', '1', '1606185326357');
INSERT INTO `sys_pro_check` VALUES ('1745244597', '1', '1', '1', '0', '', '', '', '', '1277693777', '1', '1606185326357');
INSERT INTO `sys_pro_check` VALUES ('1826471784', '0', '0', '0', '0', '', '', '', '', '1911791959', '1', '1605342288399');

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
  `pro_rate` int(11) DEFAULT NULL COMMENT '项目利率',
  `is_active` int(10) DEFAULT NULL COMMENT '是否有效',
  `is_useful` int(10) DEFAULT NULL COMMENT '是否被使用',
  `operator` bigint(40) DEFAULT NULL COMMENT '操作者',
  `time` bigint(40) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pro_detail
-- ----------------------------
INSERT INTO `sys_pro_detail` VALUES ('1219561420', '1', null, '1', '2033344962', '1996166487', '10000', '0', '0', '1', '1605320071431');
INSERT INTO `sys_pro_detail` VALUES ('1565074093', '双林视频', null, null, '2033344962', '1996166487', '10000', '1', '0', '1', '1604541553758');
INSERT INTO `sys_pro_detail` VALUES ('1737005095', 'pp', null, null, '2033344962', '1996166487', null, '1', '0', '1', '1605680932083');

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
INSERT INTO `sys_pro_origin` VALUES ('1996166487', '双林', null, '0', null, null, null);

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
INSERT INTO `sys_pro_type` VALUES ('2033344962', '设材招标', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '', null, null, null, null);
INSERT INTO `sys_role` VALUES ('2', 'test', null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('3', '技术部', '技术审核', null, null, null, null);
INSERT INTO `sys_role` VALUES ('4', '市场部', '商务审核', null, null, null, null);
INSERT INTO `sys_role` VALUES ('5', '经营部长', '最终审核', null, null, null, null);
INSERT INTO `sys_role` VALUES ('6', '询价员', null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('7', '采购员', '', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_role_privilege` VALUES ('100', '1', '73', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('101', '1', '75', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('102', '1', '76', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('103', '6', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('104', '6', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('105', '6', '19', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('106', '6', '21', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('107', '6', '22', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('108', '6', '30', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('109', '6', '31', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('110', '6', '33', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('111', '6', '35', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('112', '6', '59', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('113', '6', '62', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('114', '6', '64', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('115', '6', '65', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('116', '6', '68', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('117', '6', '38', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('118', '6', '39', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('119', '6', '54', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('120', '6', '61', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('121', '6', '63', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('122', '6', '66', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('123', '6', '67', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('124', '6', '69', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('125', '6', '70', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('126', '6', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('127', '6', '23', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('128', '6', '24', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('129', '6', '25', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('130', '6', '26', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('131', '6', '27', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('132', '6', '28', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('133', '6', '32', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('134', '6', '36', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('135', '6', '40', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('136', '6', '71', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('137', '6', '73', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('138', '6', '41', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('139', '7', '4', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('140', '7', '5', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('141', '7', '34', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('142', '7', '49', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('143', '7', '50', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('144', '7', '51', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('145', '7', '52', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('146', '7', '53', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('147', '7', '72', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('148', '7', '23', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('149', '7', '24', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('150', '7', '25', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('151', '7', '26', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('152', '7', '27', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('153', '7', '28', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('154', '7', '32', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('155', '7', '36', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('156', '7', '40', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('157', '7', '71', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('158', '7', '73', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('159', '1', '77', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('160', '1', '78', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('161', '1', '79', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('162', '1', '80', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('163', '1', '81', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('164', '1', '82', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('165', '1', '83', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('166', '1', '85', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('167', '1', '86', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('168', '1', '87', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('169', '1', '88', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('170', '1', '89', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('171', '1', '90', null, null, null, null);
INSERT INTO `sys_role_privilege` VALUES ('172', '1', '91', null, null, null, null);

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
INSERT INTO `sys_user` VALUES ('1', 'admin', '000000', 'http://218.87.96.53:8006/images/06bad62a-4349-466a-9afb-a11d9d2f6d98.png', null, null, null, null);
INSERT INTO `sys_user` VALUES ('89295052', '工程技术部1', '000000', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('223683013', '工程技术部3', '000000', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('785396804', '采购员', '000000', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('1179189554', '技术部长', '000000', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('1350049205', '经营部长', '000000', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2002639401', '询价员', '000000', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('2065789527', '工程技术部2', '000000', null, null, null, null, null);
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('4', '160033564240903', '2', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('6', '160069265124036', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('8', '2002639401', '6', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('10', '785396804', '7', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('12', '1350049205', '5', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('14', '89295052', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('16', '1179189554', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('18', '2065789527', '3', null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('20', '223683013', '3', null, null, null, null);
