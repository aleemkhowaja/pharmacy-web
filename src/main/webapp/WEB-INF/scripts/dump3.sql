/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.17-log : Database - samcmdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`samcmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `samcmdb`;

/*Table structure for table `dispatch_party` */

DROP TABLE IF EXISTS `dispatch_party`;

CREATE TABLE `dispatch_party` (
  `dispatch_party_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatch_party` varchar(255) NOT NULL,
  `dispatch_party_owner` varchar(255) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`dispatch_party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `dispatch_party` */

insert  into `dispatch_party`(`dispatch_party_id`,`dispatch_party`,`dispatch_party_owner`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,'jhjh','jhjh','A',1,'2020-03-11 17:55:20',NULL,NULL),(2,'sss999555','sssddddffff555','A',1,'2020-02-29 16:45:44',NULL,NULL),(3,'ggg','hhhh','D',1,'2020-02-29 16:45:57',NULL,NULL),(4,'1112222','222288','A',1,'2020-06-21 15:17:53',NULL,NULL),(5,'ooo','iiii','A',1,'2020-06-20 17:19:00',NULL,NULL),(6,'666`5555`555','444444','D',1,'2020-06-20 17:19:10',NULL,NULL);

/*Table structure for table `dispatch_party_details` */

DROP TABLE IF EXISTS `dispatch_party_details`;

CREATE TABLE `dispatch_party_details` (
  `dispatch_party_id` int(11) DEFAULT NULL,
  `dispatch_party_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of` datetime DEFAULT NULL,
  `quality` varchar(255) DEFAULT NULL,
  `tons` int(11) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `rebate` int(11) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`dispatch_party_details_id`),
  KEY `dispatch_party_id` (`dispatch_party_id`),
  CONSTRAINT `dispatch_party_details_ibfk_1` FOREIGN KEY (`dispatch_party_id`) REFERENCES `dispatch_party` (`dispatch_party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `dispatch_party_details` */

insert  into `dispatch_party_details`(`dispatch_party_id`,`dispatch_party_details_id`,`date_of`,`quality`,`tons`,`rate`,`amount`,`rebate`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,16,'2020-07-22 05:00:00','SE',2,500,800,100,'A',1,'2020-09-03 12:49:20',NULL,NULL),(1,17,'2020-07-20 05:00:00','SE',3,500,900,200,'A',1,'2020-07-21 12:21:37',NULL,NULL),(1,18,'2020-09-01 05:00:00','SE',2,22,44,33,'A',1,'2020-09-03 13:10:07',NULL,NULL);

/*Table structure for table `dispatch_party_ledger` */

DROP TABLE IF EXISTS `dispatch_party_ledger`;

CREATE TABLE `dispatch_party_ledger` (
  `dispatch_party_id` int(11) DEFAULT NULL,
  `dispatch_party_ledger_id` int(11) NOT NULL AUTO_INCREMENT,
  `recieved_amount` int(11) DEFAULT NULL,
  `remaining` int(11) DEFAULT NULL,
  `source_of_amount` enum('Cash','Online') DEFAULT NULL,
  `recieved_account` varchar(255) DEFAULT NULL,
  `bank` enum('Meezan','Hbl','Nbp','Ubl','Dubaiislami','Bankislami','Habibmetro','Alhabib','Soneri') DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`dispatch_party_ledger_id`),
  KEY `dispatch_party_id` (`dispatch_party_id`),
  CONSTRAINT `dispatch_party_ledger_ibfk_1` FOREIGN KEY (`dispatch_party_id`) REFERENCES `dispatch_party` (`dispatch_party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `dispatch_party_ledger` */

insert  into `dispatch_party_ledger`(`dispatch_party_id`,`dispatch_party_ledger_id`,`recieved_amount`,`remaining`,`source_of_amount`,`recieved_account`,`bank`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,2,700,1000,'Cash',NULL,NULL,'A',1,'2020-07-21 18:34:03',NULL,NULL),(1,3,100,944,'Cash',NULL,NULL,'A',1,'2020-09-24 18:21:48',NULL,NULL),(1,4,100,844,'Cash',NULL,NULL,'A',1,'2020-09-24 18:25:24',NULL,NULL),(1,5,44,800,'Cash',NULL,NULL,'A',1,'2020-09-24 18:29:45',NULL,NULL),(1,6,100,700,'Cash',NULL,NULL,'A',1,'2020-09-24 19:16:57',NULL,NULL),(1,7,100,600,'Cash',NULL,NULL,'A',1,'2020-09-24 20:19:30',NULL,NULL),(1,8,100,500,'Cash',NULL,NULL,'A',1,'2020-09-24 20:21:44',NULL,NULL);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) NOT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `status` varchar(1) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `salary_type` enum('daily','monthly') DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `overtime_amount` int(11) DEFAULT NULL,
  `public_holiday_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`employee_name`,`father_name`,`contact_no`,`email`,`address`,`designation`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`,`salary_type`,`salary`,`overtime_amount`,`public_holiday_amount`) values (1,'hghghgh','yyyuuu','hhh','ghfghfgh','hhhh','jjjjj','A',1,'2020-02-25 13:40:37',NULL,NULL,'daily',22,11,22),(2,'stringkkk','string','shhhhtring','string','hhdsds','string','A',1,'2020-02-29 16:42:58',NULL,NULL,'daily',22,22,22),(3,'Admin Employee11','Admin Father11','03352692161','admin@gmial.com','Karachiddd','Admin','A',1,'2020-05-01 19:31:58',NULL,NULL,'daily',33,33,33),(4,'sds','strsdsding','sdsd','sdsd','sds','sdsd','A',1,'2020-02-28 17:33:09',NULL,NULL,'daily',44,44,44),(5,'sasa','sdsdsds','0333','aleem2k11@gmail.com','dddd','ddd','A',1,'2020-02-28 17:53:52',NULL,NULL,'daily',55,55,55),(6,'sasa','sdsdsds','0333','aleem2k11@gmail.com','dddd','ddd','A',1,'2020-02-28 17:56:52',NULL,NULL,'daily',66,66,66),(7,'sasa','sdsdsds','0333','aleem2k11@gmail.com','dddd','ddd','A',1,'2020-02-28 18:40:32',NULL,NULL,'daily',77,77,77),(8,'22','11','455','44','9999','787','A',1,'2020-02-28 19:10:20',NULL,NULL,'daily',88,88,88),(9,'8','7','6','5','33333','4','A',1,'2020-02-28 19:28:47',NULL,NULL,'daily',99,99,99),(10,'10000','222','333','444','4545454545454','55','A',1,'2020-02-28 19:35:13',NULL,NULL,'daily',65,65,6744),(11,'121212','12121212','1212212','121212','121212','121212','A',1,'2020-02-28 19:36:52',NULL,NULL,'daily',54545,454,4545),(12,'1','2','3','4','68888','56','A',1,'2020-02-28 19:38:32',NULL,NULL,'daily',33,NULL,NULL),(13,'1212','121212','1212','121','21','21','A',1,'2020-02-28 19:41:23',NULL,NULL,NULL,NULL,NULL,NULL),(14,'22233','3323','23232','323232','6565','2323','A',1,'2020-02-28 20:13:04',NULL,NULL,NULL,NULL,NULL,NULL),(15,'33','22','11','444','66','55','A',1,'2020-02-28 20:25:14',NULL,NULL,NULL,NULL,NULL,NULL),(16,'testing','hhh','023423223','testin@gmail.com','hyderabad','yyyy','A',1,'2020-05-09 17:24:10',NULL,NULL,NULL,NULL,NULL,NULL),(17,'jkjkj','kjkjkj','jkjkjk','jkjkjkj','jkjkjkj','jkjkjk','A',1,'2020-07-26 13:35:26',NULL,NULL,NULL,NULL,NULL,NULL),(18,'alim ','khowaja','jkjkj','aleem2k11@gmail.com','dsdsds','dd','A',1,'2020-07-26 13:38:51',NULL,NULL,NULL,NULL,NULL,NULL),(19,'jj','kkk','jjjj','aleem2k11@gmail.com','uuuu','iiii','A',1,'2020-07-26 13:40:24',NULL,NULL,NULL,NULL,NULL,NULL),(20,'jhjhj','jhjhjh','888888','aleem2k11@gmail.com','hjhjh','hhh','A',1,'2020-07-26 14:08:23',NULL,NULL,'daily',9999,8888,66666);

/*Table structure for table `employee_salary` */

DROP TABLE IF EXISTS `employee_salary`;

CREATE TABLE `employee_salary` (
  `employee_salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  `total_days_amount` int(11) DEFAULT NULL,
  `ot_days` int(11) DEFAULT NULL,
  `total_ot_amount` int(11) DEFAULT NULL,
  `public_holidays` int(11) DEFAULT NULL,
  `total_public_holidays_amount` int(11) DEFAULT NULL,
  `gross_amount` int(11) DEFAULT NULL,
  `advance_salary` int(11) DEFAULT NULL,
  `utilities` int(11) DEFAULT NULL,
  `net_amount` int(11) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`employee_salary_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `employee_salary_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `employee_salary` */

insert  into `employee_salary`(`employee_salary_id`,`employee_id`,`from_date`,`to_date`,`days`,`total_days_amount`,`ot_days`,`total_ot_amount`,`public_holidays`,`total_public_holidays_amount`,`gross_amount`,`advance_salary`,`utilities`,`net_amount`,`created_by`,`created_date`,`modified_by`,`modified_date`,`status`) values (40,1,'2020-09-01','2020-09-30',1,22,20,NULL,145,NULL,22,30,10,-18,1,'2020-09-15',NULL,NULL,'A'),(41,2,'2020-09-01','2020-09-30',2,NULL,3,NULL,5,NULL,NULL,4,1,NULL,1,'2020-09-15',NULL,NULL,'A'),(42,3,'2020-09-01','2020-09-30',3,99,34,NULL,0,NULL,1221,0,0,1221,1,'2020-09-15',NULL,NULL,'A'),(43,4,'2020-09-01','2020-09-30',4,176,3434,NULL,0,NULL,151272,0,0,151272,1,'2020-09-15',NULL,NULL,'A'),(44,5,'2020-09-01','2020-09-30',5,275,3434,NULL,0,NULL,189145,0,0,189145,1,'2020-09-15',NULL,NULL,'A'),(45,6,'2020-09-01','2020-09-30',6,396,43434,NULL,0,NULL,2867040,0,0,2867040,1,'2020-09-15',NULL,NULL,'A'),(46,7,'2020-09-01','2020-09-30',7,539,434,NULL,0,NULL,33957,0,0,33957,1,'2020-09-15',NULL,NULL,'A'),(47,8,'2020-09-01','2020-09-30',8,704,343,NULL,0,NULL,30888,0,0,30888,1,'2020-09-15',NULL,NULL,'A'),(48,9,'2020-09-01','2020-09-30',9,891,434,NULL,0,NULL,43857,0,0,43857,1,'2020-09-15',NULL,NULL,'A'),(49,10,'2020-09-01','2020-09-30',10,650,4234,NULL,0,NULL,275860,0,0,275860,1,'2020-09-15',NULL,NULL,'A'),(50,11,'2020-09-01','2020-09-30',11,599995,4243,NULL,0,NULL,2526317,0,0,2526317,1,'2020-09-15',NULL,NULL,'A'),(51,12,'2020-09-01','2020-09-30',12,396,4234,NULL,0,NULL,396,0,0,396,1,'2020-09-15',NULL,NULL,'A'),(53,20,'2020-09-01','2020-09-30',13,129987,23424,NULL,0,NULL,208322499,0,0,208322499,1,'2020-09-15',NULL,NULL,'A');

/*Table structure for table `gen_ledger` */

DROP TABLE IF EXISTS `gen_ledger`;

CREATE TABLE `gen_ledger` (
  `gen_ledger_id` int(11) NOT NULL AUTO_INCREMENT,
  `gl_code` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gen_ledger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `gen_ledger` */

insert  into `gen_ledger`(`gen_ledger_id`,`gl_code`,`description`) values (1,1,'Bank/Assets'),(2,2,'Liabilities'),(3,4,'Income'),(4,5,'Expense');

/*Table structure for table `sub_gen_ledger` */

DROP TABLE IF EXISTS `sub_gen_ledger`;

CREATE TABLE `sub_gen_ledger` (
  `sub_gen_ledger_id` int(11) NOT NULL AUTO_INCREMENT,
  `gen_ledger_id` int(11) NOT NULL,
  `gl_code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_gen_ledger_id`),
  KEY `gen_ledger_id` (`gen_ledger_id`),
  CONSTRAINT `sub_gen_ledger_ibfk_1` FOREIGN KEY (`gen_ledger_id`) REFERENCES `gen_ledger` (`gen_ledger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sub_gen_ledger` */

insert  into `sub_gen_ledger`(`sub_gen_ledger_id`,`gen_ledger_id`,`gl_code`,`description`) values (1,4,'51','Staff Salary'),(2,4,'52','Coal Expense'),(3,4,'53','Office Expese');

/*Table structure for table `transactions` */

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
  `gen_ledger_id` int(11) DEFAULT NULL,
  `sub_gen_ledger_id` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `transactions_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_type` enum('debit','credit') DEFAULT NULL,
  PRIMARY KEY (`transactions_id`),
  KEY `sub_gen_ledger_id` (`sub_gen_ledger_id`),
  KEY `gen_ledger_id` (`gen_ledger_id`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`sub_gen_ledger_id`) REFERENCES `sub_gen_ledger` (`sub_gen_ledger_id`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`gen_ledger_id`) REFERENCES `gen_ledger` (`gen_ledger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `transactions` */

insert  into `transactions`(`gen_ledger_id`,`sub_gen_ledger_id`,`date`,`amount`,`description`,`created_by`,`created_date`,`modified_by`,`modified_date`,`status`,`transactions_id`,`transaction_type`) values (3,NULL,'2020-09-24 20:21:44',100,NULL,1,'2020-09-24 20:21:44',NULL,NULL,'A',1,'credit');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `employee_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` text NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`employee_id`,`user_id`,`username`,`password`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (3,1,'admin','$2a$10$tts4URO/6U0WMKwDRCkOhugJbOL9WtF1m8mnlFCoU9Yq/ES2PkLQG','A',1,'2020-02-27 16:27:00',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
