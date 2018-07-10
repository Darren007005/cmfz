-- auto Generated on 2018-07-05 11:21:33
DROP TABLE IF EXISTS accordion;
CREATE TABLE accordion(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT '分类的id',
	text VARCHAR (50) NOT NULL DEFAULT '' COMMENT '分类的文本内容',
	icon_cls VARCHAR (50)  DEFAULT '' COMMENT '分类的图标',
	url VARCHAR (50)  DEFAULT '' COMMENT '分类的二级的url',
	level INT (11) NOT NULL DEFAULT -1 COMMENT '分类的级别',
	parent_id INT (11)  DEFAULT -1 COMMENT '分类的父id',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'accordion';

INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'持明法洲之用户','icon-tip',null,1,null);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'用户管理','icon-tip','test.jsp',2,1);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'用户管理1','icon-tip','test.jsp',2,1);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'用户管理2','icon-tip','test.jsp',2,1);

SELECT *
FROM accordion;

DELETE FROM accordion WHERE id ;

INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'持明法洲之文章','icon-tip',null,1,null);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'文章列表','icon-tip','test.jsp',2,5);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'文章列表1','icon-tip','test.jsp',2,5);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'文章列表2','icon-tip','test.jsp',2,5);

INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'持明法洲之轮播','icon-reload',null,1,null);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'轮播图管理','icon-tip','carousel.jsp',2,9);

INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'持明法洲之上师','icon-reload',null,1,null);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'上师管理','icon-tip','guru.jsp',2,12);

INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'持明法洲之文章','icon-reload',null,1,null);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'创建文章','icon-tip','textEdit.jsp',2,15);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'文章管理','icon-tip','textEdit.jsp',2,15);

INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'持明法洲之统计分析','icon-reload',null,1,null);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'用户分布图','icon-tip','userProfile.jsp',2,18);
INSERT INTO accordion (id, text, icon_cls, url, level, parent_id) VALUES (null,'统计分析','icon-tip','analysis.jsp',2,18);

