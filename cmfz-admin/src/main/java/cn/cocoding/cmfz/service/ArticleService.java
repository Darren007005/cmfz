package cn.cocoding.cmfz.service;

import java.util.List;
import cn.cocoding.cmfz.entity.Article;
public interface ArticleService{

    int insert(Article article);

    int insertSelective(Article article);

    int insertList(List<Article> articles);

    int update(Article article);
}
