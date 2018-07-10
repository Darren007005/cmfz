-- auto Generated on 2018-07-08 19:35:47 
-- DROP TABLE IF EXISTS article; 
CREATE TABLE article(
	article_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'articleId',
	article_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'articleName',
	article_content TEXT NOT NULL COMMENT 'articleContent',
	article_author VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'articleAuthor',
	article_date DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'articleDate',
	PRIMARY KEY (article_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'article';

SELECT *
FROM article;