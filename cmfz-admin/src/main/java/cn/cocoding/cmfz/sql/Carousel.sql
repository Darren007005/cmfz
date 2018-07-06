-- auto Generated on 2018-07-05 19:40:50 
DROP TABLE IF EXISTS carousel;
CREATE TABLE carousel(
	carousel_id INT (11) AUTO_INCREMENT COMMENT 'carouselId',
	carousel_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'carouselName',
	carousel_describe VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'carouselDescribe',
	carousel_status VARCHAR (50)  DEFAULT '' COMMENT 'carouselStatus',
	carousel_date DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'carouselDate',
	PRIMARY KEY (carousel_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'carousel';
/*--carousel_status-- 1 代表展示，0 代表未展示*/
INSERT INTO carousel (carousel_id, carousel_name, carousel_describe, carousel_status, carousel_date)
VALUES (null,'5b2b0a46N1d6fbc13.jpg','oppo最新手机','1',sysdate());
SELECT *
FROM carousel;
DELETE FROM carousel;
