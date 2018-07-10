package cn.cocoding.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huzi on 2018/7/8.
 */
public class Article implements Serializable{
    private Integer articleId;
    private String articleName;
    private String articleContent;
    private String articleAuthor;
    private Date articleDate;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleDate=" + articleDate +
                '}';
    }
}
