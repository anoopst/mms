/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50146
Source Host           : localhost:3306
Source Database       : mms

Target Server Type    : MYSQL
Target Server Version : 50146
File Encoding         : 65001

Date: 2011-02-02 23:51:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `mm_brand`
-- ----------------------------
DROP TABLE IF EXISTS `mm_brand`;
CREATE TABLE `mm_brand` (
  `BD_NO` int(11) NOT NULL AUTO_INCREMENT,
  `BD_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BD_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_brand
-- ----------------------------
INSERT INTO `mm_brand` VALUES ('1', 'brand');

-- ----------------------------
-- Table structure for `mm_category`
-- ----------------------------
DROP TABLE IF EXISTS `mm_category`;
CREATE TABLE `mm_category` (
  `CT_NO` int(11) NOT NULL AUTO_INCREMENT,
  `CT_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CT_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_category
-- ----------------------------
INSERT INTO `mm_category` VALUES ('1', 'category');

-- ----------------------------
-- Table structure for `mm_dimension`
-- ----------------------------
DROP TABLE IF EXISTS `mm_dimension`;
CREATE TABLE `mm_dimension` (
  `DM_NO` int(11) NOT NULL AUTO_INCREMENT,
  `DM_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_dimension
-- ----------------------------
INSERT INTO `mm_dimension` VALUES ('1', '10 x 12');

-- ----------------------------
-- Table structure for `mm_goodsissuedetail`
-- ----------------------------
DROP TABLE IF EXISTS `mm_goodsissuedetail`;
CREATE TABLE `mm_goodsissuedetail` (
  `GID_NO` int(11) NOT NULL AUTO_INCREMENT,
  `GIH_NO` int(11) DEFAULT NULL,
  `IT_NO` int(11) DEFAULT NULL,
  `GID_DESC` varchar(255) DEFAULT NULL,
  `GID_QTY` double DEFAULT NULL,
  `GID_POPROCESS` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`GID_NO`),
  KEY `FKEC5DDA131148F203` (`GIH_NO`),
  KEY `FKEC5DDA1350E93B81` (`IT_NO`),
  CONSTRAINT `FKEC5DDA131148F203` FOREIGN KEY (`GIH_NO`) REFERENCES `mm_goodsissueheader` (`GIH_NO`),
  CONSTRAINT `FKEC5DDA1350E93B81` FOREIGN KEY (`IT_NO`) REFERENCES `mm_item` (`IT_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_goodsissuedetail
-- ----------------------------
INSERT INTO `mm_goodsissuedetail` VALUES ('1', '1', '1', '', '5', '1');
INSERT INTO `mm_goodsissuedetail` VALUES ('2', '2', '1', ' ', '6', '1');

-- ----------------------------
-- Table structure for `mm_goodsissueheader`
-- ----------------------------
DROP TABLE IF EXISTS `mm_goodsissueheader`;
CREATE TABLE `mm_goodsissueheader` (
  `GIH_NO` int(11) NOT NULL AUTO_INCREMENT,
  `GIH_DATE` date DEFAULT NULL,
  `VH_NO` int(11) DEFAULT NULL,
  `US_NO` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GIH_NO`),
  KEY `FKF328A44F166A2BE1` (`VH_NO`),
  KEY `FKF328A44F519751E6` (`US_NO`),
  CONSTRAINT `FKF328A44F166A2BE1` FOREIGN KEY (`VH_NO`) REFERENCES `mm_vehicle` (`VH_NO`),
  CONSTRAINT `FKF328A44F519751E6` FOREIGN KEY (`US_NO`) REFERENCES `mm_user` (`US_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_goodsissueheader
-- ----------------------------
INSERT INTO `mm_goodsissueheader` VALUES ('1', '2011-01-05', '2', '1', 'Issued');
INSERT INTO `mm_goodsissueheader` VALUES ('2', '2011-01-05', '1', '1', 'Issued');

-- ----------------------------
-- Table structure for `mm_goodsreceiptdetail`
-- ----------------------------
DROP TABLE IF EXISTS `mm_goodsreceiptdetail`;
CREATE TABLE `mm_goodsreceiptdetail` (
  `grd_no` int(11) NOT NULL AUTO_INCREMENT,
  `GRH_NO` int(11) DEFAULT NULL,
  `IT_NO` int(11) DEFAULT NULL,
  `GRH_DESC` varchar(255) DEFAULT NULL,
  `GRH_QTY` double DEFAULT NULL,
  PRIMARY KEY (`grd_no`),
  KEY `FKDE5E99F27DB9B6EB` (`GRH_NO`),
  KEY `FKDE5E99F250E93B81` (`IT_NO`),
  CONSTRAINT `FKDE5E99F250E93B81` FOREIGN KEY (`IT_NO`) REFERENCES `mm_item` (`IT_NO`),
  CONSTRAINT `FKDE5E99F27DB9B6EB` FOREIGN KEY (`GRH_NO`) REFERENCES `mm_goodsreceiptheader` (`GRH_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_goodsreceiptdetail
-- ----------------------------
INSERT INTO `mm_goodsreceiptdetail` VALUES ('1', '1', '1', null, '25');

-- ----------------------------
-- Table structure for `mm_goodsreceiptheader`
-- ----------------------------
DROP TABLE IF EXISTS `mm_goodsreceiptheader`;
CREATE TABLE `mm_goodsreceiptheader` (
  `GRH_NO` int(11) NOT NULL AUTO_INCREMENT,
  `GRH_DATE` date DEFAULT NULL,
  `PO_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`GRH_NO`),
  KEY `FKE529642E8F751FE6` (`PO_NO`),
  CONSTRAINT `FKE529642E8F751FE6` FOREIGN KEY (`PO_NO`) REFERENCES `mm_poheader` (`PO_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_goodsreceiptheader
-- ----------------------------
INSERT INTO `mm_goodsreceiptheader` VALUES ('1', '2011-01-04', '1');

-- ----------------------------
-- Table structure for `mm_heading`
-- ----------------------------
DROP TABLE IF EXISTS `mm_heading`;
CREATE TABLE `mm_heading` (
  `HD_NO` int(11) NOT NULL AUTO_INCREMENT,
  `HD_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`HD_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_heading
-- ----------------------------
INSERT INTO `mm_heading` VALUES ('1', 'oils');
INSERT INTO `mm_heading` VALUES ('2', 'head');
INSERT INTO `mm_heading` VALUES ('3', 'oil');

-- ----------------------------
-- Table structure for `mm_item`
-- ----------------------------
DROP TABLE IF EXISTS `mm_item`;
CREATE TABLE `mm_item` (
  `IT_NO` int(11) NOT NULL AUTO_INCREMENT,
  `IT_NAME` varchar(255) DEFAULT NULL,
  `IT_RATE` double DEFAULT NULL,
  `IT_ROL` double DEFAULT NULL,
  `IT_STOCK` double DEFAULT NULL,
  `HD_NO` int(11) DEFAULT NULL,
  `SH_NO` int(11) DEFAULT NULL,
  `DM_NO` int(11) DEFAULT NULL,
  `BD_NO` int(11) DEFAULT NULL,
  `UM_NO` int(11) DEFAULT NULL,
  `MD_NO` int(11) DEFAULT NULL,
  `CT_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IT_NO`),
  KEY `FK4573AA5218E6D899` (`MD_NO`),
  KEY `FK4573AA52322AF806` (`SH_NO`),
  KEY `FK4573AA5230A7002D` (`HD_NO`),
  KEY `FK4573AA527836BBE6` (`CT_NO`),
  KEY `FK4573AA52463C3324` (`DM_NO`),
  KEY `FK4573AA5221D4CBA2` (`UM_NO`),
  KEY `FK4573AA5217B2266C` (`BD_NO`),
  CONSTRAINT `FK4573AA5217B2266C` FOREIGN KEY (`BD_NO`) REFERENCES `mm_brand` (`BD_NO`),
  CONSTRAINT `FK4573AA5218E6D899` FOREIGN KEY (`MD_NO`) REFERENCES `mm_model` (`MD_NO`),
  CONSTRAINT `FK4573AA5221D4CBA2` FOREIGN KEY (`UM_NO`) REFERENCES `mm_uom` (`UM_NO`),
  CONSTRAINT `FK4573AA5230A7002D` FOREIGN KEY (`HD_NO`) REFERENCES `mm_heading` (`HD_NO`),
  CONSTRAINT `FK4573AA52322AF806` FOREIGN KEY (`SH_NO`) REFERENCES `mm_subheading` (`SH_NO`),
  CONSTRAINT `FK4573AA52463C3324` FOREIGN KEY (`DM_NO`) REFERENCES `mm_dimension` (`DM_NO`),
  CONSTRAINT `FK4573AA527836BBE6` FOREIGN KEY (`CT_NO`) REFERENCES `mm_category` (`CT_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_item
-- ----------------------------
INSERT INTO `mm_item` VALUES ('1', 'm/b 14, 41mm clutch plate refacing iq', '5', '10', '42', '2', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `mm_model`
-- ----------------------------
DROP TABLE IF EXISTS `mm_model`;
CREATE TABLE `mm_model` (
  `MD_NO` int(11) NOT NULL AUTO_INCREMENT,
  `MD_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MD_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_model
-- ----------------------------
INSERT INTO `mm_model` VALUES ('1', 'tata');

-- ----------------------------
-- Table structure for `mm_podetail`
-- ----------------------------
DROP TABLE IF EXISTS `mm_podetail`;
CREATE TABLE `mm_podetail` (
  `pd_no` int(11) NOT NULL AUTO_INCREMENT,
  `PO_NO` int(11) DEFAULT NULL,
  `IT_NO` int(11) DEFAULT NULL,
  `PO_DESC` varchar(100) DEFAULT NULL,
  `PO_QTY` double DEFAULT NULL,
  `PO_RATE` double DEFAULT NULL,
  `PO_AMT` double DEFAULT NULL,
  `GR_QTY` double DEFAULT NULL,
  `GI_QTY` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`pd_no`),
  KEY `FK80CBE2CF50E93B81` (`IT_NO`),
  KEY `FK80CBE2CF8F751FE6` (`PO_NO`),
  CONSTRAINT `FK80CBE2CF50E93B81` FOREIGN KEY (`IT_NO`) REFERENCES `mm_item` (`IT_NO`),
  CONSTRAINT `FK80CBE2CF8F751FE6` FOREIGN KEY (`PO_NO`) REFERENCES `mm_poheader` (`PO_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_podetail
-- ----------------------------
INSERT INTO `mm_podetail` VALUES ('1', '1', '1', null, '50', '7.5', '0', '25', '11');

-- ----------------------------
-- Table structure for `mm_poheader`
-- ----------------------------
DROP TABLE IF EXISTS `mm_poheader`;
CREATE TABLE `mm_poheader` (
  `PO_NO` int(11) NOT NULL AUTO_INCREMENT,
  `PO_DATE` date DEFAULT NULL,
  `RH_NO` int(11) DEFAULT NULL,
  `VN_NO` int(11) DEFAULT NULL,
  `PO_STATUS` varchar(255) DEFAULT NULL,
  `PO_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PO_NO`),
  KEY `FK8796AD0B59CB7AC9` (`VN_NO`),
  KEY `FK8796AD0B9B68F59C` (`RH_NO`),
  CONSTRAINT `FK8796AD0B59CB7AC9` FOREIGN KEY (`VN_NO`) REFERENCES `mm_vendor` (`VN_NO`),
  CONSTRAINT `FK8796AD0B9B68F59C` FOREIGN KEY (`RH_NO`) REFERENCES `mm_reqheader` (`RH_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_poheader
-- ----------------------------
INSERT INTO `mm_poheader` VALUES ('1', '2011-01-04', '1', '1', 'PO Raised', 'Normal');

-- ----------------------------
-- Table structure for `mm_repstockdetail`
-- ----------------------------
DROP TABLE IF EXISTS `mm_repstockdetail`;
CREATE TABLE `mm_repstockdetail` (
  `pono` int(11) NOT NULL,
  `Itno` int(11) NOT NULL,
  `poqty` double DEFAULT NULL,
  `gino` int(11) DEFAULT NULL,
  `giqty` double DEFAULT NULL,
  `porate` double DEFAULT NULL,
  `poamt` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_repstockdetail
-- ----------------------------
INSERT INTO `mm_repstockdetail` VALUES ('1', '1', '50', '1', '5', '7.5', '37.5');
INSERT INTO `mm_repstockdetail` VALUES ('1', '1', '50', '2', '6', '7.5', '45');

-- ----------------------------
-- Table structure for `mm_reqdetail`
-- ----------------------------
DROP TABLE IF EXISTS `mm_reqdetail`;
CREATE TABLE `mm_reqdetail` (
  `RD_NO` int(11) NOT NULL AUTO_INCREMENT,
  `RH_NO` int(11) DEFAULT NULL,
  `IT_NO` int(11) DEFAULT NULL,
  `IT_DESC` varchar(255) DEFAULT NULL,
  `RD_QTY` double DEFAULT NULL,
  `PO_QTY` double DEFAULT NULL,
  PRIMARY KEY (`RD_NO`),
  KEY `FK5F9EE29050E93B81` (`IT_NO`),
  KEY `FK5F9EE2909B68F59C` (`RH_NO`),
  CONSTRAINT `FK5F9EE29050E93B81` FOREIGN KEY (`IT_NO`) REFERENCES `mm_item` (`IT_NO`),
  CONSTRAINT `FK5F9EE2909B68F59C` FOREIGN KEY (`RH_NO`) REFERENCES `mm_reqheader` (`RH_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_reqdetail
-- ----------------------------
INSERT INTO `mm_reqdetail` VALUES ('1', '1', '1', null, '50', '50');

-- ----------------------------
-- Table structure for `mm_reqheader`
-- ----------------------------
DROP TABLE IF EXISTS `mm_reqheader`;
CREATE TABLE `mm_reqheader` (
  `RH_NO` int(11) NOT NULL AUTO_INCREMENT,
  `RH_DATE` date DEFAULT NULL,
  `RH_STATUS` varchar(255) DEFAULT NULL,
  `us_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`RH_NO`),
  KEY `FK6669ACCC519751E6` (`us_no`),
  CONSTRAINT `FK6669ACCC519751E6` FOREIGN KEY (`us_no`) REFERENCES `mm_user` (`US_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_reqheader
-- ----------------------------
INSERT INTO `mm_reqheader` VALUES ('1', '2011-01-02', 'PO Raised', '1');

-- ----------------------------
-- Table structure for `mm_subheading`
-- ----------------------------
DROP TABLE IF EXISTS `mm_subheading`;
CREATE TABLE `mm_subheading` (
  `SH_NO` int(11) NOT NULL AUTO_INCREMENT,
  `SH_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SH_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_subheading
-- ----------------------------
INSERT INTO `mm_subheading` VALUES ('1', 'engine oil');

-- ----------------------------
-- Table structure for `mm_uom`
-- ----------------------------
DROP TABLE IF EXISTS `mm_uom`;
CREATE TABLE `mm_uom` (
  `UM_NO` int(11) NOT NULL AUTO_INCREMENT,
  `UM_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_uom
-- ----------------------------
INSERT INTO `mm_uom` VALUES ('1', 'ltr');

-- ----------------------------
-- Table structure for `mm_user`
-- ----------------------------
DROP TABLE IF EXISTS `mm_user`;
CREATE TABLE `mm_user` (
  `US_NO` int(11) NOT NULL AUTO_INCREMENT,
  `US_NAME` varchar(50) DEFAULT NULL,
  `US_ROLE` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`US_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_user
-- ----------------------------
INSERT INTO `mm_user` VALUES ('1', 'admin', 'Admin', 'e38ad214943daad1d64c102faec29de4afe9da3d');
INSERT INTO `mm_user` VALUES ('2', 'user1', 'Approver', 'e38ad214943daad1d64c102faec29de4afe9da3d');

-- ----------------------------
-- Table structure for `mm_vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `mm_vehicle`;
CREATE TABLE `mm_vehicle` (
  `VH_NO` int(11) NOT NULL AUTO_INCREMENT,
  `VH_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`VH_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_vehicle
-- ----------------------------
INSERT INTO `mm_vehicle` VALUES ('1', 'sl001');
INSERT INTO `mm_vehicle` VALUES ('2', 'sl002');

-- ----------------------------
-- Table structure for `mm_vendor`
-- ----------------------------
DROP TABLE IF EXISTS `mm_vendor`;
CREATE TABLE `mm_vendor` (
  `VN_NO` int(11) NOT NULL AUTO_INCREMENT,
  `VN_NAME` varchar(50) DEFAULT NULL,
  `VN_ADD1` varchar(50) DEFAULT NULL,
  `VN_ADD2` varchar(50) DEFAULT NULL,
  `VN_ADD3` varchar(50) DEFAULT NULL,
  `VN_ADD4` varchar(50) DEFAULT NULL,
  `VN_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VN_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mm_vendor
-- ----------------------------
INSERT INTO `mm_vendor` VALUES ('1', 'huan chung shiun', '13-3, Menera KLH', 'Jalan Kasipillai', 'Kuala Lumpur, Malaysia', '52100', 'Service');

-- ----------------------------
-- Procedure structure for `mm_processGI`
-- ----------------------------
DROP PROCEDURE IF EXISTS `mm_processGI`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mm_processGI`()
BEGIN

   -- Declare local variables
   DECLARE itno int;
	 DECLARE giqty Double;
	 DECLARE gino int;
	 DECLARE ProcessRet int;
	 DECLARE done int DEFAULT 0;

   -- Declare the cursor
   DECLARE GICURS CURSOR
   FOR 
	 SELECT gih.GIH_NO, gid.IT_NO, gid.GID_QTY  FROM MM_GOODSISSUEHEADER gih, MM_GOODSISSUEDETAIL gid  
   WHERE gih.GIH_NO = gid.GIH_NO and GID_POPROCESS=0 ORDER BY gih.GIH_NO, gid.IT_NO;

   -- Declare continue handler
	 DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
   -- DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1;

   -- Open the cursor
   OPEN GICURS;
   
   -- Loop through all rows
	 read_loop: LOOP

   -- Get GICURS
   FETCH GICURS INTO gino, itno, giqty;

   IF done THEN
      LEAVE read_loop;
   END IF;

   Call mm_processPO(itno, gino, giqty, ProcessRet);

select gino, itno, giqty,ProcessRet;

   If ProcessRet = 1 Then
			 Update mm_goodsissuedetail set GID_POPROCESS = 1 where GIH_NO = gino and IT_NO = itno; 
   End If;        

   -- End of loop
   END LOOP;

   -- Close the cursor
   CLOSE GICURS;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `mm_processPO`
-- ----------------------------
DROP PROCEDURE IF EXISTS `mm_processPO`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mm_processPO`(IN `ITNO` int,IN `GINO` int,IN `ISSQTY` double,OUT `POSUCCESS` int)
BEGIN
	#Routine body goes here...

   -- Declare local variables
   DECLARE poqty Double;
	 DECLARE giqty Double;
	 DECLARE porate Double;
	 DECLARE pono int;
	 DECLARE it_qty double;
	 DECLARE done int DEFAULT 0;

   -- Declare the cursor
   DECLARE POCURS CURSOR
   FOR
   SELECT poh.PO_NO, pod.PO_QTY, pod.GI_QTY, pod.PO_RATE FROM MM_POHEADER poh, MM_PODETAIL pod  
   Where poh.PO_NO = pod.PO_NO and pod.IT_NO = ITNO and (PO_QTY-GI_QTY)>0 Order by poh.PO_NO;

   -- Declare continue handler
	 DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
   -- DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1;

   -- Open the cursor
   OPEN POCURS;
   
   -- Setting the issue qty to a variable.
   Set it_qty= ISSQTY;

   -- Loop through all rows
   read_loop: LOOP

   -- Get POCURS
   FETCH POCURS INTO pono,poqty,giqty,porate;

	 IF done THEN
      LEAVE read_loop;
   END IF;

   select pono,poqty,giqty,porate;

   If (poqty - giqty) > it_qty Then 
       Update MM_PODETAIL set GI_QTY = GI_QTY + it_qty where PO_NO = pono and IT_NO = itno;
       Insert into mm_repStockDetail(pono,itno,poqty,gino,giqty,porate,poamt) values(PONO, ITNO, POQTY, GINO, IT_QTY, PORATE, IT_QTY*PORATE);
       Set POSUCCESS = 1;
       Set done=1;
   Else
			 If (poqty - giqty) <= it_qty Then 
					 Update MM_PODETAIL set GI_QTY = poqty where PO_NO = pono and IT_NO = itno;
					 Insert into mm_repStockDetail(pono,itno,poqty,gino,giqty,porate,poamt) values(PONO, ITNO, POQTY, GINO,(poqty - giqty), PORATE, (poqty - giqty)*PORATE);
					 Set it_qty= it_qty - (poqty - giqty);
					 If it_qty =0 Then
						 Set POSUCCESS = 1;
						 Set done=1;
					 End If;
			 End If;
   End If;        


   -- End of loop
    END LOOP;

   -- Close the cursor
   CLOSE POCURS;


END
;;
DELIMITER ;

SET GLOBAL event_scheduler = ON;
create event daily_stock_summary on schedule every 1 day
starts TIMESTAMP(CURRENT_DATE,'11:30:00')
do call mm_processGI;

show events;

select * from mysql.event;

SELECT last_executed FROM INFORMATION_SCHEMA.EVENTS where event_name='daily_stock_summary';