/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : hadoop_test

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 09/07/2021 14:26:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for application_info
-- ----------------------------
DROP TABLE IF EXISTS `application_info`;
CREATE TABLE `application_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务id',
  `job_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `state` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务当前状态',
  `product_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '该任务所处理的产品号',
  `satellite_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卫星名称',
  `job_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务提交的用户',
  `final_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务最终运行状态',
  `started_time` datetime(0) NULL DEFAULT NULL COMMENT '任务开始时间',
  `finished_time` datetime(0) NULL DEFAULT NULL COMMENT '任务结束时间',
  `elapsed_time` float(50, 3) NULL DEFAULT NULL COMMENT '任务运行时间',
  `tracking_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务详细信息链接',
  `timestamp` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务完成时间戳',
  `province_id` int(0) NULL DEFAULT NULL COMMENT '省市编号',
  `step_id` int(0) NULL DEFAULT NULL COMMENT '处理的第几步',
  `result_path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '处理的第几步结果存放路径',
  `remark` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `orbit_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '圈号',
  `scene_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '景号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `final_status`(`final_status`) USING BTREE,
  INDEX `job_id_index`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15534 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Application数据表,当天' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for application_info_history
-- ----------------------------
DROP TABLE IF EXISTS `application_info_history`;
CREATE TABLE `application_info_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务id',
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `state` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务当前状态',
  `product_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '该任务所处理的产品号',
  `satellite_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卫星名称',
  `job_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务提交的用户',
  `final_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务最终运行状态',
  `started_time` datetime(0) NULL DEFAULT NULL COMMENT '任务开始时间',
  `finished_time` datetime(0) NULL DEFAULT NULL COMMENT '任务结束时间',
  `elapsed_time` float(50, 3) NULL DEFAULT NULL COMMENT '任务运行时间',
  `tracking_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务详细信息链接',
  `timestamp` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务完成时间戳',
  `province_id` int(0) NULL DEFAULT NULL COMMENT '省市编号，对应表13的provinceID',
  `step_id` int(0) NULL DEFAULT NULL COMMENT '处理的第几步，对应表14的stepID',
  `result_path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '处理的第几步结果存放路径',
  `remark` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `orbit_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '圈号',
  `scene_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '景号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `final_status`(`final_status`) USING BTREE,
  INDEX `job_id_index`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116219036 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Application数据历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for application_info_run
-- ----------------------------
DROP TABLE IF EXISTS `application_info_run`;
CREATE TABLE `application_info_run`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务id',
  `job_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `state` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务当前状态',
  `product_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '该任务所处理的产品号',
  `satellite_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卫星名称',
  `job_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务提交的用户',
  `final_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务最终运行状态',
  `started_time` datetime(0) NULL DEFAULT NULL COMMENT '任务开始时间',
  `finished_time` datetime(0) NULL DEFAULT NULL COMMENT '任务结束时间',
  `elapsed_time` float(50, 3) NULL DEFAULT NULL COMMENT '任务运行时间',
  `tracking_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务详细信息链接',
  `timestamp` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务完成时间戳',
  `province_id` int(0) NULL DEFAULT NULL COMMENT '省市编号，对应表13的provinceID',
  `step_id` int(0) NULL DEFAULT NULL COMMENT '处理的第几步，对应表14的stepID',
  `result_path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '处理的第几步结果存放路径',
  `remark` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `orbit_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '圈号',
  `scene_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '景号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `final_status`(`final_status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1160342453 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '正在运行的Application任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_conf_cluster
-- ----------------------------
DROP TABLE IF EXISTS `basic_conf_cluster`;
CREATE TABLE `basic_conf_cluster`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成(主键)',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机器别名',
  `domain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机器域名',
  `ip4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机器IPV4地址',
  `ip6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机器IPV6地址',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机器属性',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '节点信息配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for basic_conf_pp_satellite
-- ----------------------------
DROP TABLE IF EXISTS `basic_conf_pp_satellite`;
CREATE TABLE `basic_conf_pp_satellite`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `statellite_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卫星名（对应pp系统的卫星名，必须一致）',
  `database_driver` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据库驱动',
  `database_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据库url（格式必须一致）',
  `database_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据库用户名',
  `database_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据库密码',
  `pk` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '自增Id记录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'PP系统数据表维护' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_conf_provincial
-- ----------------------------
DROP TABLE IF EXISTS `basic_conf_provincial`;
CREATE TABLE `basic_conf_provincial`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `province_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省市名称',
  `code` int(0) NOT NULL COMMENT '省市编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省份信息配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for basic_conf_satellite
-- ----------------------------
DROP TABLE IF EXISTS `basic_conf_satellite`;
CREATE TABLE `basic_conf_satellite`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '型号编号，自动生成（主键）',
  `satellite_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '遥感卫星名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卫星信息配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for basic_conf_satellite_process
-- ----------------------------
DROP TABLE IF EXISTS `basic_conf_satellite_process`;
CREATE TABLE `basic_conf_satellite_process`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '流程编号，自动生成（主键）',
  `satellite_id` int(0) NOT NULL COMMENT '遥感卫星编号，关联遥感卫星型号数据表ID',
  `step_id` int(0) NOT NULL COMMENT '任务处理阶段编号，关联任务处理阶段信息表ID',
  `sort_no` int(0) NOT NULL COMMENT '处理流程顺序编号，每一个卫星型号对应一个处理顺序，要保证同一卫星型号的处理流程顺序号不能重复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卫星处理步骤配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for basic_conf_step
-- ----------------------------
DROP TABLE IF EXISTS `basic_conf_step`;
CREATE TABLE `basic_conf_step`  (
  `id` int(0) UNSIGNED NOT NULL COMMENT '自动生成（主键）',
  `step_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '处理阶段名称',
  `suffix_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '处理阶段结束状态文件后缀名',
  `step_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for cluster_info
-- ----------------------------
DROP TABLE IF EXISTS `cluster_info`;
CREATE TABLE `cluster_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键（自动递增）',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `apps_submit` int(0) NOT NULL COMMENT 'Application提交数量',
  `apps_complet` int(0) NOT NULL COMMENT 'Application完成数量',
  `apps_pending` int(0) NOT NULL COMMENT 'Application等待的数量',
  `apps_running` int(0) NOT NULL COMMENT '正在运行的Application的数量',
  `apps_failed` int(0) NOT NULL COMMENT 'Application失败的数量',
  `apps_killed` int(0) NOT NULL COMMENT '杀死的应用程序的数量',
  `memory_reserved` bigint(0) NOT NULL COMMENT '保留的内存量',
  `memory_available` bigint(0) NOT NULL COMMENT '可用的内存量',
  `memory_allocated` bigint(0) NOT NULL COMMENT '分配的内存量',
  `memory_total` bigint(0) NOT NULL COMMENT '内存的总量',
  `vcore_reserved` bigint(0) NOT NULL COMMENT '保留的虚拟核的数量',
  `vcore_available` bigint(0) NOT NULL COMMENT '可用虚拟核的数量',
  `vcore_allocated` bigint(0) NOT NULL COMMENT '分配的虚拟核的数量',
  `vcore_total` bigint(0) NOT NULL COMMENT '虚拟核的总数',
  `containers_allocated` int(0) NOT NULL COMMENT '分配的containers数量',
  `containers_reserved` int(0) NOT NULL COMMENT '预留的containers数量',
  `containers_pending` int(0) NOT NULL COMMENT '待处理的containers数量',
  `nodes_total` int(0) NOT NULL COMMENT '节点的总数',
  `nodes_active` int(0) NOT NULL COMMENT '活动节点的数量',
  `nodes_lost` int(0) NOT NULL COMMENT '丢失节点的数量',
  `nodes_unhealthy` int(0) NOT NULL COMMENT '不健康节点的数量',
  `nodes_decommissioning` int(0) NOT NULL COMMENT '正在退役的节点数量',
  `nodes_decommissioned` int(0) NOT NULL COMMENT '已退役节点的数量',
  `nodes_rebooted` int(0) NOT NULL COMMENT '重新启动的节点数',
  `nodes_shutdown` int(0) NOT NULL COMMENT '关闭节点的数量',
  `created_at` datetime(0) NULL DEFAULT NULL COMMENT '数据插入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15237 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '集群状态信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for data_push_info
-- ----------------------------
DROP TABLE IF EXISTS `data_push_info`;
CREATE TABLE `data_push_info`  (
  `id` int(0) UNSIGNED NOT NULL COMMENT '自动生成（主键）',
  `province_id` int(0) NOT NULL COMMENT '省市编号，对应表13的provinceID',
  `send_date` datetime(0) NOT NULL COMMENT '任务推送时间（精确到当天）',
  `number` int(0) NOT NULL COMMENT '当天任务推送总数',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省份数据推送表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for data_push_info_history
-- ----------------------------
DROP TABLE IF EXISTS `data_push_info_history`;
CREATE TABLE `data_push_info_history`  (
  `id` int(0) UNSIGNED NOT NULL COMMENT '自动生成（主键）',
  `province_id` int(0) NOT NULL COMMENT '省市编号，对应表13的provinceID',
  `send_date` datetime(0) NOT NULL COMMENT '任务推送时间（精确到当天）',
  `number` int(0) NOT NULL COMMENT '当天任务推送总数',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省份数据推送历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for image_process_flow
-- ----------------------------
DROP TABLE IF EXISTS `image_process_flow`;
CREATE TABLE `image_process_flow`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `job_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务id',
  `satellite_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卫星名',
  `orbit_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '圈号',
  `scene_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '景号',
  `product_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品号',
  `province_id` int(0) NULL DEFAULT NULL COMMENT '省份编号',
  `started_time` datetime(0) NOT NULL COMMENT '任务开始时间',
  `finished_time` datetime(0) NULL DEFAULT NULL COMMENT '任务结束时间',
  `elapsed_time` float(50, 3) NULL DEFAULT NULL COMMENT '任务运行时间',
  `step_id` int(0) NOT NULL COMMENT '步骤编号',
  `state` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
  `pp` int(0) NULL DEFAULT NULL COMMENT '是否来自于pp',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 148600820 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图像处理流程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_info
-- ----------------------------
DROP TABLE IF EXISTS `map_info`;
CREATE TABLE `map_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_info_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应表5的id',
  `task_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Map-Task id',
  `task_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Map-Task名称（解压缩、云判……）',
  `map_node` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Map-Task运行所在的节点',
  `start_time` datetime(0) NOT NULL COMMENT 'Map-Task开始时间',
  `finished_time` datetime(0) NOT NULL COMMENT 'Map-Task结束时间',
  `elapsed_time` float NOT NULL COMMENT 'Map-Task运行时间',
  `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `job_info_id_index`(`job_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8522 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Map任务历史数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_info_history
-- ----------------------------
DROP TABLE IF EXISTS `map_info_history`;
CREATE TABLE `map_info_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_info_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应表5的id',
  `task_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Map-Task id',
  `task_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Map-Task名称（解压缩、云判……）',
  `map_node` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Map-Task运行所在的节点',
  `start_time` datetime(0) NOT NULL COMMENT 'Map-Task开始时间',
  `finished_time` datetime(0) NOT NULL COMMENT 'Map-Task结束时间',
  `elapsed_time` float NOT NULL COMMENT 'Map-Task运行时间',
  `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `job_info_id_index`(`job_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3735063 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Map任务历史数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for node_info
-- ----------------------------
DROP TABLE IF EXISTS `node_info`;
CREATE TABLE `node_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id(主键)',
  `node_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '节点id',
  `rack` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '此节点的机架位置(主键）',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '节点的状态',
  `host_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主机名',
  `http_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'HTTP地址',
  `last_health_update` datetime(0) NOT NULL COMMENT '最近一次报告状况',
  `hadoop_version` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'hadoop版本',
  `num_containers` bigint(0) NOT NULL COMMENT '运行的容器的总数,运行的任务数量',
  `used_memory` bigint(0) NOT NULL COMMENT '当前使用的内存',
  `avail_memory` bigint(0) NOT NULL COMMENT '当前可用的内存',
  `used_vcore` bigint(0) NOT NULL COMMENT '使用的vcore总数',
  `available_vcote` bigint(0) NOT NULL COMMENT '可用的vcore总数',
  `memory_physical` double NULL DEFAULT NULL COMMENT '物理内存利用率',
  `memory_virtual` double NULL DEFAULT NULL COMMENT '虚拟内存利用率',
  `CPU_usage` double NULL DEFAULT NULL COMMENT 'CPU利用率',
  `containers_CPU_usage` double NULL DEFAULT NULL COMMENT '容器的聚合CPU利用率',
  `created_at` datetime(0) NULL DEFAULT NULL COMMENT '数据插入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 441634 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '节点信息表(节点状态)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reduce_info
-- ----------------------------
DROP TABLE IF EXISTS `reduce_info`;
CREATE TABLE `reduce_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_info_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应表5的id',
  `task_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'reduce-Task id',
  `task_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'reduce-Task名称（解压缩、云判……）',
  `reduce_node` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'reduce-Task运行所在的节点',
  `start_time` datetime(0) NOT NULL COMMENT 'reduce-Task开始时间',
  `finished_time` datetime(0) NOT NULL COMMENT 'reduce-Task结束时间',
  `elapsed_time` float(30, 3) NOT NULL COMMENT 'reduce-Task运行时间 ms',
  `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Reduce任务历史数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reduce_info_history
-- ----------------------------
DROP TABLE IF EXISTS `reduce_info_history`;
CREATE TABLE `reduce_info_history`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动生成（主键）',
  `job_info_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应表5的id',
  `task_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'reduce-Task id',
  `task_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'reduce-Task名称（解压缩、云判……）',
  `reduce_node` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'reduce-Task运行所在的节点',
  `start_time` datetime(0) NOT NULL COMMENT 'reduce-Task开始时间',
  `finished_time` datetime(0) NOT NULL COMMENT 'reduce-Task结束时间',
  `elapsed_time` float(30, 3) NOT NULL COMMENT 'reduce-Task运行时间 ms',
  `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Reduce任务历史数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(0) UNSIGNED NOT NULL COMMENT '主键（自动递增）',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `passwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `locked` tinyint(0) NOT NULL COMMENT '账号是否锁定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
