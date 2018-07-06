-- auto Generated on 2018-07-04 14:47:26 
-- DROP TABLE IF EXISTS manager; 
CREATE TABLE manager(
	manager_id VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'managerId',
	manager_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'managerName',
	manager_password VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'managerPassword',
	manager_status INT (11) NOT NULL DEFAULT -1 COMMENT 'managerStatus',
	salt VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'salt',
	PRIMARY KEY (manager_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'manager';
