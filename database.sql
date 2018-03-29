/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-log : Database - mydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mydb`;

/*Table structure for table `bookings` */

DROP TABLE IF EXISTS `bookings`;

CREATE TABLE `bookings` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `departuredate` varchar(255) NOT NULL,
  `departuretime` varchar(255) NOT NULL,
  `estimatedendtime` varchar(255) NOT NULL,
  `storename` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`bookingid`),
  KEY `FKcxfosc0y02dj4688ungt9i7rl` (`storename`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `bookings` */

insert  into `bookings`(`bookingid`,`departuredate`,`departuretime`,`estimatedendtime`,`storename`,`username`) values (44,'2018-03-14','2.00PM','7.00PM','vaishnodevi','kishan'),(51,'2018-03-19','5.00PM','6.00PM','vaishnodevi','kishan'),(53,'2018-03-14','5.00PM','6.00PM','vastrapur','kishan'),(54,'2018-03-20','11.00AM','1.00PM','thaltej','kishan'),(55,'2018-03-21','3.00PM','6.00PM','ghatlodia','kishan');

/*Table structure for table `complains` */

DROP TABLE IF EXISTS `complains`;

CREATE TABLE `complains` (
  `complainid` int(11) NOT NULL AUTO_INCREMENT,
  `complaindetails` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`complainid`),
  KEY `FKnckm9dexknyc79iyjqpkmu13c` (`userid`),
  CONSTRAINT `FKnckm9dexknyc79iyjqpkmu13c` FOREIGN KEY (`userid`) REFERENCES `userdetails` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `complains` */

/*Table structure for table `cycles` */

DROP TABLE IF EXISTS `cycles`;

CREATE TABLE `cycles` (
  `cycleid` int(11) NOT NULL AUTO_INCREMENT,
  `cycleCondition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cycleid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `cycles` */

insert  into `cycles`(`cycleid`,`cycleCondition`) values (1,'working'),(2,'working'),(3,'working'),(4,'working'),(5,'working'),(6,'working'),(7,'working'),(8,'working'),(9,'working'),(10,'working'),(11,'working'),(12,'working'),(13,'working'),(14,'working'),(15,'working'),(16,'working'),(17,'working'),(18,'working'),(19,'working'),(20,'working');

/*Table structure for table `endride` */

DROP TABLE IF EXISTS `endride`;

CREATE TABLE `endride` (
  `endrideid` int(11) NOT NULL AUTO_INCREMENT,
  `anydamage` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `totalamount` int(11) DEFAULT NULL,
  `totaltime` int(11) DEFAULT NULL,
  `startrideid` int(11) DEFAULT NULL,
  `endstorename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`endrideid`),
  KEY `FK5c9drphx526ge8d68nwqh9ot8` (`startrideid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `endride` */

insert  into `endride`(`endrideid`,`anydamage`,`endtime`,`totalamount`,`totaltime`,`startrideid`,`endstorename`) values (8,'NO','5.00PM',80,4,62,'sivranjani'),(18,'NO','8.00PM',60,6,69,'vaishnodevi');

/*Table structure for table `feedbacks` */

DROP TABLE IF EXISTS `feedbacks`;

CREATE TABLE `feedbacks` (
  `feedbackid` int(11) NOT NULL AUTO_INCREMENT,
  `feedbackdetails` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`feedbackid`),
  KEY `FK87xv24ikc5wxi728l154qhv4e` (`userid`),
  CONSTRAINT `FK87xv24ikc5wxi728l154qhv4e` FOREIGN KEY (`userid`) REFERENCES `userdetails` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `feedbacks` */

/*Table structure for table `ridedetails` */

DROP TABLE IF EXISTS `ridedetails`;

CREATE TABLE `ridedetails` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `endrideid` int(11) DEFAULT NULL,
  `startrideid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `FK51sl78so7as1drxf19n6v7k5a` (`endrideid`),
  KEY `FKa6v7r7qvom7w8kdmwe4vvrul2` (`startrideid`),
  CONSTRAINT `FK51sl78so7as1drxf19n6v7k5a` FOREIGN KEY (`endrideid`) REFERENCES `endride` (`endrideid`),
  CONSTRAINT `FKa6v7r7qvom7w8kdmwe4vvrul2` FOREIGN KEY (`startrideid`) REFERENCES `startride` (`startrideid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `ridedetails` */

insert  into `ridedetails`(`userid`,`endrideid`,`startrideid`) values (5,8,62);

/*Table structure for table `startride` */

DROP TABLE IF EXISTS `startride`;

CREATE TABLE `startride` (
  `startrideid` int(11) NOT NULL AUTO_INCREMENT,
  `cycleid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `departuredate` varchar(255) DEFAULT NULL,
  `departuretime` varchar(255) DEFAULT NULL,
  `estimatedendtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`startrideid`),
  KEY `FKrfgngeprny0bvh3xufi40s31s` (`cycleid`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Data for the table `startride` */

insert  into `startride`(`startrideid`,`cycleid`,`username`,`storename`,`departuredate`,`departuretime`,`estimatedendtime`) values (62,13,'kishan','naranpura','2018-03-06','1.00PM','2.00PM'),(63,11,'user','iskon','2018-03-15','9.00AM','1.00PM'),(64,1,'kishan','vastrapur','2018-03-16','6.00AM','6.00AM'),(65,1,'user','vastrapur','2018-03-17','8.00AM','11.00AM'),(67,12,'kishan','science city','2018-03-17','2.00PM','3.00PM'),(68,14,'kishan','vaishnodevi','2018-03-17','5.00PM','10.00PM'),(69,14,'kishan','sivranjani','2018-03-23','5.00PM','6.00PM'),(70,1,'kishan','sivranjani','2018-03-14','6.00AM','10.00PM'),(71,1,'kishan','vastrapur','2018-03-20','6.00AM','6.00AM');

/*Table structure for table `stores` */

DROP TABLE IF EXISTS `stores`;

CREATE TABLE `stores` (
  `storeid` int(11) NOT NULL AUTO_INCREMENT,
  `storeaddress` varchar(255) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `totalcycles` int(11) NOT NULL,
  PRIMARY KEY (`storeid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `stores` */

insert  into `stores`(`storeid`,`storeaddress`,`storename`,`totalcycles`) values (1,'vvvvv','vastrapur',20),(2,'iiii','iskon',20),(3,'xyz','naranpura',25),(4,'ggg','ghatlodia',30),(5,'tttt','thaltej',20),(6,'ssss','science city',25),(7,'vvvv','vaishnodevi',30),(8,NULL,'sivranjani',30);

/*Table structure for table `subscriptions` */

DROP TABLE IF EXISTS `subscriptions`;

CREATE TABLE `subscriptions` (
  `subscriptionid` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `subscriptiontype` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`subscriptionid`),
  KEY `FKt613pjh60lkivpiul949s5e76` (`userid`),
  CONSTRAINT `FKt613pjh60lkivpiul949s5e76` FOREIGN KEY (`userid`) REFERENCES `userdetails` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `subscriptions` */

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `role` varchar(60) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  UNIQUE KEY `UKstlxfukw77ov5w1wo1tm3omca` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `FKcdp2dxqcsdh6rnh6o64rgtcir` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user_roles` */

insert  into `user_roles`(`user_role_id`,`username`,`role`) values (3,'admin','ROLE_ADMIN'),(7,'kishan','ROLE_ADMIN'),(4,'admin','ROLE_API'),(6,'apiuser','ROLE_API'),(9,'kishan','ROLE_CRO'),(11,'test_cro','ROLE_CRO'),(2,'admin','ROLE_USER'),(5,'apiuser','ROLE_USER'),(8,'kishan','ROLE_USER'),(10,'test_cro','ROLE_USER'),(12,'test_user','ROLE_USER'),(1,'user','ROLE_USER');

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `aadhaarno` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `phone` bigint(20) NOT NULL,
  `useraddress` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `userdetails` */

insert  into `userdetails`(`userid`,`aadhaarno`,`age`,`dob`,`email`,`fname`,`gender`,`lname`,`phone`,`useraddress`,`username`) values (1,123456789012,21,'2018-08-10','kishan.nandha99@gmail.com','kishan','male','nandha',9428473433,'kishan address','kishan');

/*Table structure for table `userlogin` */

DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
  `Email` varchar(765) NOT NULL,
  `Password` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userlogin` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`username`,`password`,`enabled`) values ('admin','123456',1),('apiuser','123456',1),('jainish','123456',1),('kishan','123456',1),('test_cro','123456',1),('test_user','123456',1),('user','123456',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
