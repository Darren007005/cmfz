package cn.cocoding.cmfz.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.cocoding.cmfz.entity.Article;
import cn.cocoding.cmfz.dao.ArticleDao;
import cn.cocoding.cmfz.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    private ArticleDao articleDao;

    @Override
    public int insert(Article article){
        return articleDao.insert(article);
    }

    @Override
    public int insertSelective(Article article){
        return articleDao.insertSelective(article);
    }

    @Override
    public int insertList(List<Article> articles){
        return articleDao.insertList(articles);
    }

    @Override
    public int update(Article article){
        return articleDao.update(article);
    }
}
