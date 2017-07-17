CREATE TABLE `company_key` (
  `text_key` varchar(100) NOT NULL DEFAULT '',
  `count` int(6) NOT NULL,
  PRIMARY KEY (`text_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `content_key` (
  `text_key` varchar(50) NOT NULL DEFAULT '',
  `count` int(6) NOT NULL,
  PRIMARY KEY (`text_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `Job` (
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `advantage` varchar(200) DEFAULT NULL COMMENT '优势',
  `city` varchar(20) DEFAULT NULL COMMENT '地区',
  `type` varchar(10) DEFAULT NULL COMMENT '工作类型',
  `salary` varchar(45) DEFAULT NULL COMMENT '工资',
  `experience` varchar(100) DEFAULT NULL COMMENT '经验要求',
  `education` varchar(10) DEFAULT NULL COMMENT '学历要求',
  `number` int(11) DEFAULT NULL COMMENT '招聘人数',
  `position` varchar(45) DEFAULT NULL COMMENT '职位',
  `company_size` varchar(45) DEFAULT NULL COMMENT '公司规模',
  `company_type` varchar(45) DEFAULT NULL COMMENT '公司类型',
  `company_industry` varchar(45) DEFAULT NULL COMMENT '所属行业',
  `company_page` varchar(100) DEFAULT NULL COMMENT '公司主页',
  `company_address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT 'url',
  `required` varchar(5000) DEFAULT NULL COMMENT '详细需求',
  `public_date` varchar(50) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
