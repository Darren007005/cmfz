-- auto Generated on 2018-07-09 21:14:22 
 DROP TABLE IF EXISTS log;
CREATE TABLE log(
	log_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'logId',
	log_user VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'logUser',
	log_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'logTime',
	log_resource VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'logResource',
	log_action VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'logAction',
	log_message TEXT ,
	log_result VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'logResult',
	PRIMARY KEY (log_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'log';

SELECT *
FROM log;
