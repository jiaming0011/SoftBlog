/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-02-11 23:50:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `updatetime` datetime NOT NULL,
  `blogger_id` int(11) NOT NULL,
  `articlecontent_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `articlestatus_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk10` (`blogger_id`),
  KEY `pk11` (`articlecontent_id`),
  KEY `pk12` (`tag_id`),
  KEY `pk13` (`articlestatus_id`),
  CONSTRAINT `pk10` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk11` FOREIGN KEY (`articlecontent_id`) REFERENCES `articlecontent` (`id`),
  CONSTRAINT `pk12` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `pk13` FOREIGN KEY (`articlestatus_id`) REFERENCES `articlestatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `articlecontent`
-- ----------------------------
DROP TABLE IF EXISTS `articlecontent`;
CREATE TABLE `articlecontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of articlecontent
-- ----------------------------

-- ----------------------------
-- Table structure for `articlefavorite`
-- ----------------------------
DROP TABLE IF EXISTS `articlefavorite`;
CREATE TABLE `articlefavorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk30` (`blogger_id`),
  KEY `pk31` (`article_id`),
  CONSTRAINT `pk30` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk31` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of articlefavorite
-- ----------------------------

-- ----------------------------
-- Table structure for `articlestatus`
-- ----------------------------
DROP TABLE IF EXISTS `articlestatus`;
CREATE TABLE `articlestatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reading` int(11) DEFAULT NULL,
  `like` int(11) DEFAULT NULL,
  `reviews` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of articlestatus
-- ----------------------------

-- ----------------------------
-- Table structure for `blacklist`
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id1` int(11) NOT NULL,
  `blogger_id2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk60` (`blogger_id1`),
  KEY `pk61` (`blogger_id2`),
  CONSTRAINT `pk60` FOREIGN KEY (`blogger_id1`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk61` FOREIGN KEY (`blogger_id2`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for `blogger`
-- ----------------------------
DROP TABLE IF EXISTS `blogger`;
CREATE TABLE `blogger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `bloggerinfo_id` int(11) NOT NULL,
  `logininfo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk1` (`type_id`),
  KEY `pk2` (`bloggerinfo_id`),
  KEY `pk3` (`logininfo_id`),
  CONSTRAINT `pk1` FOREIGN KEY (`type_id`) REFERENCES `bloggertype` (`id`),
  CONSTRAINT `pk2` FOREIGN KEY (`bloggerinfo_id`) REFERENCES `bloggerinfo` (`id`),
  CONSTRAINT `pk3` FOREIGN KEY (`logininfo_id`) REFERENCES `logininfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of blogger
-- ----------------------------

-- ----------------------------
-- Table structure for `bloggerfavorite`
-- ----------------------------
DROP TABLE IF EXISTS `bloggerfavorite`;
CREATE TABLE `bloggerfavorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id1` int(11) NOT NULL,
  `blogger_id2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk40` (`blogger_id1`),
  KEY `pk41` (`blogger_id2`),
  CONSTRAINT `pk40` FOREIGN KEY (`blogger_id1`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk41` FOREIGN KEY (`blogger_id2`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bloggerfavorite
-- ----------------------------

-- ----------------------------
-- Table structure for `bloggerinfo`
-- ----------------------------
DROP TABLE IF EXISTS `bloggerinfo`;
CREATE TABLE `bloggerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `brief` varchar(255) COLLATE utf8_bin NOT NULL,
  `image` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bloggerinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `bloggertype`
-- ----------------------------
DROP TABLE IF EXISTS `bloggertype`;
CREATE TABLE `bloggertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bloggertype
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin NOT NULL,
  `updatetime` datetime NOT NULL,
  `blogger_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk20` (`blogger_id`),
  KEY `pk21` (`article_id`),
  CONSTRAINT `pk20` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk21` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `logininfo`
-- ----------------------------
DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of logininfo
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin NOT NULL,
  `sendtime` datetime NOT NULL,
  `blogger_id1` int(11) NOT NULL,
  `blogger_id2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk50` (`blogger_id1`),
  KEY `pk51` (`blogger_id2`),
  CONSTRAINT `pk50` FOREIGN KEY (`blogger_id1`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk51` FOREIGN KEY (`blogger_id2`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for `tagfavorite`
-- ----------------------------
DROP TABLE IF EXISTS `tagfavorite`;
CREATE TABLE `tagfavorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk70` (`blogger_id`),
  KEY `pk71` (`tag_id`),
  CONSTRAINT `pk70` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `pk71` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tagfavorite
-- ----------------------------
