/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : CakeShop

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `address` varchar(200) NOT NULL COMMENT '地址',
  `name` varchar(200) NOT NULL COMMENT '收货人',
  `phone` varchar(200) NOT NULL COMMENT '电话',
  `isdefault` varchar(200) NOT NULL COMMENT '是否默认地址[是/否]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='地址';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '2030-03-11 17:13:13', '1', '宇宙银河系金星1号', '金某', '13823888881', '是');
INSERT INTO `address` VALUES ('2', '2030-03-11 17:13:13', '2', '宇宙银河系木星1号', '木某', '13823888882', '是');
INSERT INTO `address` VALUES ('3', '2030-03-11 17:13:13', '3', '宇宙银河系水星1号', '水某', '13823888883', '是');
INSERT INTO `address` VALUES ('4', '2030-03-11 17:13:13', '4', '宇宙银河系火星1号', '火某', '13823888884', '是');
INSERT INTO `address` VALUES ('5', '2030-03-11 17:13:13', '5', '宇宙银河系土星1号', '土某', '13823888885', '是');
INSERT INTO `address` VALUES ('6', '2030-03-11 17:13:13', '6', '宇宙银河系月球1号', '月某', '13823888886', '是');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tablename` varchar(200) DEFAULT 'shangpinxinxi' COMMENT '蛋糕表名',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `goodid` bigint(20) NOT NULL COMMENT '蛋糕id',
  `goodname` varchar(200) DEFAULT NULL COMMENT '蛋糕名称',
  `picture` varchar(200) DEFAULT NULL COMMENT '图片',
  `buynumber` int(11) NOT NULL COMMENT '购买数量',
  `price` float DEFAULT NULL COMMENT '单价',
  `discountprice` float DEFAULT NULL COMMENT '会员价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', 'picture1', 'http://localhost:8080/CakeShop/upload/1638358782627.jpeg');
INSERT INTO `config` VALUES ('2', 'picture2', 'http://localhost:8080/CakeShop/upload/1638358793004.jpeg');
INSERT INTO `config` VALUES ('3', 'picture3', 'http://localhost:8080/CakeShop/upload/1638359046710.jpeg');
INSERT INTO `config` VALUES ('6', 'homepage', null);

-- ----------------------------
-- Table structure for discussshangpinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discussshangpinxinxi`;
CREATE TABLE `discussshangpinxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='蛋糕信息评论表';

-- ----------------------------
-- Records of discussshangpinxinxi
-- ----------------------------
INSERT INTO `discussshangpinxinxi` VALUES ('91', '2030-03-11 17:13:13', '1', '1', '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discussshangpinxinxi` VALUES ('92', '2030-03-11 17:13:13', '2', '2', '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discussshangpinxinxi` VALUES ('93', '2030-03-11 17:13:13', '3', '3', '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discussshangpinxinxi` VALUES ('94', '2030-03-11 17:13:13', '4', '4', '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discussshangpinxinxi` VALUES ('95', '2030-03-11 17:13:13', '5', '5', '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discussshangpinxinxi` VALUES ('96', '2030-03-11 17:13:13', '6', '6', '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` varchar(200) NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='新闻公告';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('81', '2030-03-11 17:13:13', '标题1', '简介1', 'http://localhost:8080/CakeShop/upload/news_picture1.jpg', '内容1');
INSERT INTO `news` VALUES ('82', '2030-03-11 17:13:13', '标题2', '简介2', 'http://localhost:8080/CakeShop/upload/news_picture2.jpg', '内容2');
INSERT INTO `news` VALUES ('83', '2030-03-11 17:13:13', '标题3', '简介3', 'http://localhost:8080/CakeShop/upload/news_picture3.jpg', '内容3');
INSERT INTO `news` VALUES ('84', '2030-03-11 17:13:13', '标题4', '简介4', 'http://localhost:8080/CakeShop/upload/news_picture4.jpg', '内容4');
INSERT INTO `news` VALUES ('85', '2030-03-11 17:13:13', '标题5', '简介5', 'http://localhost:8080/CakeShop/upload/news_picture5.jpg', '内容5');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `orderid` varchar(200) NOT NULL COMMENT '订单编号',
  `tablename` varchar(200) DEFAULT 'shangpinxinxi' COMMENT '蛋糕表名',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `goodid` bigint(20) NOT NULL COMMENT '蛋糕id',
  `goodname` varchar(200) DEFAULT NULL COMMENT '蛋糕名称',
  `picture` varchar(200) DEFAULT NULL COMMENT '蛋糕图片',
  `buynumber` int(11) NOT NULL COMMENT '购买数量',
  `price` float NOT NULL DEFAULT '0' COMMENT '价格/积分',
  `discountprice` float DEFAULT '0' COMMENT '折扣价格',
  `total` float NOT NULL DEFAULT '0' COMMENT '总价格/总积分',
  `discounttotal` float DEFAULT '0' COMMENT '折扣总价格',
  `type` int(11) DEFAULT '1' COMMENT '支付类型',
  `status` varchar(200) DEFAULT NULL COMMENT '状态',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderid` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for shangpinfenlei
-- ----------------------------
DROP TABLE IF EXISTS `shangpinfenlei`;
CREATE TABLE `shangpinfenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinfenlei` varchar(200) NOT NULL COMMENT '蛋糕分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shangpinfenlei` (`shangpinfenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='蛋糕分类';

-- ----------------------------
-- Records of shangpinfenlei
-- ----------------------------
INSERT INTO `shangpinfenlei` VALUES ('21', '2030-03-11 17:13:13', '蛋糕分类1');
INSERT INTO `shangpinfenlei` VALUES ('22', '2030-03-11 17:13:13', '蛋糕分类2');
INSERT INTO `shangpinfenlei` VALUES ('23', '2030-03-11 17:13:13', '蛋糕分类3');
INSERT INTO `shangpinfenlei` VALUES ('24', '2030-03-11 17:13:13', '蛋糕分类4');
INSERT INTO `shangpinfenlei` VALUES ('25', '2030-03-11 17:13:13', '蛋糕分类5');
INSERT INTO `shangpinfenlei` VALUES ('26', '2030-03-11 17:13:13', '蛋糕分类6');

-- ----------------------------
-- Table structure for shangpinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `shangpinxinxi`;
CREATE TABLE `shangpinxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinbianhao` varchar(200) DEFAULT NULL COMMENT '蛋糕编号',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '蛋糕名称',
  `shangpinfenlei` varchar(200) DEFAULT NULL COMMENT '蛋糕分类',
  `pinpai` varchar(200) DEFAULT NULL COMMENT '品牌',
  `zhongliang` varchar(200) DEFAULT NULL COMMENT '重量',
  `fengmian` varchar(200) DEFAULT NULL COMMENT '封面',
  `shifoutejia` varchar(200) DEFAULT NULL COMMENT '是否特价',
  `xiangqing` longtext COMMENT '详情',
  `shipin` varchar(200) DEFAULT NULL COMMENT '视频',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `price` float NOT NULL COMMENT '价格',
  `onelimittimes` int(11) DEFAULT '-1' COMMENT '单限',
  `alllimittimes` int(11) DEFAULT '-1' COMMENT '库存',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shangpinbianhao` (`shangpinbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1615454541698 DEFAULT CHARSET=utf8 COMMENT='蛋糕信息';

-- ----------------------------
-- Records of shangpinxinxi
-- ----------------------------
INSERT INTO `shangpinxinxi` VALUES ('31', '2030-03-11 17:13:13', '蛋糕编号1', '蛋糕名称1', '蛋糕分类1', '品牌1', '重量1', 'http://localhost:8080/CakeShop/upload/shangpinxinxi_fengmian1.jpg', '是', '详情1', '', '2030-12-01 19:41:02', '2', '99.9', '1', '99');
INSERT INTO `shangpinxinxi` VALUES ('32', '2030-03-11 17:13:13', '蛋糕编号2', '蛋糕名称2', '蛋糕分类2', '品牌2', '重量2', 'http://localhost:8080/CakeShop/upload/shangpinxinxi_fengmian2.jpg', '是', '详情2', '', '2030-03-11 17:13:13', '2', '99.9', '2', '99');
INSERT INTO `shangpinxinxi` VALUES ('33', '2030-03-11 17:13:13', '蛋糕编号3', '蛋糕名称3', '蛋糕分类3', '品牌3', '重量3', 'http://localhost:8080/CakeShop/upload/shangpinxinxi_fengmian3.jpg', '是', '详情3', '', '2030-03-11 17:13:13', '3', '99.9', '3', '99');
INSERT INTO `shangpinxinxi` VALUES ('34', '2030-03-11 17:13:13', '蛋糕编号4', '蛋糕名称4', '蛋糕分类4', '品牌4', '重量4', 'http://localhost:8080/CakeShop/upload/shangpinxinxi_fengmian4.jpg', '是', '详情4', '', '2030-03-11 17:13:13', '4', '99.9', '4', '99');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Records of storeup
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES ('1', '1', 'abo', 'users', '管理员', '4gcuishpxtmxauf1nysf3lhpzxk4nw4n', '2030-03-11 17:21:18', '2030-12-01 20:46:59');
INSERT INTO `token` VALUES ('2', '1638358389713', '1', 'yonghu', '用户', 'ypff5llw3877f1dfap9pv8g4acce7fef', '2030-12-01 19:33:14', '2030-12-01 20:44:18');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'abo', 'abo', '管理员', '2030-03-11 17:13:13');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) NOT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) NOT NULL COMMENT '用户姓名',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `dianziyouxiang` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `dizhi` varchar(200) DEFAULT NULL COMMENT '地址',
  `money` float DEFAULT '0' COMMENT '余额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuzhanghao` (`yonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1638358389714 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES ('11', '2030-03-11 17:13:13', '用户1', '用户姓名1', '123456', '男', '1', '13823888881', '773890001@qq.com', '440300199101010001', '地址1', '100');
INSERT INTO `yonghu` VALUES ('12', '2030-03-11 17:13:13', '用户2', '用户姓名2', '123456', '男', '2', '13823888882', '773890002@qq.com', '440300199202020002', '地址2', '100');
INSERT INTO `yonghu` VALUES ('13', '2030-03-11 17:13:13', '用户3', '用户姓名3', '123456', '男', '3', '13823888883', '773890003@qq.com', '440300199303030003', '地址3', '100');
INSERT INTO `yonghu` VALUES ('14', '2030-03-11 17:13:13', '用户4', '用户姓名4', '123456', '男', '4', '13823888884', '773890004@qq.com', '440300199404040004', '地址4', '100');
INSERT INTO `yonghu` VALUES ('15', '2030-03-11 17:13:13', '用户5', '用户姓名5', '123456', '男', '5', '13823888885', '773890005@qq.com', '440300199505050005', '地址5', '100');
INSERT INTO `yonghu` VALUES ('16', '2030-03-11 17:13:13', '用户6', '用户姓名6', '123456', '男', '6', '13823888886', '773890006@qq.com', '440300199606060006', '地址6', '100');
INSERT INTO `yonghu` VALUES ('1638358389713', '2030-12-01 19:33:09', '1', '1', '1', null, '11', '13212345678', '11@qq.com', '321123456789012312', '11', '0');
