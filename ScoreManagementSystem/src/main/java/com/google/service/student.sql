/*
 Navicat Premium Data Transfer

 Source Server         : first
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : student

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 06/27/2017 15:40:52 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`
(
    `id`            varchar(30) NOT NULL,
    `name`          varchar(30) NOT NULL,
    `circuit_score` varchar(30) NOT NULL,
    `en_RW_score`   varchar(30) NOT NULL,
    `physics_score` varchar(30) NOT NULL,
    `history_score` varchar(30) NOT NULL,
    `total_score`   varchar(30) DEFAULT '0',
    `gpa`           varchar(30) DEFAULT '0',
    `rank`          varchar(30) DEFAULT '0'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `info`
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`
(
    `id`      varchar(30) NOT NULL,
    `name`    varchar(30) NOT NULL,
    `cpp`     int(11)     NOT NULL,
    `english` int(11)     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

SET FOREIGN_KEY_CHECKS = 1;
