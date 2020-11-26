/*
Navicat MySQL Data Transfer

Source Server         : 新自信
Source Server Version : 50731
Source Host           : 10.70.0.113:3306
Source Database       : xzx

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-26 11:11:34
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
INSERT INTO `inquiry` VALUES ('10327658', '隔爆型超声波流量计变送器', null, null, null, 'FT-44201', '台', '1', null, null, '2', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('35900053', '初冷器脱硫液流量A~G', null, null, '隔爆型电磁流量计（附配对法兰，材质：20号碳钢', 'FT-41208A~G', '台', '7', null, null, '9', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('40978328', '枪机支架', null, null, '壁装支架/ 海康白/ 铝合金，\n尺寸70×97.1×181.8mm', null, '台', '12', null, null, '2', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('50801435', '隔爆型一体化电磁流量计（附配对法兰，材质20碳钢）', null, null, '0~130m³/h', 'FT -42403', '台', '1', null, null, '5', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('80202480', '隔爆型雷达液位计（附安装法兰。材质316L）', null, null, '0~3.0m', 'LT-42302ABC', '台', '3', null, null, '14', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('107928396', '隔爆型导波雷达液位变送器（附配对法兰，材质：碳钢）', null, null, '0.1~1.80m（L=1950mm）', 'LT-41204', '台', '1', null, null, '7', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('116725166', '24口机架式ODF箱', null, null, '24口LC/ LC满配', null, '台', '1', null, null, '7', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('128575357', 'NVR硬盘录像机', null, null, '2U标准机架式IP存储，嵌入式处理器，嵌入式软硬件设计；支持24路高清，256M带宽网络视频接入，256M网络带宽输出；支持8个SATA盘位；支持RAID0、1、5、6、10多种RAID模式及全局热备，多重保护数据安全；2个千兆以太网口等；配硬盘2个2T。', null, '台', '1', null, null, '3', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('272019467', '高清视频线', null, null, 'HDMI高清视频线，10米', null, '根', '1', null, null, '12', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('276751886', '隔爆型超声波流量计转换器', null, null, null, 'FT-44310', '台', '1', null, null, '14', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('284802812', '一体化节流装置（附三阀组，配对法兰，材质20号钢）', null, null, '0~16t/h 参考差压： 60kPa', 'FT-85107~FT-85128', '台', '22', null, null, '17', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('292642722', '隔爆型金属转子流量计、附蒸汽夹套（附配对法兰，法兰材质：20号钢）', null, null, '0~0.6m3/h', 'FT-44311A.B', '套', '2', null, null, '2', null, '1086813908', null, '1', '0', '1', '1605251027838');
INSERT INTO `inquiry` VALUES ('314161871', '风机轴承冷却水流量', null, null, '一体化电磁流量计（附配对法兰，法兰材质碳钢', 'FT-29301', '台', '1', null, null, '3', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('335431274', '风机轴承冷却水流量', null, null, '一体化电磁流量计（附配对法兰，法兰材质碳钢)', 'FT-29701', '台', '1', null, null, '8', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('359065149', '隔爆型导波雷达液位变送器（附配对法兰，材质：碳钢）', null, null, '0.1~1.8m（L=1950mm）', 'LT-41603', '台', '1', null, null, '8', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('375305860', '隔爆型导波雷达液位计（附配对法兰，法兰材质Q235B）', null, null, '-6.5~0m', 'LT-09303', '台', '1', null, null, '18', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('380791151', '循环冷却水流量指示', null, null, '一体化电磁流量计（配对法兰，材质Q235B）', 'FT-85101', '台', '1', null, null, '13', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('385622034', '200万高清网络\n红外枪机', null, null, '200万像素   1/2.8”CMOS，\n1920×1080，H.265，数字宽动态，镜头4mm，30米红外，智能分析，DC12V/POE供电，不含支架', null, '台', '12', null, null, '1', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('390723651', '隔爆型插入式超声波流量计传感器', null, null, '0~400m3/h', 'FE-41202A~G', '台', '7', null, null, '9', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('393277187', '标准机柜', null, null, '600×2000×600', null, '台', '1', null, null, '6', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('413468409', '隔爆型一体化喷嘴流量计（附安装法兰，材质20碳钢)', null, null, '0~20t/h     参考差压：16KPa', 'FT- 42401', '台', '1', null, null, '1', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('422975778', '上段循环喷洒液流量', null, null, '隔爆型一化电磁流量计（附配对法兰，材质20#碳钢）', 'FT-44203', '台', '1', null, null, '1', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('450687701', '隔爆型一体化喷嘴流量计(附安装法兰，法兰材质:20号 钢，三阀组）', null, null, '0~15t/h  参考差压：25KPa', 'FT-44306', '台', '1', null, null, '9', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('469436123', '隔爆型一体化电磁流量计（附配对法兰，材质20#钢）', null, null, '0~2.5m3/h', 'FT-42301A~B', '台', '2', null, null, '11', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('473370854', '隔爆型导波雷达液位变送器（附配对法兰，材质：碳钢）', null, null, '0.1~2.40m（L=2550mm，缆式）', 'LT-41203', '台', '2', null, null, '6', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('477920876', '隔爆型导波雷达液位计（附配对法兰，法兰材质Q235B）', null, null, '-6.5~0m', 'LT-09304', '台', '1', null, null, '19', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('507895573', '一体化电磁流量计（配对法兰，材质Q235B）', null, null, '0~15m3/h a', 'FT-85101', '台', '1', null, null, '13', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('516938557', '导液雷达液位计（附配对法兰，材质Q235B', null, null, '0.15~2.4m（L=2550mm，缆式）', 'LT- 43401', '台', '1', null, null, '4', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('535505829', '隔爆型导波雷达液位计（附配对法兰，法兰材质Q235B）', null, null, '-6.5~0m', 'LT-09302', '台', '1', null, null, '17', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('539557346', '隔爆型雷达液位计（附安装法兰。材质316L）', null, null, '0~2.5m', 'LT-42303', '台', '1', null, null, '15', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('551667922', '入水解反应器脱硫废水流量', null, null, '隔爆型电磁流量计（附配对法兰，隔爆密封接头，材质：S31603）', 'FT-43401', '台', '1', null, null, '7', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('551713196', '一体化孔板流量计(附安装法兰，三法兰，法兰材质:S30408)', null, null, '0~33t/h  参考差压：25KPa', 'FT-85201', '台', '1', null, null, '13', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('604816214', '隔爆型插入式超声波流量计变送器', null, null, null, 'FT-41202A~G', '台', '7', null, null, '10', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('631779582', '隔爆型一体化喷嘴流量计（附安装法兰，材质20碳钢）', null, null, '0~1.1t/h参考差压：25kPa', 'FT-43403', '台', '1', null, null, '3', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('637487671', '隔爆型插入式超声波流量计变送器', null, null, null, 'FT-41201A~G', '台', '7', null, null, '8', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('658824594', '下段循环喷洒液流量', null, null, '隔爆型一化电磁流量计（附配对法兰，材质20#碳钢）', 'FT-44204', '台', '1', null, null, '2', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('662117149', '隔爆型金属转子流量计（附配对法兰，法兰材质：20号碳钢）', null, null, '4~40m3/h(标况）', 'FT-41301A~M', '套', '13', null, null, '1', null, '1086813908', null, '1', '0', '1', '1605251027838');
INSERT INTO `inquiry` VALUES ('677715345', '隔爆型超声波流量计转换器', null, null, null, 'FT-44312', '台', '1', null, null, '16', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('701588379', '隔爆型插入式超声波流量计传感器', null, null, '0~100m3/h', 'FE-44310', '台', '1', null, null, '13', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('768552499', '一体化电磁流量计（附配对法兰，法兰材质碳钢)', null, null, '0~7m3/h', 'FT-29701', '台', '1', null, null, '8', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('804106825', '隔爆型插入式超声波流量计传感器', null, null, '0~1000m³/h', 'FT-29301', '台', '1', null, null, '3', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('812758623', '隔爆型导波雷达液位计（附配对法兰，材质Q235B)', null, null, '0.1~1.8m （L=1950mm）', 'LT-44206', '台', '1', null, null, '2', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('830056662', '隔爆型导波雷达液位计（附配对法兰，材质Q235B)', null, null, '0.1~1.8m （L=1950mm）', 'LT-44204', '台', '1', null, null, '1', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('841836150', '隔爆型导波雷达液位计', null, null, '0.1m~2.3m（L=2450mm，缆式）', 'LT-44309', '台', '1', null, null, '11', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('852588290', '去焦炉喷洒循环氨水流量A~B', null, null, '隔爆型电磁流量计（附配对法兰，材质：20号碳钢', 'FT-41401A~B', '台', '2', null, null, '10', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('855721313', '隔爆型一体化孔板流量计(附安装法兰，法兰材质:20号 钢，三阀组）', null, null, '0~60m3/h  参考差压：25KPa', 'FT-44303', '台', '1', null, null, '8', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('892939026', '入排气洗净塔工业水流量', null, null, '隔爆型一体化电磁流量计（附配对法兰，材质20#钢）', 'FT-42301A~B', '台', '2', null, null, '11', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('896592167', '隔爆型导波雷达液位计', null, null, '0.1m~1.4m（L=1550mm）', 'LT-44310', '台', '1', null, null, '12', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('900406543', '隔爆型一体化喷嘴流量计（附安装法兰，材质20碳钢）', null, null, '0~1.1t/h参考差压：25kPa', 'FT-43402', '台', '1', null, null, '2', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('903821087', '交换机', null, null, '24个10/100Base-TX以太网端口，\n24个10/100/1000Base-TX以太网口，2个复用的千兆ComboSFP、POE+，含电源', null, '台', '1', null, null, '4', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('917910880', '隔爆型一体化电磁流量计（附配对法兰，材质：Q235B)', null, null, '0~130m³/h', 'FT- 42402', '台', '1', null, null, '4', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('935695097', '隔爆型导波雷达液位计（附配对法兰，法兰材质Q235B）', null, null, '-6.5~0m', 'LT-09301', '台', '1', null, null, '16', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('988217602', '46寸高清监控专用显示器', null, null, 'DS-D5046QD', null, '台', '1', null, null, '5', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('1046484894', '隔爆型一体化喷嘴流量计', null, null, '0~1.6t/h参考差压：16KPa', 'FT-46201A~B', '台', '2', null, null, '4', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1059345524', '去脱硫的蒸氨废水流量', null, null, '隔爆型一体化电磁流量计（附配对法兰，材质20碳钢）', 'FT- 42404', '台', '1', null, null, '6', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('1084355091', '隔爆型插入式超声波流量计传感器', null, null, '0~1000m³/h', 'FE-44201', '台', '1', null, null, '1', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1107649332', '隔爆型一体化孔板流量计(附安装法兰，法兰材质:20号钢，三阀组）', null, null, '0~30m3/h  参考差压：16KPa', 'FT-44302', '台', '1', null, null, '7', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1110334821', '入蒸氨塔的剩余氨水流量', null, null, '隔爆型一体化电磁流量计（附配对法兰，材质20碳钢）', 'FT -42403', '台', '1', null, null, '5', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('1131782101', '隔爆型一体化测管式流量计（附安装附件，吹扫阀，过程隔离阀，三阀组）（可在线插拔）', null, null, '0~6500m3/h(标况）参考差压：382pa', 'FT-44313', '台', '1', null, null, '1', null, '1612620762', null, '1', '1', '1', '1605494401658');
INSERT INTO `inquiry` VALUES ('1151668027', '隔爆型超声波流量计转换器', null, null, null, 'FT-44318', '台', '1', null, null, '18', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1177787684', '隔爆型超声波流量计变送器', null, null, null, 'FT- 42405', '台', '1', null, null, '6', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1182401972', 'PDU插座', null, null, '10孔', null, '个', '2', null, null, '8', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('1210064803', '隔爆型插入式超声波流量计传感器', null, null, '0~1500m3/h', 'FE-41201A~G', '台', '7', null, null, '7', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1222958178', '硬盘录像机硬盘', null, null, '4T', null, '块', '4', null, null, '10', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('1235119527', '隔爆型一体化孔板流量计(附安装法兰，法兰材质:20号 钢，三阀组）', null, null, '0~8m3/h  参考差压：16KPa', 'FT-44309', '台', '1', null, null, '10', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1297950155', '隔爆型一化电磁流量计（附配对法兰，材质20#碳钢）', null, null, '0~900m³/h', 'FT-44204', '台', '1', null, null, '2', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1344066359', '隔爆型超声波流量计变送器', null, null, null, 'FT- 42402', '台', '1', null, null, '4', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1345872804', '单模POE视频光端机', null, null, '1个FC光口，8个RJ45电口', null, '对', '2', '100010.00', '10001.00', '9', null, '1565074093', null, '1', '1', '1', '1605160724256');
INSERT INTO `inquiry` VALUES ('1357175567', '隔爆型一体化喷嘴流量计(附配对法兰，材质:20#钢', null, null, '0~7.5t/h  参考差压：25KPa', 'FT-42303', '台', '1', null, null, '11', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1396600926', '视频控制箱', null, null, '不锈钢材质，\n出线孔：6个（G-3/4内螺纹）\n外形尺寸：376*362*161mm\n内部尺寸：ø234*127\n安装孔尺寸：4-ø8.5mm', null, '个', '2', null, null, '11', null, '1565074093', null, '1', '1', '1', '1604652893431');
INSERT INTO `inquiry` VALUES ('1397916690', '隔爆型电磁流量计（附配对法兰，隔爆密封接头，材质：S31603）', null, null, '0~3m³/h', 'FT-43401', '台', '1', null, null, '7', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1419737779', '隔爆型电磁流量计（附配对法兰，材质：20号碳钢', null, null, '0~3000m3/h', 'FT-41401A~B', '台', '2', null, null, '10', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1442404622', '隔爆型一化电磁流量计（附配对法兰，材质20#碳钢）', null, null, '0~900m³/h', 'FT-44203', '台', '1', null, null, '1', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1462877177', '隔爆型导波雷达液位计', null, null, '0.1~1.8m（L=1950mm）', 'LT-44304', '台', '1', null, null, '9', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('1487950165', '隔爆型一体化测管式流量计（附安装附件，吹扫阀，过程隔离阀，三阀组）（可在线拔插）', null, null, '0~30000m3/h(标况）参考差压：462.6pa', 'FT-44317', '台', '1', null, null, '2', null, '1612620762', null, '1', '1', '1', '1605494401658');
INSERT INTO `inquiry` VALUES ('1574360258', '一体化喷嘴流量计(附安装法兰，三法兰，法兰材质:20# 钢)', null, null, '0~6t/h  参考差压：60KPa', 'FT-85202', '台', '1', null, null, '14', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1685570474', '一体化电磁流量计（附配对法兰，法兰材质碳钢', null, null, '0~7m3/h', 'FT-29301', '台', '1', null, null, '3', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1764724070', '隔爆型一体化喷嘴流量计（附三阀组，安装法兰，法兰材质：20号碳钢', null, null, '0~1.7t/h  参考差压：6kPa', 'FT-41402', '台', '1', null, null, '5', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1805600948', '至酚氰废水处理站的蒸氨废水流量', null, null, '隔爆型一体化电磁流量计（附配对法兰，材质：Q235B)', 'FT- 42402', '台', '1', null, null, '4', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('1830658311', '隔爆型插入式超声波流量计', null, null, '0~1300m³/h', 'FE- 42405', '台', '1', null, null, '5', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1833096638', '隔爆型插入式超声波流量计传感器', null, null, '0~500m3/h', 'FE-44312', '台', '1', null, null, '15', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1836663275', '隔爆型插入式超声波流量计传感器', null, null, '0~1500m3/h', 'FE-44318', '台', '1', null, null, '17', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1852395390', '一体化节流装置（（附配对法兰，材质20号钢）', null, null, '0~16t/h 参考差压： 16kPa', 'FT-85104 FT-85105', '台', '2', null, null, '16', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1859025821', '隔爆型导波雷达液位计（附配对法兰，材质Q235B', null, null, '0.1~1.8m（L=1950mm）', 'LT-46201', '台', '1', null, null, '5', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('1898979747', '隔爆型电磁流量计（附配对法兰，材质：20号碳钢', null, null, '0~600m3/h', 'FT-41208A~G', '台', '7', null, null, '9', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1912468511', '隔爆型雷达液位计（附安装法兰。材质316L）', null, null, '0~2.6m', 'LT-42301ABC', '台', '3', null, null, '13', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('1915298181', '隔爆型一体化电磁流量计（附配对法兰，材质20碳钢）', null, null, '0~10m³/h', 'FT- 42404', '台', '1', null, null, '6', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('1948511550', '一体化节流装置（（附配对法兰，材质20号钢）', null, null, '0~30t/h 参考差压：40kPa', 'FT-85102 FT-85103', '台', '2', null, null, '15', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1959038803', '隔爆型一体化喷嘴流量计(附安装法兰，法兰材质:20#钢', null, null, '0~2.8t/h  参考差压：25KPa', 'FT-42304ABC', '台', '3', null, null, '12', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('1983842306', '隔爆型插入式超声波流量计传感器', null, null, '0~500m3/h', 'FE-44308', '台', '1', null, null, '11', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('1987954080', '隔爆型一体化喷嘴流量计（附安装法兰，法兰材质：15CrMoG,三阀组）', null, null, '0~15t/h  参考差压：40KPa', 'FT-44301', '台', '1', null, null, '6', null, '527006379', null, '1', '0', '1', '1605498592905');
INSERT INTO `inquiry` VALUES ('2037024851', '隔爆型超声波流量计转换器', null, null, null, 'FT-44308', '台', '1', null, null, '12', null, '1734108387', null, '1', '0', '1', '1605496376705');
INSERT INTO `inquiry` VALUES ('2050291293', '隔爆型导波雷达液位计（附配对法兰，材质Q235B)', null, null, '0.15~1.8m（L=1950mm）', 'LT -42402', '台', '1', null, null, '3', null, '1598348928', null, '0', '0', '1', '1605498093729');
INSERT INTO `inquiry` VALUES ('2108507849', '入饱和器硫酸流量', null, null, '隔爆型一体化电磁流量计（附配对法兰，材质20#钢）', 'FT-42302A~BC', '台', '3', null, null, '12', null, '1903687057', null, '0', '0', '1', '1605250213824');
INSERT INTO `inquiry` VALUES ('2125085809', '隔爆型一体化电磁流量计（附配对法兰，材质20#钢）', null, null, '0~4.0m3/h', 'FT-42302A~BC', '台', '3', null, null, '12', null, '1903687057', null, '1', '0', '1', '1605250941941');
INSERT INTO `inquiry` VALUES ('2144814097', '隔爆型导波雷达液位计', null, null, '0.1~1.8m（L=1950mm）', 'LT-44305', '台', '1', null, null, '10', null, '1598348928', null, '0', '0', '1', '1605498093729');

-- ----------------------------
-- Table structure for product_pool
-- ----------------------------
DROP TABLE IF EXISTS `product_pool`;
CREATE TABLE `product_pool` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '设备名',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `model` varchar(10000) DEFAULT NULL COMMENT '设备型号',
  `params` varchar(10000) DEFAULT NULL COMMENT '技术参数',
  `price` double(10,0) DEFAULT NULL COMMENT '供应商报价',
  `delivery` varchar(255) DEFAULT '' COMMENT '货期',
  `quote` varchar(255) DEFAULT NULL COMMENT '拟定报价',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `pro_detail_id` bigint(20) DEFAULT NULL COMMENT '项目详情ID',
  `choose` int(11) DEFAULT NULL COMMENT '选用标识 1是选用/0是未选用',
  `is_active` int(255) DEFAULT NULL,
  `is_useful` int(255) DEFAULT NULL,
  `operator` bigint(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_pool
-- ----------------------------
INSERT INTO `product_pool` VALUES ('543647493', '单模POE视频光端机', null, '海康威视', '无POE', '', '0', '', null, '', null, null, '1', '0', '1', '1605162976753');
INSERT INTO `product_pool` VALUES ('1139731757', '24口机架式ODF箱', null, '长金', '', '', '520', '', null, '', null, null, '1', '0', '1', '1605162976753');
INSERT INTO `product_pool` VALUES ('1248190426', '单模POE视频光端机', null, '海康威视', '无POE', '', '0', '', null, '', null, null, '1', '0', '1', '1605143641400');

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
INSERT INTO `quote` VALUES ('29707147', '淙顺', 'H-PDU-1010G', '厚德揽胜', '', '210.00', '420.00', '', '', '', '', '1182401972', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('102301927', '长金', '', '', '', '0.00', '0.00', '', '', '没有', '', '1345872804', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('134803518', '长金', 'DS-8632N-K8', '海康威视', '', '2185.00', '2185.00', '', '', '', '', '128575357', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('243472280', '淙顺', '', '', '', '0.00', '0.00', '', '', '', '', '1396600926', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('421507167', '海康威视', '', '海康威视', 'HDMI电缆,15m,黑色', '420.00', '0.00', '', '12个月', '', '', '272019467', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('435588006', '新顺', 'HKN-HD1410', '广东海康', '', '70.00', '70.00', '', '', '', '', '272019467', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('491903872', '海康威视', 'DS-1292ZJ', '海康威视', '壁装支架/海康白/铝合金/尺寸70×97.1×173.4mm', '20.00', '0.00', '', '24个月', '', 'http://218.87.96.53:8006/images/4ac1b75b-98fc-4c17-8810-0ef0b3e195a1.jpeg', '40978328', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('520236204', '淙顺', '希捷 ST4000VX005', '希捷', '', '620.00', '2480.00', '', '', '', '', '1222958178', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('561096163', '长金', '8位', '国产', '8位10A防雷PDU', '105.00', '210.00', '', '', '10位的不能横装,只能竖装，比较占机柜空间，一般不适用', '', '1182401972', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('668352014', '新顺', 'DS-2CD2T25-I3', '海康威视', '', '315.00', '3780.00', '', '', '', '', '385622034', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('731148490', '思量', 'HGPF-A3G800P6S1Z/CS/XM', '思量', '', '21480.00', '21480.00', '', '', '', '', '1487950165', '1', '0', '1', '1605494931341');
INSERT INTO `quote` VALUES ('742317574', '长金', 'UP330GD', '优力普', '', '1350.00', '1350.00', '', '', '', '', '903821087', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('844467957', '新顺', '定做', '广东海康', '', '450.00', '900.00', '', '', '', '', '1345872804', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('853876038', '新顺', 'DS-8632N-K8 ', '海康威视', '', '2200.00', '2200.00', '', '', '', '', '128575357', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('1007956111', '淙顺', 'GMA-ODF24LC', '光训', '', '275.00', '275.00', '', '', '', '', '116725166', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('1042197098', '新顺', 'S5024Pv3-EI-PWR', 'H3C', '', '1850.00', '1850.00', '', '', '', '', '903821087', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('1088276707', '长金', 'DS-2CD2T25-I3', '海康威视', '', '285.00', '3420.00', '', '', '', '', '385622034', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('1169379670', '淙顺', 'GMA-G24G2T', '光训', '', '1850.00', '1850.00', '', '', '', '', '903821087', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('1269989429', '海康威视', 'DS-2CD2T25-I3', '海康威视', '200万 1/2.7\" CMOS ICR红外阵列筒型网络摄像机\n最低照度: 0.01 Lux @（F1.2，AGC ON），0 Lux with IR\n宽动态: 120 dB \n焦距&视场角:  \n4 mm @F2.0，水平视场角：87.2°，垂直视场角：46.2°，对角线视场角：104.8°\n6 mm @F2.0，水平视场角：53.9°，垂直视场角：28.8°，对角线视场角：62.8°\n8 mm @F1.6，水平视场角：40.9°，垂直视场角：22.5°，对角线视场角：47.4°\n12 mm @F1.6，水平视场角：25.4°，垂直视场角：14.4°，对角线视场角：29.1°\n红外距离: 最远可达30 m\n波长范围: 850 nm\n防补光过曝: 支持\n最大图像尺寸: 1920 × 1080\n视频压缩标准: 主码流：H.265/H.264\n网络存储: NAS（NFS，SMB/CIFS均支持）\n网络: 1个RJ45 10 M/100 M自适应以太网口\n存储温湿度: -30 ℃~60 ℃，湿度小于95%（无凝结）\n启动及工作温湿度: -30 ℃~60 ℃，湿度小于95%（无凝结）\n供电方式: DC：12 V ± 25%，支持防反接保护；PoE(802.3af)\n电流及功耗: DC：12 V，0.34 A，最大功耗：4 W；PoE：802.3af，36 V~57 V，0.13 A~0.08 A，最大功耗：5 W \n电源接口类型: Ø5.5 mm圆口\n产品尺寸: 194 × 93.9 × 93.5 mm\n包装尺寸: 235 × 120 × 125 mm\n设备重量: 750 g\n带包装重量: 870 g\n防护: IP67', '265.00', '0.00', '', '24个月', '', 'http://218.87.96.53:8006/images/5208899a-d0de-4a21-93a1-efc31c6bf73c.jpeg', '385622034', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('1276397528', '长金', 'DS-D5043UQ', '海康威视', '', '1588.00', '1588.00', '', '', '', '', '988217602', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('1277090124', '新顺', 'HKN-OD24T', '广东海康', '', '360.00', '360.00', '', '', '', '', '116725166', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('1345377544', '光大', '不锈钢材质，\n出线孔：6个（G-3/4内螺纹）\n外形尺寸：376*362*161mm\n内部尺寸：ø234*127\n安装孔尺寸：4-ø8.5mm', '定制', '', '245.00', '490.00', '', '', '', '', '1396600926', '1', '1', '1', '1604892194846');
INSERT INTO `quote` VALUES ('1449630645', '淙顺', 'HDP101', '绿联', '', '90.00', '90.00', '', '', '', '', '272019467', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('1503517772', '海康威视', 'DS-8632NX-K8', '海康威视', '硬件规格：\n2U标准机架式\n2个HDMI，2个VGA，HDMI1和VGA1同源，HDMI2和VGA2同源，组间异源\n8盘位，可满配8T硬盘\n2个千兆网口\n2个USB2.0接口、1个USB3.0接口\n1个eSATA接口\n报警IO：16进4出（选配16进8出）\n\n软件性能：\n输入带宽：256Mbps\n32路H.264、H.265混合接入\n最大支持8×1080P解码\n支持H.265、H.264解码\nSmart 2.0/ANR/智能检索/智能回放/车牌检索/人脸检索/热度图/客流量统计/分时段回放/超高倍速回放/双系统备份', '2040.00', '0.00', '', '24个月', '', 'http://218.87.96.53:8006/images/c72bb707-7c87-4403-a1b0-18c115d2d5cc.jpeg', '128575357', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('1532483870', '长金', '42U豪华', '国产', '600*600*2000', '750.00', '750.00', '', '', '', '', '393277187', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('1574033667', '新顺', 'DS-D5043UQ ', '海康威视', '', '1830.00', '1830.00', '', '', '', '', '988217602', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('1606005763', '海康威视', '无POE', '', '', '0.00', '0.00', '', '', '', '', '1345872804', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('1606359448', '淙顺', 'GMA-1F5208F', '光训', '', '490.00', '980.00', '', '', '', '', '1345872804', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('1653455753', '长金', 'HDMI-10m', '宇视', '', '135.00', '135.00', '', '', '', '', '272019467', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('1656286401', '思量', 'HGPF-A3G350P6S1Z/CS/XM', '思量', '', '20640.00', '20640.00', '', '', '', '', '1131782101', '1', '0', '1', '1605494931341');
INSERT INTO `quote` VALUES ('1825942783', '光大', '600×2000×600', '定制', '', '2160.00', '2160.00', '', '', '', '', '393277187', '1', '1', '1', '1604892194846');
INSERT INTO `quote` VALUES ('1873675229', '新顺', 'ST4000', '希捷', '', '570.00', '2280.00', '', '', '', '', '1222958178', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('1929987896', '新顺', 'HKN-PD1010', '广东海康', '', '185.00', '370.00', '', '', '', '', '1182401972', '1', '1', '1', '1604892490515');
INSERT INTO `quote` VALUES ('1973393708', '淙顺', 'XST6642TC-DDSK-H', '精致', '', '1550.00', '1550.00', '', '', '', '', '393277187', '1', '1', '1', '1604892169626');
INSERT INTO `quote` VALUES ('1994092734', '长金', '', '国产', '', '520.00', '520.00', '', '', '', '', '116725166', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('2010732366', '长金', '', '国产', '300*400**160出线孔4个', '60.00', '120.00', '', '', '', '', '1396600926', '1', '1', '1', '1604892261724');
INSERT INTO `quote` VALUES ('2017028571', '海康威视', 'ST4000VX000-520', '', '4TB/64MB(6Gb/秒 NCQ)/5900RPM/SATA3', '610.00', '0.00', '', '24个月', '', '', '1222958178', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('2133574226', '海康威视', 'DS-D5043FL/S', '海康威视', '43寸液晶监视器，金属外观，\n显示：LED背光；分辨率1920×1080；\n亮度400cd/㎡，对比度4000:1，功耗≤80W，\n裸机尺寸(W×L×D)(mm)：996.4mm(W)*590.8mm(H)*48.6mm(D) ，\n接口：\n音视频输入接口：VGA × 1、DVI × 1、HDMI × 1、BNC IN (SDI 信号) × 1\n音视频输出接口：BNC OUT (SDI 信号) × 1、内置扬声器5 W × 2\n数据传输接口：USB × 1\n控制接口：RS-232 IN × 1、RS-232 OUT × 1\n标准配置：\n装箱清单：遥控器 × 1、串口转接器 × 1、碳性干电池 × 2、电源线 × 1、光盘 × 1、保修\n卡 × 1、合格证 × 1、元素表 × 1、壁挂螺丝包（内含4 颗螺丝）× 1\n*出货不带底座，不带壁挂支架、底座和壁挂需要单独下单，', '2950.00', '0.00', '', '24个月', '', 'http://218.87.96.53:8006/images/0a42197a-b59b-4443-ba3d-21640c3403b5.jpeg', '988217602', '1', '1', '1', '1604892187999');
INSERT INTO `quote` VALUES ('2138136186', '长金', 'HD-WD WD40PURX', '西数', '', '580.00', '2320.00', '', '', '', '', '1222958178', '1', '1', '1', '1604892261724');

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
INSERT INTO `sys_file` VALUES ('56432523', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1653455753', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('100041505', '电磁流量计技术规格书.doc', 'http://218.87.96.53:8006/images/a2dc5efa-fd69-4c1b-92e6-7cb3e1f5cdc1.doc', '0', '1903687057', '1', '1', '1', '1605249291961');
INSERT INTO `sys_file` VALUES ('148633591', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '2010732366', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('190789943', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '491903872', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('308160515', '13e57268-35e5-4ed2-9098-8f459b0d024a.xls', 'http://218.87.96.53:8006/images/13e57268-35e5-4ed2-9098-8f459b0d024a.xls', '3', '1345377544', '1', '1', '1', '1604892194846');
INSERT INTO `sys_file` VALUES ('332878490', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '844467957', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('333763486', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1007956111', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('343204863', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '29707147', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('409843109', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '668352014', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('446215638', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '421507167', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('483445112', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1277090124', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('489483375', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '2138136186', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('530304265', '79fffc72-f8ce-4f62-9524-cf0dad7e0e25.xls', 'http://218.87.96.53:8006/images/79fffc72-f8ce-4f62-9524-cf0dad7e0e25.xls', '3', '1656286401', '1', '1', '1', '1605494931341');
INSERT INTO `sys_file` VALUES ('681181993', '184插入式超声波流量计传感器及转换器招标文件.doc', 'http://218.87.96.53:8006/images/dea6d6e0-9e95-45cb-b8cf-307a47c1a3f4.doc', '0', '1734108387', '1', '1', '1', '1605496361796');
INSERT INTO `sys_file` VALUES ('707795898', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1276397528', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('722635526', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1606359448', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('789604316', '185测管式流量计招标文件.doc', 'http://218.87.96.53:8006/images/fc2b4293-10b0-4504-8a20-c7e0ac7f5241.doc', '0', '1612620762', '1', '1', '1', '1605494367206');
INSERT INTO `sys_file` VALUES ('804255966', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '102301927', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('842123834', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1042197098', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('876619337', '181一体化喷嘴流量计等招标文件.doc', 'http://218.87.96.53:8006/images/bf59ac68-9953-422d-99aa-d8521dbe2106.doc', '0', '527006379', '1', '1', '1', '1605498579420');
INSERT INTO `sys_file` VALUES ('932774970', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '2133574226', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('936172384', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1973393708', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('984905826', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '2017028571', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1018523401', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1574033667', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1093111027', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1532483870', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1099881660', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '742317574', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1153161026', '金属转子流量计技术规格书.doc', 'http://218.87.96.53:8006/images/1b6f970f-063f-4f68-8b4e-011128d851ff.doc', '0', '1086813908', '1', '1', '1', '1605251018334');
INSERT INTO `sys_file` VALUES ('1173376907', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '243472280', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1222797813', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '1873675229', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1266043076', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '520236204', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1324328596', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '1269989429', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1348537476', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '853876038', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1386754752', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '134803518', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1389735154', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1088276707', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1415690207', '2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', 'http://218.87.96.53:8006/images/2f5e80c7-730e-4433-aa4f-af2fdac2c28c.xls', '3', '435588006', '1', '1', '1', '1604892490515');
INSERT INTO `sys_file` VALUES ('1420817515', '79fffc72-f8ce-4f62-9524-cf0dad7e0e25.xls', 'http://218.87.96.53:8006/images/79fffc72-f8ce-4f62-9524-cf0dad7e0e25.xls', '3', '731148490', '1', '1', '1', '1605494931341');
INSERT INTO `sys_file` VALUES ('1451876954', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '1606005763', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1470992048', '183导波雷达液位计等招标文件.doc', 'http://218.87.96.53:8006/images/f5b41d23-5655-4ac0-ad19-559cc98732d9.doc', '0', '1598348928', '1', '1', '1', '1605495602848');
INSERT INTO `sys_file` VALUES ('1494973960', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '561096163', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1698375950', '23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', 'http://218.87.96.53:8006/images/23e0a222-6e0d-4ae9-a9b0-7b74fe8f4962.xls', '3', '1994092734', '1', '1', '1', '1604892261724');
INSERT INTO `sys_file` VALUES ('1811631241', 'c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', 'http://218.87.96.53:8006/images/c0f0e21f-27c6-46ef-8bc2-d03e90add791.xls', '3', '1503517772', '1', '1', '1', '1604892187999');
INSERT INTO `sys_file` VALUES ('1840059713', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1169379670', '1', '1', '1', '1604892169626');
INSERT INTO `sys_file` VALUES ('1845413575', '13e57268-35e5-4ed2-9098-8f459b0d024a.xls', 'http://218.87.96.53:8006/images/13e57268-35e5-4ed2-9098-8f459b0d024a.xls', '3', '1825942783', '1', '1', '1', '1604892194846');
INSERT INTO `sys_file` VALUES ('1869113122', 'b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', 'http://218.87.96.53:8006/images/b30c55f8-0c09-46c7-8436-58badb10f3b2.xls', '3', '1449630645', '1', '1', '1', '1604892169626');

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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_privilege` VALUES ('73', '查询项目详情审核', 'method', '18', null, '/project/detail/findProDetailCheck', null, null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('74', '产品池管理', 'parent', null, 'star', '/pool/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('75', '产品池管理', 'menu', '74', '', '/pool/list', '', null, null, null, null);
INSERT INTO `sys_privilege` VALUES ('76', '产品池查询', 'method', '74', null, '/pool/findByParams', null, null, null, null, null);

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
INSERT INTO `sys_pro_check` VALUES ('18980539', '1', '商务审核', null, '1345377544', '1', '1605143429986');
INSERT INTO `sys_pro_check` VALUES ('24543736', '0', '最终审核', null, '2010732366', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('34277577', '0', '最终审核', null, '742317574', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('38117236', '1', '商务审核', null, '421507167', '1', '1605143430027');
INSERT INTO `sys_pro_check` VALUES ('52575173', '0', '最终审核', null, '731148490', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('61977145', '0', '最终审核', null, '561096163', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('75702094', '1', '商务审核', null, '243472280', '1', '1605143436582');
INSERT INTO `sys_pro_check` VALUES ('76450183', '1', '商务审核', null, '1449630645', '1', '1605143439724');
INSERT INTO `sys_pro_check` VALUES ('87872513', '0', '比价审核', null, '2017028571', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('113193000', '1', '技术审核', null, '1449630645', '1', '1605143456892');
INSERT INTO `sys_pro_check` VALUES ('137629244', '0', '最终审核', null, '520236204', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('154713568', '1', '技术审核', null, '1088276707', '1', '1605143456850');
INSERT INTO `sys_pro_check` VALUES ('190425949', '1', '技术审核', null, '134803518', '1', '1605143456840');
INSERT INTO `sys_pro_check` VALUES ('190822499', '0', '比价审核', null, '2133574226', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('202620786', '1', '商务审核', null, '1606359448', '1', '1605143433461');
INSERT INTO `sys_pro_check` VALUES ('240381326', '2', '比价审核', null, '102301927', '1', '1605143560289');
INSERT INTO `sys_pro_check` VALUES ('246378130', '0', '最终审核', null, '243472280', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('250503479', '1', '技术审核', null, '1929987896', '1', '1605143422080');
INSERT INTO `sys_pro_check` VALUES ('255679614', '0', '比价审核', null, '742317574', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('262252718', '1', '商务审核', null, '1606005763', '1', '1605143436618');
INSERT INTO `sys_pro_check` VALUES ('275259309', '1', '技术审核', null, '2133574226', '1', '1605143443860');
INSERT INTO `sys_pro_check` VALUES ('311763045', '1', '技术审核', null, '1276397528', '1', '1605143422143');
INSERT INTO `sys_pro_check` VALUES ('341046153', '0', '商务审核', null, '1656286401', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('354117263', '0', '比价审核', null, '1929987896', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('359853343', '1', '商务审核', null, '1532483870', '1', '1605143433510');
INSERT INTO `sys_pro_check` VALUES ('367446218', '0', '最终审核', null, '2133574226', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('380425642', '1', '商务审核', null, '561096163', '1', '1605143436625');
INSERT INTO `sys_pro_check` VALUES ('397596371', '0', '比价审核', null, '853876038', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('421907289', '1', '商务审核', null, '29707147', '1', '1605143430013');
INSERT INTO `sys_pro_check` VALUES ('425242121', '1', '商务审核', null, '1503517772', '1', '1605143436639');
INSERT INTO `sys_pro_check` VALUES ('432842674', '0', '最终审核', null, '1873675229', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('463801180', '1', '商务审核', null, '491903872', '1', '1605143429980');
INSERT INTO `sys_pro_check` VALUES ('467711760', '0', '比价审核', null, '1653455753', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('476298590', '0', '比价审核', null, '1449630645', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('491903313', '1', '技术审核', null, '435588006', '1', '1605143456857');
INSERT INTO `sys_pro_check` VALUES ('515135962', '0', '比价审核', null, '2010732366', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('525829422', '1', '技术审核', null, '1825942783', '1', '1605143456885');
INSERT INTO `sys_pro_check` VALUES ('535173324', '1', '技术审核', null, '1042197098', '1', '1605143443853');
INSERT INTO `sys_pro_check` VALUES ('558995903', '0', '比价审核', null, '1276397528', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('582939768', '1', '商务审核', null, '1269989429', '1', '1605143436597');
INSERT INTO `sys_pro_check` VALUES ('597100668', '0', '比价审核', null, '1532483870', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('604714341', '1', '技术审核', null, '853876038', '1', '1605143456834');
INSERT INTO `sys_pro_check` VALUES ('610355156', '0', '比价审核', null, '1169379670', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('614236419', '2', '比价审核', null, '1007956111', '1', '1605161036056');
INSERT INTO `sys_pro_check` VALUES ('650333693', '0', '比价审核', null, '134803518', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('686813710', '0', '比价审核', null, '520236204', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('687213499', '1', '技术审核', null, '1532483870', '1', '1605143443887');
INSERT INTO `sys_pro_check` VALUES ('719236178', '1', '商务审核', null, '1007956111', '1', '1605143430003');
INSERT INTO `sys_pro_check` VALUES ('735588992', '1', '技术审核', null, '2138136186', '1', '1605143422137');
INSERT INTO `sys_pro_check` VALUES ('753996452', '0', '最终审核', null, '1574033667', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('762356255', '0', '最终审核', null, '668352014', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('766924324', '0', '最终审核', null, '435588006', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('768633631', '1', '商务审核', null, '1088276707', '1', '1605143436611');
INSERT INTO `sys_pro_check` VALUES ('770082219', '0', '最终审核', null, '1169379670', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('773272592', '1', '商务审核', null, '1825942783', '1', '1605143439717');
INSERT INTO `sys_pro_check` VALUES ('775402418', '1', '技术审核', null, '491903872', '1', '1605143422095');
INSERT INTO `sys_pro_check` VALUES ('779260119', '0', '最终审核', null, '2138136186', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('810504377', '0', '最终审核', null, '1088276707', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('840513234', '0', '比价审核', null, '1088276707', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('843463636', '2', '比价审核', null, '844467957', '1', '1605143560289');
INSERT INTO `sys_pro_check` VALUES ('874473936', '0', '最终审核', null, '29707147', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('878370026', '0', '最终审核', null, '1345377544', '1', '1604892194846');
INSERT INTO `sys_pro_check` VALUES ('885509567', '1', '商务审核', null, '134803518', '1', '1605143436604');
INSERT INTO `sys_pro_check` VALUES ('886584017', '0', '最终审核', null, '1007956111', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('899889421', '1', '商务审核', null, '2010732366', '1', '1605143429973');
INSERT INTO `sys_pro_check` VALUES ('912292911', '1', '商务审核', null, '844467957', '1', '1605143429993');
INSERT INTO `sys_pro_check` VALUES ('917054701', '0', '最终审核', null, '1449630645', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('958897463', '1', '商务审核', null, '102301927', '1', '1605143433468');
INSERT INTO `sys_pro_check` VALUES ('966044232', '1', '商务审核', null, '2138136186', '1', '1605143430034');
INSERT INTO `sys_pro_check` VALUES ('986045497', '0', '比价审核', null, '1345377544', '1', '1604892194846');
INSERT INTO `sys_pro_check` VALUES ('987301763', '0', '比价审核', null, '2138136186', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('1003262608', '1', '技术审核', null, '1973393708', '1', '1605143443866');
INSERT INTO `sys_pro_check` VALUES ('1033346819', '1', '技术审核', null, '2017028571', '1', '1605143443873');
INSERT INTO `sys_pro_check` VALUES ('1076740617', '1', '技术审核', null, '243472280', '1', '1605143443900');
INSERT INTO `sys_pro_check` VALUES ('1104037660', '1', '技术审核', null, '1269989429', '1', '1605143456827');
INSERT INTO `sys_pro_check` VALUES ('1104885961', '1', '商务审核', null, '2017028571', '1', '1605143433496');
INSERT INTO `sys_pro_check` VALUES ('1139085642', '0', '比价审核', null, '1656286401', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('1140426612', '1', '商务审核', null, '668352014', '1', '1605143430020');
INSERT INTO `sys_pro_check` VALUES ('1140912360', '0', '比价审核', null, '1503517772', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('1156842444', '1', '技术审核', null, '1503517772', '1', '1605143456871');
INSERT INTO `sys_pro_check` VALUES ('1162125616', '1', '商务审核', null, '1873675229', '1', '1605143436589');
INSERT INTO `sys_pro_check` VALUES ('1181875484', '0', '最终审核', null, '1277090124', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1182287332', '0', '比价审核', null, '29707147', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('1206226161', '1', '技术审核', null, '742317574', '1', '1605143443893');
INSERT INTO `sys_pro_check` VALUES ('1222793900', '1', '技术审核', null, '1606005763', '1', '1605143456864');
INSERT INTO `sys_pro_check` VALUES ('1222863899', '1', '商务审核', null, '1042197098', '1', '1605143433475');
INSERT INTO `sys_pro_check` VALUES ('1224248627', '1', '比价审核', null, '1994092734', '1', '1605161036056');
INSERT INTO `sys_pro_check` VALUES ('1243708630', '1', '商务审核', null, '1169379670', '1', '1605143436645');
INSERT INTO `sys_pro_check` VALUES ('1257359626', '1', '最终审核', '', '1606005763', '1', '1605162976753');
INSERT INTO `sys_pro_check` VALUES ('1274419017', '1', '技术审核', null, '844467957', '1', '1605143422109');
INSERT INTO `sys_pro_check` VALUES ('1284674305', '0', '最终审核', null, '1653455753', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('1287254014', '0', '最终审核', null, '134803518', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('1295382695', '1', '技术审核', null, '1345377544', '1', '1605143422103');
INSERT INTO `sys_pro_check` VALUES ('1304210014', '1', '商务审核', null, '1653455753', '1', '1605143429965');
INSERT INTO `sys_pro_check` VALUES ('1345557443', '1', '商务审核', null, '1276397528', '1', '1605143433453');
INSERT INTO `sys_pro_check` VALUES ('1347940521', '1', '技术审核', null, '1574033667', '1', '1605143443880');
INSERT INTO `sys_pro_check` VALUES ('1347944537', '2', '比价审核', null, '1277090124', '1', '1605161036056');
INSERT INTO `sys_pro_check` VALUES ('1369601183', '0', '最终审核', null, '1276397528', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('1384771594', '1', '技术审核', null, '1169379670', '1', '1605143456877');
INSERT INTO `sys_pro_check` VALUES ('1449407096', '1', '技术审核', null, '1007956111', '1', '1605143422117');
INSERT INTO `sys_pro_check` VALUES ('1456702952', '1', '商务审核', null, '1994092734', '1', '1605143436632');
INSERT INTO `sys_pro_check` VALUES ('1464501149', '0', '最终审核', null, '2017028571', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('1472177951', '1', '商务审核', null, '1574033667', '1', '1605143433502');
INSERT INTO `sys_pro_check` VALUES ('1476944309', '0', '比价审核', null, '1269989429', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('1487443000', '0', '比价审核', null, '243472280', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('1491305881', '0', '最终审核', null, '1656286401', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('1497600022', '0', '最终审核', null, '1973393708', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('1513016243', '0', '技术审核', null, '1656286401', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('1517643896', '0', '比价审核', null, '1825942783', '1', '1604892194846');
INSERT INTO `sys_pro_check` VALUES ('1547878832', '0', '比价审核', null, '731148490', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('1565551858', '0', '比价审核', null, '1873675229', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1569250880', '0', '比价审核', null, '1574033667', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1597278580', '0', '最终审核', null, '1042197098', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1665220123', '0', '比价审核', null, '561096163', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('1683631575', '0', '最终审核', null, '853876038', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1703278235', '1', '技术审核', null, '1873675229', '1', '1605143443907');
INSERT INTO `sys_pro_check` VALUES ('1706312235', '1', '技术审核', null, '520236204', '1', '1605143456820');
INSERT INTO `sys_pro_check` VALUES ('1708006360', '0', '比价审核', null, '1973393708', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('1723114266', '0', '最终审核', null, '1606359448', '1', '1604892169626');
INSERT INTO `sys_pro_check` VALUES ('1788387008', '1', '商务审核', null, '742317574', '1', '1605143433517');
INSERT INTO `sys_pro_check` VALUES ('1797125208', '1', '技术审核', null, '668352014', '1', '1605143422123');
INSERT INTO `sys_pro_check` VALUES ('1808520530', '2', '比价审核', null, '1606005763', '1', '1605143560289');
INSERT INTO `sys_pro_check` VALUES ('1823304367', '0', '技术审核', null, '731148490', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('1825905719', '1', '技术审核', null, '1653455753', '1', '1605143422088');
INSERT INTO `sys_pro_check` VALUES ('1834408692', '0', '最终审核', null, '421507167', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('1845701297', '1', '技术审核', null, '1277090124', '1', '1605143422130');
INSERT INTO `sys_pro_check` VALUES ('1871207982', '0', '比价审核', null, '435588006', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1877047175', '0', '最终审核', null, '1503517772', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('1888947473', '0', '比价审核', null, '668352014', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1904870698', '1', '商务审核', null, '2133574226', '1', '1605143433482');
INSERT INTO `sys_pro_check` VALUES ('1909669476', '1', '商务审核', null, '1973393708', '1', '1605143433489');
INSERT INTO `sys_pro_check` VALUES ('1918432797', '1', '商务审核', null, '520236204', '1', '1605143439745');
INSERT INTO `sys_pro_check` VALUES ('1920662050', '0', '最终审核', null, '1929987896', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1924171518', '0', '最终审核', null, '844467957', '1', '1604892490515');
INSERT INTO `sys_pro_check` VALUES ('1948367118', '0', '比价审核', null, '421507167', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('1957160470', '1', '商务审核', null, '1277090124', '1', '1605143439738');
INSERT INTO `sys_pro_check` VALUES ('1964812326', '0', '最终审核', null, '102301927', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('1975194119', '1', '技术审核', null, '1606359448', '1', '1605143443846');
INSERT INTO `sys_pro_check` VALUES ('2003251193', '0', '最终审核', null, '1825942783', '1', '1604892194846');
INSERT INTO `sys_pro_check` VALUES ('2008567377', '1', '技术审核', null, '1994092734', '1', '1605143456932');
INSERT INTO `sys_pro_check` VALUES ('2014580766', '1', '技术审核', null, '102301927', '1', '1605143456919');
INSERT INTO `sys_pro_check` VALUES ('2022412180', '0', '最终审核', null, '1269989429', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('2045390115', '0', '比价审核', null, '491903872', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('2047859619', '1', '最终审核', '', '1994092734', '1', '1605162976753');
INSERT INTO `sys_pro_check` VALUES ('2048201481', '0', '最终审核', null, '491903872', '1', '1604892187999');
INSERT INTO `sys_pro_check` VALUES ('2071271018', '1', '比价审核', null, '1606359448', '1', '1605143560289');
INSERT INTO `sys_pro_check` VALUES ('2071614296', '0', '最终审核', null, '1532483870', '1', '1604892261724');
INSERT INTO `sys_pro_check` VALUES ('2072124111', '0', '商务审核', null, '731148490', '1', '1605494931341');
INSERT INTO `sys_pro_check` VALUES ('2080799652', '1', '技术审核', null, '2010732366', '1', '1605143456898');
INSERT INTO `sys_pro_check` VALUES ('2095284122', '1', '商务审核', null, '853876038', '1', '1605143439753');
INSERT INTO `sys_pro_check` VALUES ('2100563671', '1', '技术审核', null, '29707147', '1', '1605143456905');
INSERT INTO `sys_pro_check` VALUES ('2112877951', '1', '技术审核', null, '561096163', '1', '1605143456925');
INSERT INTO `sys_pro_check` VALUES ('2119590162', '1', '商务审核', null, '435588006', '1', '1605143439759');
INSERT INTO `sys_pro_check` VALUES ('2141454926', '1', '商务审核', null, '1929987896', '1', '1605143439731');
INSERT INTO `sys_pro_check` VALUES ('2142732630', '1', '技术审核', null, '421507167', '1', '1605143456911');
INSERT INTO `sys_pro_check` VALUES ('2146202284', '0', '比价审核', null, '1042197098', '1', '1604892490515');

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
INSERT INTO `sys_pro_detail` VALUES ('527006379', '焦炉项目一体化喷嘴、孔板', null, null, '2033344962', '231439638', '1', '0', '1', '1605498579420');
INSERT INTO `sys_pro_detail` VALUES ('1086813908', '焦炉项目金属转子流量计', null, null, '2033344962', '838895759', '1', '0', '1', '1605251018334');
INSERT INTO `sys_pro_detail` VALUES ('1565074093', '双林视频', null, null, '2033344962', '1996166487', '1', '0', '1', '1604541553758');
INSERT INTO `sys_pro_detail` VALUES ('1598348928', '焦炉项目导波雷达液位计', null, null, '2033344962', '682402023', '1', '0', '1', '1605495602848');
INSERT INTO `sys_pro_detail` VALUES ('1612620762', '焦炉项目测管流量计', null, null, '2033344962', '1703361707', '1', '0', '1', '1605494367206');
INSERT INTO `sys_pro_detail` VALUES ('1734108387', '焦炉项目插入式超声波流量计', null, null, '2033344962', '1882938322', '1', '0', '1', '1605496361796');
INSERT INTO `sys_pro_detail` VALUES ('1903687057', '焦炉项目电磁流量计', null, null, '2033344962', '172302111', '1', '0', '1', '1605249291961');

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
INSERT INTO `sys_pro_detail_check` VALUES ('110376084', '1086813908', '0', '商务审核', '1', '1605251018334');
INSERT INTO `sys_pro_detail_check` VALUES ('125350754', '1086813908', '0', '技术审核', '1', '1605251018334');
INSERT INTO `sys_pro_detail_check` VALUES ('193593527', '527006379', '0', '最终审核', '1', '1605498579420');
INSERT INTO `sys_pro_detail_check` VALUES ('409610259', '1612620762', '0', '商务审核', '1', '1605494367206');
INSERT INTO `sys_pro_detail_check` VALUES ('431995237', '1734108387', '0', '商务审核', '1', '1605496361796');
INSERT INTO `sys_pro_detail_check` VALUES ('451355779', '527006379', '0', '商务审核', '1', '1605498579420');
INSERT INTO `sys_pro_detail_check` VALUES ('586285210', '1565074093', '0', '技术审核', '1', '1604555969695');
INSERT INTO `sys_pro_detail_check` VALUES ('612484815', '1598348928', '0', '最终审核', '1', '1605495602848');
INSERT INTO `sys_pro_detail_check` VALUES ('890954645', '1565074093', '0', '最终审核', '1', '1604555969695');
INSERT INTO `sys_pro_detail_check` VALUES ('1038570273', '527006379', '0', '技术审核', '1', '1605498579420');
INSERT INTO `sys_pro_detail_check` VALUES ('1127278033', '1086813908', '0', '最终审核', '1', '1605251018334');
INSERT INTO `sys_pro_detail_check` VALUES ('1145512131', '1734108387', '0', '最终审核', '1', '1605496361796');
INSERT INTO `sys_pro_detail_check` VALUES ('1399131553', '1903687057', '0', '商务审核', '1', '1605249291961');
INSERT INTO `sys_pro_detail_check` VALUES ('1437238051', '1612620762', '0', '最终审核', '1', '1605494367206');
INSERT INTO `sys_pro_detail_check` VALUES ('1515805717', '1734108387', '0', '技术审核', '1', '1605496361796');
INSERT INTO `sys_pro_detail_check` VALUES ('1536754363', '1598348928', '0', '商务审核', '1', '1605495602848');
INSERT INTO `sys_pro_detail_check` VALUES ('1598808220', '1903687057', '0', '最终审核', '1', '1605249291961');
INSERT INTO `sys_pro_detail_check` VALUES ('1659903135', '1612620762', '0', '技术审核', '1', '1605494367206');
INSERT INTO `sys_pro_detail_check` VALUES ('1662995602', '1903687057', '0', '技术审核', '1', '1605249291961');
INSERT INTO `sys_pro_detail_check` VALUES ('2058269003', '1565074093', '0', '商务审核', '1', '1604555969695');
INSERT INTO `sys_pro_detail_check` VALUES ('2065722334', '1598348928', '0', '技术审核', '1', '1605495602848');

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
INSERT INTO `sys_pro_origin` VALUES ('172302111', '焦炉项目电磁流量计', null, null, null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('231439638', '焦炉项目一体化喷嘴、孔板', null, null, null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('682402023', '焦炉项目导波雷达液位计', null, null, null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('838895759', '焦炉项目金属转子流量计', '', null, null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('1703361707', '焦炉项目测管流量计', null, null, null, null, null);
INSERT INTO `sys_pro_origin` VALUES ('1882938322', '焦炉项目插入式超声波流量计', null, null, null, null, null);
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
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

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
