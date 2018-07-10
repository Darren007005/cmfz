package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.entity.Article;
import cn.cocoding.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huzi on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //新增文章
    @RequestMapping("/createArticle")
    @ResponseBody
    public String createArticle(Article article){
        articleService.insertSelective(article);
       return "success";
    }
}
