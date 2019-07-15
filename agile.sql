/*
Navicat MySQL Data Transfer

Source Server         : zhao
Source Server Version : 50644
Source Host           : 47.96.144.17:3306
Source Database       : agile

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-07-15 15:36:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pdf_transfer_word`
-- ----------------------------
DROP TABLE IF EXISTS `pdf_transfer_word`;
CREATE TABLE `pdf_transfer_word` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `pdf_url` varchar(500) DEFAULT NULL COMMENT 'pdf文件路径',
  `word_url` varchar(500) DEFAULT NULL COMMENT 'word文件路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdf_transfer_word
-- ----------------------------
INSERT INTO `pdf_transfer_word` VALUES ('081e0763fe4044a4b5b4235efc463d63', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/318bdd522a7140478b1a280452101985/Javahuashan.pdf', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/doc/6f74ec670495499395547985356239df/Javahuashan.doc');
INSERT INTO `pdf_transfer_word` VALUES ('0bd72d44bf80483ca9396bc929f671d3', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/854114be655d498bbaf123412185c419/Javahuashan.pdf', null);
INSERT INTO `pdf_transfer_word` VALUES ('1022185d420a4ec6b48e25253f07f290', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/e4b7f0ebb39a4b458b296b0b67e4c0eb/H5方案_20190613.pdf', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/doc/8b39758dd5b84795af7d930a64867d88/H5方案_20190613.doc');
INSERT INTO `pdf_transfer_word` VALUES ('7a3b83ae49b14e97b5258abecb2b87f4', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/b952091550bc4aa8962cc49ac7c0b277/Javahuashan.pdf', null);
INSERT INTO `pdf_transfer_word` VALUES ('7b4debf8905146ac8fc62014b95909a4', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/9f9e6d586e6b42e0bb02a4ca5aaced62/Javahuashan.pdf', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/doc/63d8e15dfe51461f9e0b7d24e7318542/Javahuashan.doc');
INSERT INTO `pdf_transfer_word` VALUES ('98c6794a561a45efa0e7b7bdec4a8681', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/e2d5a0ebc8cd4a719a25876442ab4339/H5方案_20190613.pdf', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/doc/cb89b415a125422eb87d66fabbbfbc2e/H5方案_20190613.doc');
INSERT INTO `pdf_transfer_word` VALUES ('f21ae05b178440f1b313959e73a6a76b', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/pdf/932939cb698248ea8b8bc6f46cc120fc/H5方案_20190613.pdf', 'http://uface-park-pay.oss-cn-hangzhou.aliyuncs.com/doc/850d560049e648b1aae49ebe5d02008b/H5方案_20190613.doc');
