/*
Navicat MySQL Data Transfer

Source Server         : xupk
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : dorm-sys

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-26 10:03:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for security_building
-- ----------------------------
DROP TABLE IF EXISTS `security_building`;
CREATE TABLE `security_building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `height` int(20) DEFAULT NULL,
  `contain` int(20) DEFAULT NULL,
  `used_bed` int(20) DEFAULT NULL,
  `layerproom` int(20) DEFAULT NULL,
  `roompbed` int(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `security_building_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `security_building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_building
-- ----------------------------
INSERT INTO `security_building` VALUES ('1', '桂林理工大学', null, null, null, null, null, null, null);
INSERT INTO `security_building` VALUES ('29', '雁山校区', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `security_building` VALUES ('31', '1B', '男', '6', '1000', '2', '30', '6', '29');
INSERT INTO `security_building` VALUES ('34', '屏风校区', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `security_building` VALUES ('35', '25#', '0', '6', '1000', '1', '30', '6', '29');
INSERT INTO `security_building` VALUES ('36', '23#', '男', '6', '1000', '1', '30', '6', '29');
INSERT INTO `security_building` VALUES ('37', '21#', '男', '6', '1000', '1', '30', '6', '29');
INSERT INTO `security_building` VALUES ('38', '10A', '男', '6', '1000', '0', '30', '6', '34');
INSERT INTO `security_building` VALUES ('39', '11B', '男', '6', '1000', '0', '30', '6', '34');
INSERT INTO `security_building` VALUES ('40', '3A', '男', '6', '6', '1', '30', '6', '29');
INSERT INTO `security_building` VALUES ('41', '22#', '男', '6', '1000', '0', '30', '6', '29');

-- ----------------------------
-- Table structure for security_building_user
-- ----------------------------
DROP TABLE IF EXISTS `security_building_user`;
CREATE TABLE `security_building_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `building_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `building_id` (`building_id`),
  CONSTRAINT `security_building_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`),
  CONSTRAINT `security_building_user_ibfk_2` FOREIGN KEY (`building_id`) REFERENCES `security_building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_building_user
-- ----------------------------

-- ----------------------------
-- Table structure for security_module
-- ----------------------------
DROP TABLE IF EXISTS `security_module`;
CREATE TABLE `security_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `priority` int(11) NOT NULL,
  `sn` varchar(32) NOT NULL,
  `url` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6510844BB3395F9` (`parent_id`),
  CONSTRAINT `FK6510844BB3395F9` FOREIGN KEY (`parent_id`) REFERENCES `security_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_module
-- ----------------------------
INSERT INTO `security_module` VALUES ('1', '所有模块的根节点，不能删除。', '根模块', '1', 'Root', '#', null);
INSERT INTO `security_module` VALUES ('2', '安全管理:包含权限管理、模块管理等。', '系统管理', '99', 'Security', '#', '1');
INSERT INTO `security_module` VALUES ('3', '', '用户管理', '99', 'User', '/management/security/user/list', '2');
INSERT INTO `security_module` VALUES ('4', '', '角色管理', '99', 'Role', '/management/security/role/list', '2');
INSERT INTO `security_module` VALUES ('5', '', '模块管理', '99', 'Module', '/management/security/module/tree', '2');
INSERT INTO `security_module` VALUES ('18', '', '组织管理', '99', 'Organization', '/management/security/organization/tree', '2');
INSERT INTO `security_module` VALUES ('24', '', '缓存管理', '99', 'CacheManage', '/management/security/cacheManage/index', '2');
INSERT INTO `security_module` VALUES ('59', '', '资源管理', '99', 'Resource', '#', '1');
INSERT INTO `security_module` VALUES ('60', '', '违规管理', '99', 'Rule', '#', '1');
INSERT INTO `security_module` VALUES ('61', '', '报修管理', '99', 'Maintain', '#', '1');
INSERT INTO `security_module` VALUES ('62', '', '楼栋管理', '99', 'Building', '/management/security/building/tree', '59');
INSERT INTO `security_module` VALUES ('63', '', '住宿管理', '99', 'Student', '/management/security/student/list', '59');
INSERT INTO `security_module` VALUES ('64', '', '违规记录', '99', 'Violation', '/management/security/violation/list', '60');
INSERT INTO `security_module` VALUES ('65', '', '报修信息', '99', 'Repair', '/management/security/repair/list', '61');
INSERT INTO `security_module` VALUES ('66', '', '房间管理', '99', 'Room', '/management/security/room/list', '59');

-- ----------------------------
-- Table structure for security_organization
-- ----------------------------
DROP TABLE IF EXISTS `security_organization`;
CREATE TABLE `security_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(64) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1DBDA7D2FCC01B00` (`parent_id`),
  CONSTRAINT `FK1DBDA7D2FCC01B00` FOREIGN KEY (`parent_id`) REFERENCES `security_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_organization
-- ----------------------------
INSERT INTO `security_organization` VALUES ('1', '不能删除。', '桂林理工大学', null);
INSERT INTO `security_organization` VALUES ('12', '', '雁山校区', '1');
INSERT INTO `security_organization` VALUES ('13', '', '总务处', '12');
INSERT INTO `security_organization` VALUES ('14', '', '楼管部', '12');
INSERT INTO `security_organization` VALUES ('15', '', '维修部', '12');
INSERT INTO `security_organization` VALUES ('16', '', '屏风校区', '1');

-- ----------------------------
-- Table structure for security_organization_role
-- ----------------------------
DROP TABLE IF EXISTS `security_organization_role`;
CREATE TABLE `security_organization_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priority` int(11) NOT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK557CA4C3D069FDD7` (`organization_id`),
  KEY `FK557CA4C3C592DFF7` (`role_id`),
  CONSTRAINT `FK557CA4C3C592DFF7` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`),
  CONSTRAINT `FK557CA4C3D069FDD7` FOREIGN KEY (`organization_id`) REFERENCES `security_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_organization_role
-- ----------------------------
INSERT INTO `security_organization_role` VALUES ('2', '99', '13', '10');
INSERT INTO `security_organization_role` VALUES ('3', '99', '14', '11');
INSERT INTO `security_organization_role` VALUES ('4', '99', '15', '12');

-- ----------------------------
-- Table structure for security_permission
-- ----------------------------
DROP TABLE IF EXISTS `security_permission`;
CREATE TABLE `security_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `short_name` varchar(16) NOT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBA7A9C2E334A08F7` (`module_id`),
  CONSTRAINT `FKBA7A9C2E334A08F7` FOREIGN KEY (`module_id`) REFERENCES `security_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_permission
-- ----------------------------
INSERT INTO `security_permission` VALUES ('25', '', '增', 'save', '2');
INSERT INTO `security_permission` VALUES ('26', '', '删', 'delete', '2');
INSERT INTO `security_permission` VALUES ('27', '', '查', 'view', '2');
INSERT INTO `security_permission` VALUES ('28', '', '改', 'edit', '2');
INSERT INTO `security_permission` VALUES ('37', '', '增', 'save', '3');
INSERT INTO `security_permission` VALUES ('38', '', '删', 'delete', '3');
INSERT INTO `security_permission` VALUES ('39', '', '查', 'view', '3');
INSERT INTO `security_permission` VALUES ('40', '', '改', 'edit', '3');
INSERT INTO `security_permission` VALUES ('45', '', '增', 'save', '4');
INSERT INTO `security_permission` VALUES ('46', '', '删', 'delete', '4');
INSERT INTO `security_permission` VALUES ('47', '', '查', 'view', '4');
INSERT INTO `security_permission` VALUES ('48', '', '改', 'edit', '4');
INSERT INTO `security_permission` VALUES ('53', '', '增', 'save', '5');
INSERT INTO `security_permission` VALUES ('54', '', '删', 'delete', '5');
INSERT INTO `security_permission` VALUES ('55', '', '查', 'view', '5');
INSERT INTO `security_permission` VALUES ('56', '', '改', 'edit', '5');
INSERT INTO `security_permission` VALUES ('57', '', '增', 'save', '18');
INSERT INTO `security_permission` VALUES ('58', '', '删', 'delete', '18');
INSERT INTO `security_permission` VALUES ('59', '', '查', 'view', '18');
INSERT INTO `security_permission` VALUES ('60', '', '改', 'edit', '18');
INSERT INTO `security_permission` VALUES ('61', '', '查', 'view', '24');
INSERT INTO `security_permission` VALUES ('62', '', '改', 'edit', '24');
INSERT INTO `security_permission` VALUES ('76', '重置密码、更新状态', '重置', 'reset', '3');
INSERT INTO `security_permission` VALUES ('77', '分配、撤销角色', '授权', 'assign', '3');
INSERT INTO `security_permission` VALUES ('78', '分配、撤销角色', '授权', 'assign', '18');
INSERT INTO `security_permission` VALUES ('135', null, '增', 'save', '59');
INSERT INTO `security_permission` VALUES ('136', null, '删', 'delete', '59');
INSERT INTO `security_permission` VALUES ('137', null, '查', 'view', '59');
INSERT INTO `security_permission` VALUES ('138', null, '改', 'edit', '59');
INSERT INTO `security_permission` VALUES ('139', null, '增', 'save', '60');
INSERT INTO `security_permission` VALUES ('140', null, '删', 'delete', '60');
INSERT INTO `security_permission` VALUES ('141', null, '查', 'view', '60');
INSERT INTO `security_permission` VALUES ('142', null, '改', 'edit', '60');
INSERT INTO `security_permission` VALUES ('143', null, '增', 'save', '61');
INSERT INTO `security_permission` VALUES ('144', null, '删', 'delete', '61');
INSERT INTO `security_permission` VALUES ('145', null, '查', 'view', '61');
INSERT INTO `security_permission` VALUES ('146', null, '改', 'edit', '61');
INSERT INTO `security_permission` VALUES ('147', null, '增', 'save', '62');
INSERT INTO `security_permission` VALUES ('148', null, '删', 'delete', '62');
INSERT INTO `security_permission` VALUES ('149', null, '查', 'view', '62');
INSERT INTO `security_permission` VALUES ('150', null, '改', 'edit', '62');
INSERT INTO `security_permission` VALUES ('151', null, '增', 'save', '63');
INSERT INTO `security_permission` VALUES ('152', null, '删', 'delete', '63');
INSERT INTO `security_permission` VALUES ('153', null, '查', 'view', '63');
INSERT INTO `security_permission` VALUES ('154', null, '改', 'edit', '63');
INSERT INTO `security_permission` VALUES ('155', null, '增', 'save', '64');
INSERT INTO `security_permission` VALUES ('156', null, '删', 'delete', '64');
INSERT INTO `security_permission` VALUES ('157', null, '查', 'view', '64');
INSERT INTO `security_permission` VALUES ('158', null, '改', 'edit', '64');
INSERT INTO `security_permission` VALUES ('159', null, '增', 'save', '65');
INSERT INTO `security_permission` VALUES ('160', null, '删', 'delete', '65');
INSERT INTO `security_permission` VALUES ('161', null, '查', 'view', '65');
INSERT INTO `security_permission` VALUES ('162', null, '改', 'edit', '65');
INSERT INTO `security_permission` VALUES ('163', '', '授权', 'assign', '62');
INSERT INTO `security_permission` VALUES ('164', null, '增', 'save', '66');
INSERT INTO `security_permission` VALUES ('165', null, '删', 'delete', '66');
INSERT INTO `security_permission` VALUES ('166', null, '查', 'view', '66');
INSERT INTO `security_permission` VALUES ('167', null, '改', 'edit', '66');
INSERT INTO `security_permission` VALUES ('168', '', '重置', 'reset', '64');
INSERT INTO `security_permission` VALUES ('169', '', '重置', 'reset', '65');

-- ----------------------------
-- Table structure for security_repair
-- ----------------------------
DROP TABLE IF EXISTS `security_repair`;
CREATE TABLE `security_repair` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `student` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `manager` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_repair
-- ----------------------------
INSERT INTO `security_repair` VALUES ('16', '25#330', '水槽漏水', '2016-04-28', '刘洋凯', 'enabled', '杨旭网');

-- ----------------------------
-- Table structure for security_role
-- ----------------------------
DROP TABLE IF EXISTS `security_role`;
CREATE TABLE `security_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_role
-- ----------------------------
INSERT INTO `security_role` VALUES ('9', '管理所有模块，操作所有功能', '超级管理员');
INSERT INTO `security_role` VALUES ('10', '用户管理，缓存管理，资源管理，违规管理，报修管理', '总务处');
INSERT INTO `security_role` VALUES ('11', '缓存管理，资源管理，违规管理', '楼管部');
INSERT INTO `security_role` VALUES ('12', '缓存管理，报修管理', '维修部');

-- ----------------------------
-- Table structure for security_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `security_role_permission`;
CREATE TABLE `security_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK679E223926E70397` (`permission_id`),
  KEY `FK679E2239C592DFF7` (`role_id`),
  CONSTRAINT `FK679E223926E70397` FOREIGN KEY (`permission_id`) REFERENCES `security_permission` (`id`),
  CONSTRAINT `FK679E2239C592DFF7` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=348 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_role_permission
-- ----------------------------
INSERT INTO `security_role_permission` VALUES ('77', '25', '9');
INSERT INTO `security_role_permission` VALUES ('78', '26', '9');
INSERT INTO `security_role_permission` VALUES ('79', '27', '9');
INSERT INTO `security_role_permission` VALUES ('80', '28', '9');
INSERT INTO `security_role_permission` VALUES ('81', '37', '9');
INSERT INTO `security_role_permission` VALUES ('82', '38', '9');
INSERT INTO `security_role_permission` VALUES ('83', '39', '9');
INSERT INTO `security_role_permission` VALUES ('84', '40', '9');
INSERT INTO `security_role_permission` VALUES ('85', '76', '9');
INSERT INTO `security_role_permission` VALUES ('86', '77', '9');
INSERT INTO `security_role_permission` VALUES ('87', '45', '9');
INSERT INTO `security_role_permission` VALUES ('88', '46', '9');
INSERT INTO `security_role_permission` VALUES ('89', '47', '9');
INSERT INTO `security_role_permission` VALUES ('90', '48', '9');
INSERT INTO `security_role_permission` VALUES ('95', '57', '9');
INSERT INTO `security_role_permission` VALUES ('96', '58', '9');
INSERT INTO `security_role_permission` VALUES ('97', '59', '9');
INSERT INTO `security_role_permission` VALUES ('98', '60', '9');
INSERT INTO `security_role_permission` VALUES ('99', '78', '9');
INSERT INTO `security_role_permission` VALUES ('100', '61', '9');
INSERT INTO `security_role_permission` VALUES ('101', '62', '9');
INSERT INTO `security_role_permission` VALUES ('108', '135', '9');
INSERT INTO `security_role_permission` VALUES ('109', '136', '9');
INSERT INTO `security_role_permission` VALUES ('110', '137', '9');
INSERT INTO `security_role_permission` VALUES ('111', '138', '9');
INSERT INTO `security_role_permission` VALUES ('112', '147', '9');
INSERT INTO `security_role_permission` VALUES ('113', '148', '9');
INSERT INTO `security_role_permission` VALUES ('114', '149', '9');
INSERT INTO `security_role_permission` VALUES ('115', '150', '9');
INSERT INTO `security_role_permission` VALUES ('116', '151', '9');
INSERT INTO `security_role_permission` VALUES ('117', '152', '9');
INSERT INTO `security_role_permission` VALUES ('118', '153', '9');
INSERT INTO `security_role_permission` VALUES ('119', '154', '9');
INSERT INTO `security_role_permission` VALUES ('120', '139', '9');
INSERT INTO `security_role_permission` VALUES ('121', '140', '9');
INSERT INTO `security_role_permission` VALUES ('122', '141', '9');
INSERT INTO `security_role_permission` VALUES ('123', '142', '9');
INSERT INTO `security_role_permission` VALUES ('124', '155', '9');
INSERT INTO `security_role_permission` VALUES ('125', '156', '9');
INSERT INTO `security_role_permission` VALUES ('126', '157', '9');
INSERT INTO `security_role_permission` VALUES ('127', '158', '9');
INSERT INTO `security_role_permission` VALUES ('128', '143', '9');
INSERT INTO `security_role_permission` VALUES ('129', '144', '9');
INSERT INTO `security_role_permission` VALUES ('130', '145', '9');
INSERT INTO `security_role_permission` VALUES ('131', '146', '9');
INSERT INTO `security_role_permission` VALUES ('132', '159', '9');
INSERT INTO `security_role_permission` VALUES ('133', '160', '9');
INSERT INTO `security_role_permission` VALUES ('134', '161', '9');
INSERT INTO `security_role_permission` VALUES ('135', '162', '9');
INSERT INTO `security_role_permission` VALUES ('140', '37', '10');
INSERT INTO `security_role_permission` VALUES ('141', '38', '10');
INSERT INTO `security_role_permission` VALUES ('142', '39', '10');
INSERT INTO `security_role_permission` VALUES ('143', '40', '10');
INSERT INTO `security_role_permission` VALUES ('144', '76', '10');
INSERT INTO `security_role_permission` VALUES ('145', '77', '10');
INSERT INTO `security_role_permission` VALUES ('159', '61', '10');
INSERT INTO `security_role_permission` VALUES ('160', '62', '10');
INSERT INTO `security_role_permission` VALUES ('184', '61', '11');
INSERT INTO `security_role_permission` VALUES ('185', '62', '11');
INSERT INTO `security_role_permission` VALUES ('192', '135', '11');
INSERT INTO `security_role_permission` VALUES ('193', '136', '11');
INSERT INTO `security_role_permission` VALUES ('194', '137', '11');
INSERT INTO `security_role_permission` VALUES ('195', '138', '11');
INSERT INTO `security_role_permission` VALUES ('196', '147', '11');
INSERT INTO `security_role_permission` VALUES ('197', '148', '11');
INSERT INTO `security_role_permission` VALUES ('198', '149', '11');
INSERT INTO `security_role_permission` VALUES ('199', '150', '11');
INSERT INTO `security_role_permission` VALUES ('200', '151', '11');
INSERT INTO `security_role_permission` VALUES ('201', '152', '11');
INSERT INTO `security_role_permission` VALUES ('202', '153', '11');
INSERT INTO `security_role_permission` VALUES ('203', '154', '11');
INSERT INTO `security_role_permission` VALUES ('204', '139', '11');
INSERT INTO `security_role_permission` VALUES ('205', '140', '11');
INSERT INTO `security_role_permission` VALUES ('206', '141', '11');
INSERT INTO `security_role_permission` VALUES ('207', '142', '11');
INSERT INTO `security_role_permission` VALUES ('208', '155', '11');
INSERT INTO `security_role_permission` VALUES ('209', '156', '11');
INSERT INTO `security_role_permission` VALUES ('210', '157', '11');
INSERT INTO `security_role_permission` VALUES ('211', '158', '11');
INSERT INTO `security_role_permission` VALUES ('235', '61', '12');
INSERT INTO `security_role_permission` VALUES ('236', '62', '12');
INSERT INTO `security_role_permission` VALUES ('263', '143', '12');
INSERT INTO `security_role_permission` VALUES ('264', '144', '12');
INSERT INTO `security_role_permission` VALUES ('265', '145', '12');
INSERT INTO `security_role_permission` VALUES ('266', '146', '12');
INSERT INTO `security_role_permission` VALUES ('267', '159', '12');
INSERT INTO `security_role_permission` VALUES ('268', '160', '12');
INSERT INTO `security_role_permission` VALUES ('269', '161', '12');
INSERT INTO `security_role_permission` VALUES ('270', '162', '12');
INSERT INTO `security_role_permission` VALUES ('271', '135', '10');
INSERT INTO `security_role_permission` VALUES ('272', '136', '10');
INSERT INTO `security_role_permission` VALUES ('273', '137', '10');
INSERT INTO `security_role_permission` VALUES ('274', '138', '10');
INSERT INTO `security_role_permission` VALUES ('275', '147', '10');
INSERT INTO `security_role_permission` VALUES ('276', '148', '10');
INSERT INTO `security_role_permission` VALUES ('277', '149', '10');
INSERT INTO `security_role_permission` VALUES ('278', '150', '10');
INSERT INTO `security_role_permission` VALUES ('279', '163', '10');
INSERT INTO `security_role_permission` VALUES ('280', '151', '10');
INSERT INTO `security_role_permission` VALUES ('281', '152', '10');
INSERT INTO `security_role_permission` VALUES ('282', '153', '10');
INSERT INTO `security_role_permission` VALUES ('283', '154', '10');
INSERT INTO `security_role_permission` VALUES ('284', '164', '10');
INSERT INTO `security_role_permission` VALUES ('285', '165', '10');
INSERT INTO `security_role_permission` VALUES ('286', '166', '10');
INSERT INTO `security_role_permission` VALUES ('287', '167', '10');
INSERT INTO `security_role_permission` VALUES ('288', '139', '10');
INSERT INTO `security_role_permission` VALUES ('289', '140', '10');
INSERT INTO `security_role_permission` VALUES ('290', '141', '10');
INSERT INTO `security_role_permission` VALUES ('291', '142', '10');
INSERT INTO `security_role_permission` VALUES ('292', '155', '10');
INSERT INTO `security_role_permission` VALUES ('293', '156', '10');
INSERT INTO `security_role_permission` VALUES ('294', '157', '10');
INSERT INTO `security_role_permission` VALUES ('295', '158', '10');
INSERT INTO `security_role_permission` VALUES ('296', '168', '10');
INSERT INTO `security_role_permission` VALUES ('297', '143', '10');
INSERT INTO `security_role_permission` VALUES ('298', '144', '10');
INSERT INTO `security_role_permission` VALUES ('299', '145', '10');
INSERT INTO `security_role_permission` VALUES ('300', '146', '10');
INSERT INTO `security_role_permission` VALUES ('301', '159', '10');
INSERT INTO `security_role_permission` VALUES ('302', '160', '10');
INSERT INTO `security_role_permission` VALUES ('303', '161', '10');
INSERT INTO `security_role_permission` VALUES ('304', '162', '10');
INSERT INTO `security_role_permission` VALUES ('305', '169', '10');
INSERT INTO `security_role_permission` VALUES ('306', '25', '11');
INSERT INTO `security_role_permission` VALUES ('307', '26', '11');
INSERT INTO `security_role_permission` VALUES ('308', '27', '11');
INSERT INTO `security_role_permission` VALUES ('309', '28', '11');
INSERT INTO `security_role_permission` VALUES ('310', '163', '11');
INSERT INTO `security_role_permission` VALUES ('311', '164', '11');
INSERT INTO `security_role_permission` VALUES ('312', '165', '11');
INSERT INTO `security_role_permission` VALUES ('313', '166', '11');
INSERT INTO `security_role_permission` VALUES ('314', '167', '11');
INSERT INTO `security_role_permission` VALUES ('315', '168', '11');
INSERT INTO `security_role_permission` VALUES ('316', '25', '12');
INSERT INTO `security_role_permission` VALUES ('317', '26', '12');
INSERT INTO `security_role_permission` VALUES ('318', '27', '12');
INSERT INTO `security_role_permission` VALUES ('319', '28', '12');
INSERT INTO `security_role_permission` VALUES ('320', '169', '12');
INSERT INTO `security_role_permission` VALUES ('330', '25', '10');
INSERT INTO `security_role_permission` VALUES ('331', '26', '10');
INSERT INTO `security_role_permission` VALUES ('332', '27', '10');
INSERT INTO `security_role_permission` VALUES ('333', '28', '10');
INSERT INTO `security_role_permission` VALUES ('334', null, null);
INSERT INTO `security_role_permission` VALUES ('335', null, null);
INSERT INTO `security_role_permission` VALUES ('336', null, null);
INSERT INTO `security_role_permission` VALUES ('337', null, null);
INSERT INTO `security_role_permission` VALUES ('338', null, null);
INSERT INTO `security_role_permission` VALUES ('339', null, null);
INSERT INTO `security_role_permission` VALUES ('340', null, null);
INSERT INTO `security_role_permission` VALUES ('341', '163', '9');
INSERT INTO `security_role_permission` VALUES ('342', '164', '9');
INSERT INTO `security_role_permission` VALUES ('343', '165', '9');
INSERT INTO `security_role_permission` VALUES ('344', '166', '9');
INSERT INTO `security_role_permission` VALUES ('345', '167', '9');
INSERT INTO `security_role_permission` VALUES ('346', '168', '9');
INSERT INTO `security_role_permission` VALUES ('347', '169', '9');

-- ----------------------------
-- Table structure for security_room
-- ----------------------------
DROP TABLE IF EXISTS `security_room`;
CREATE TABLE `security_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `contain` int(11) DEFAULT NULL,
  `used` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `building_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `building_id` (`building_id`),
  CONSTRAINT `security_room_ibfk_1` FOREIGN KEY (`building_id`) REFERENCES `security_building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_room
-- ----------------------------
INSERT INTO `security_room` VALUES ('13', '3A222', '6', '1', '110120119114', '40');
INSERT INTO `security_room` VALUES ('14', '25#222', '6', '4', '12564879', '35');

-- ----------------------------
-- Table structure for security_student
-- ----------------------------
DROP TABLE IF EXISTS `security_student`;
CREATE TABLE `security_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK83D5603CAA7F91E` (`room_id`),
  CONSTRAINT `FK83D5603CAA7F91E` FOREIGN KEY (`room_id`) REFERENCES `security_room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_student
-- ----------------------------
INSERT INTO `security_student` VALUES ('9', '3120757217', '许大帅', '男', '大四', '15878397778', '13');
INSERT INTO `security_student` VALUES ('10', '312548789', '李四', '女', '大一', '154879843', '14');

-- ----------------------------
-- Table structure for security_student_room
-- ----------------------------
DROP TABLE IF EXISTS `security_student_room`;
CREATE TABLE `security_student_room` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `security_student_room_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `security_student` (`id`),
  CONSTRAINT `security_student_room_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `security_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_student_room
-- ----------------------------

-- ----------------------------
-- Table structure for security_user
-- ----------------------------
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `realname` varchar(32) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `status` varchar(16) NOT NULL,
  `username` varchar(32) NOT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD607B56A453A1286` (`org_id`),
  CONSTRAINT `FKD607B56A453A1286` FOREIGN KEY (`org_id`) REFERENCES `security_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_user
-- ----------------------------
INSERT INTO `security_user` VALUES ('1', '2012-08-03 14:58:38', '211450675@qq.com', '1ebf7571ec48f0322fe3229f74056efa8b688765', '15677092732', '徐大牛', '1975a093c19f81ce', 'enabled', 'admin', '12');
INSERT INTO `security_user` VALUES ('25', '2016-03-08 09:15:00', 'zongwc@glut.edu.cn', '0b0e9a6d44c1fd86db12abf67e4fc31e5fd996c7', '15077581236', '总务处张三', '3c28f62105f62eae', 'enabled', 'zongwc', '13');
INSERT INTO `security_user` VALUES ('26', '2016-03-08 09:38:50', 'lougb@glut.edu.cn', 'a3e59fa29926f5e9bb90a5efa4b6e574f85bcdfd', '18964898560', '楼管部李四', '42e1905c20e0b0ab', 'enabled', 'lougb', '14');
INSERT INTO `security_user` VALUES ('27', '2016-03-08 09:39:07', 'weixb@glut.edu.cn', '0cf7cc9ec75d6f346e15098d23dc5abe682f4ca7', '13696963278', '维修部王五', '85cb704677689ace', 'enabled', 'weixb', '15');
INSERT INTO `security_user` VALUES ('34', '2016-05-14 15:08:46', '1512698756@qq.com', '59d72349f1cca32b97d01442bc126e3892f19633', '15877269269', '大帅', '4bca3148b75e3df5', 'enabled', 'root', '12');
INSERT INTO `security_user` VALUES ('35', '2016-05-15 20:20:22', '', '534f8ca86e628642abf528f6fb65127dbc56bbfd', '', '楼管部2号', 'decb6edd45a86742', 'enabled', 'lougb2', '14');

-- ----------------------------
-- Table structure for security_user_role
-- ----------------------------
DROP TABLE IF EXISTS `security_user_role`;
CREATE TABLE `security_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priority` int(11) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6DD3562BC592DFF7` (`role_id`),
  KEY `FK6DD3562B6ABDA3D7` (`user_id`),
  CONSTRAINT `FK6DD3562B6ABDA3D7` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`),
  CONSTRAINT `FK6DD3562BC592DFF7` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_user_role
-- ----------------------------
INSERT INTO `security_user_role` VALUES ('33', '99', '9', '34');

-- ----------------------------
-- Table structure for security_violation
-- ----------------------------
DROP TABLE IF EXISTS `security_violation`;
CREATE TABLE `security_violation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `student` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `manager` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_violation
-- ----------------------------
INSERT INTO `security_violation` VALUES ('1', '25#330', '违规使用电器', '2016-04-23', 'kate', 'disabled', 'manager');
INSERT INTO `security_violation` VALUES ('2', '25#321', '违规使用大功率电器', '2016-04-23', '女司机', 'disabled', '男司机');
INSERT INTO `security_violation` VALUES ('4', '1A110', '使用大功率电', '2016-04-22', '洋芋也', 'enabled', '11122233');
