/*
Source Host           : localhost:3306
Source Database       : cms
*/

-- ----------------------------
-- Table structure for user
-- ----------------------------
create table user
(
	id int not null primary key auto_increment,
	username varchar(30) not null unique,
	password char(20) not null,
	status int not null
)CHARACTER SET 'utf8'
COLLATE 'utf8_general_ci';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'jyp', '123456', 0);
INSERT INTO `user` VALUES (2, 'admin', '123456', 0);
INSERT INTO `user` VALUES (3, 'ly', '123456', 1);
INSERT INTO `user` VALUES (4, 'ghost', '123456', 2);

CREATE TABLE role(
	id TINYINT PRIMARY KEY AUTO_INCREMENT comment '角色表 ID',
	rolename VARCHAR(20) NOT NULL comment '角色名称',
	role_string VARCHAR(20) NOT NULL comment '角色字符串'
)engine=innodb auto_increment=1 DEFAULT charset=utf8 comment='角色信息表';

