create database testdb;
use testdb;
CREATE TABLE `hotel_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelid` varchar(45) DEFAULT NULL,
  `rsq` varchar(10) DEFAULT NULL,
  `ap` int(5) DEFAULT NULL,
  `discount` int(5) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(127) DEFAULT NULL,
  `updated_by` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
