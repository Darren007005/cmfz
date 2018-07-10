package cn.cocoding.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.cocoding.cmfz.entity.Article;

public interface ArticleDao {
    int insert(@Param("article") Article article);

    int insertSelective(@Param("article") Article article);

    int insertList(@Param("articles") List<Article> articles);

    int update(@Param("article") Article article);
}
