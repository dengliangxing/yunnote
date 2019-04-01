/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : mynote

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-04-01 21:34:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collectId` varchar(100) NOT NULL,
  `noteId` varchar(100) DEFAULT NULL,
  `noteBookId` varchar(100) DEFAULT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `noteBookType` varchar(100) DEFAULT NULL,
  `noteBookName` varchar(100) DEFAULT NULL,
  `noteBookDescription` varchar(100) DEFAULT NULL,
  `noteBookStatus` varchar(100) DEFAULT NULL,
  `noteStatus` varchar(100) DEFAULT NULL,
  `noteType` varchar(100) DEFAULT NULL,
  `noteTitle` varchar(100) DEFAULT NULL,
  `noteBookTitle` varchar(100) DEFAULT NULL,
  `noteBody` varchar(100) DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `createName` varchar(100) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updator` varchar(100) DEFAULT NULL,
  `updateName` varchar(100) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `collectStatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`collectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for `note`
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `noteId` varchar(100) NOT NULL,
  `noteBookId` varchar(100) DEFAULT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `noteStatusId` varchar(100) DEFAULT NULL,
  `noteStatus` varchar(100) DEFAULT NULL,
  `noteTypeId` varchar(100) DEFAULT NULL,
  `noteType` varchar(100) DEFAULT NULL,
  `noteTitle` varchar(100) DEFAULT NULL,
  `noteBody` varchar(100) DEFAULT NULL,
  `isPublic` varchar(100) DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `createName` varchar(100) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updator` varchar(100) DEFAULT NULL,
  `updateName` varchar(100) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `noteBookTitle` varchar(100) DEFAULT NULL,
  `collectNoteStatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`noteId`),
  KEY `note_ibfk_1` (`noteBookId`),
  KEY `note_ibfk_2` (`userId`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`noteBookId`) REFERENCES `notebook` (`noteBookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `note_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('0d7eb3db-620a-496e-b90c-db859e52a9b6', '4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', null, '1', null, '心情', '心情', '心情', '', '00000', 'sysAdmin', '2019-03-31', '00000', 'sysAdmin', '2019-03-31', '心情', null);
INSERT INTO `note` VALUES ('8eab24a3-2074-4c70-a9c6-3a6d2852bdf5', '4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', null, '1', null, '心情', '新青5', '0', '新青5', '00000', 'sysAdmin', '2019-03-31', null, null, null, '心情', null);
INSERT INTO `note` VALUES ('be67970c-b3d7-49c8-9f8f-dffba4cbdbb6', '4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', null, '1', null, '心情', '心情3', '0', '新青3', '00000', 'sysAdmin', '2019-03-31', null, null, null, '心情', null);
INSERT INTO `note` VALUES ('d5b238d9-eba0-4a45-9a0c-464c973cbc64', '4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', null, '1', null, '心情', '心情2', '0', '心情2', '00000', 'sysAdmin', '2019-03-31', null, null, null, '心情', null);
INSERT INTO `note` VALUES ('f0f7fbff-a3a6-4508-9b10-90dd6c406315', '4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', null, '1', null, '心情', '心情1', '0', '心情1', '00000', 'sysAdmin', '2019-03-31', null, null, null, '心情', null);
INSERT INTO `note` VALUES ('f642782a-3f11-4a0e-a5f1-13c611582734', '4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', null, '1', null, '心情', '新青4', '0', '西宁4', '00000', 'sysAdmin', '2019-03-31', null, null, null, '心情', null);

-- ----------------------------
-- Table structure for `notebook`
-- ----------------------------
DROP TABLE IF EXISTS `notebook`;
CREATE TABLE `notebook` (
  `noteBookId` varchar(100) NOT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `noteBookType` varchar(100) DEFAULT NULL,
  `noteBookName` varchar(100) DEFAULT NULL,
  `noteBookDescription` longtext,
  `creator` varchar(100) DEFAULT NULL,
  `createName` varchar(100) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updator` varchar(100) DEFAULT NULL,
  `updateName` varchar(100) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `noteBookStatus` varchar(100) DEFAULT NULL,
  `collectNoteBookStatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`noteBookId`),
  KEY `notebook_ibfk_1` (`userId`),
  CONSTRAINT `notebook_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notebook
-- ----------------------------
INSERT INTO `notebook` VALUES ('4318cac6-b52d-4e6c-baef-7490b2f0cc3b', '00000', '心情', '心情', '', '00000', 'sysAdmin', '2019-03-31', '00000', 'sysAdmin', '2019-03-31', '1', null);

-- ----------------------------
-- Table structure for `public`
-- ----------------------------
DROP TABLE IF EXISTS `public`;
CREATE TABLE `public` (
  `publicId` varchar(100) NOT NULL,
  `noteId` varchar(100) DEFAULT NULL,
  `noteName` varchar(100) DEFAULT NULL,
  `noteBody` varchar(100) DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `isPublic` varchar(100) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `createName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`publicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of public
-- ----------------------------
INSERT INTO `public` VALUES ('09a6bba1-b2d5-44d1-9916-22fd4b60f4de', 'f642782a-3f11-4a0e-a5f1-13c611582734', '新青4', '0', '00000', '1', '2019-03-31', 'sysAdmin');
INSERT INTO `public` VALUES ('62d1aee8-4da0-4d06-8e20-c59d59352db5', '0d7eb3db-620a-496e-b90c-db859e52a9b6', '心情', '心情', '00000', '1', '2019-03-31', 'sysAdmin');
INSERT INTO `public` VALUES ('7ec0123a-a0b7-4503-a90b-397d67dc9d83', '8eab24a3-2074-4c70-a9c6-3a6d2852bdf5', '新青5', '0', '00000', '1', '2019-03-31', 'sysAdmin');
INSERT INTO `public` VALUES ('99976f4e-cf5c-4a89-a6c0-00e322f0f915', 'f0f7fbff-a3a6-4508-9b10-90dd6c406315', '心情1', '0', '00000', '1', '2019-03-31', 'sysAdmin');
INSERT INTO `public` VALUES ('bc61c9b2-6a71-4a7d-9e03-3bf98069de5b', 'd5b238d9-eba0-4a45-9a0c-464c973cbc64', '心情2', '0', '00000', '1', '2019-03-31', 'sysAdmin');
INSERT INTO `public` VALUES ('ecea7f24-7743-4261-bcb5-8376595800fd', 'be67970c-b3d7-49c8-9f8f-dffba4cbdbb6', '心情3', '0', '00000', '1', '2019-03-31', 'sysAdmin');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` varchar(100) NOT NULL,
  `roleType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('00000', 'sysAdmin');
INSERT INTO `role` VALUES ('11111', 'commonUser');
INSERT INTO `role` VALUES ('22222', 'commonAdmin');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(100) NOT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `userPassword` varchar(100) DEFAULT NULL,
  `userNick` varchar(100) DEFAULT NULL,
  `roleId` varchar(100) DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `createName` varchar(100) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updator` varchar(100) DEFAULT NULL,
  `updateName` varchar(100) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `user_ibfk_1` (`roleId`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000', 'sysAdmin', '123456', null, '00000', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4c27c7cc-c0dd-4d08-ae43-03fc13ac572e', 'admin1', '123456', null, '22222', '00000', 'sysAdmin', '2019-03-31', null, null, null);
INSERT INTO `user` VALUES ('c78de56f-d879-4ffc-953b-638e9564bf16', 'hxd111', '123456', null, '11111', '00000', 'sysAdmin', '2019-03-31', null, null, null);
