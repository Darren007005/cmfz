package cn.cocoding.cmfz.entity;

import java.io.Serializable;

/**
 * Created by huzi on 2018/7/5.
 */
public class Accordion implements Serializable{
    //分类的id
    private Integer id;
    //分类的文本内容
    private String text;
    //分类的图标
    private String iconCls;
    //分类的二级的url
    private String url;
    //分类的级别
    private Integer level;
    //分类的父id
    private Integer parentId;

    public Accordion() {
    }

    public Accordion(Integer id, String text, String iconCls, String url, Integer level, Integer parentId) {
        this.id = id;
        this.text = text;
        this.iconCls = iconCls;
        this.url = url;
        this.level = level;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Accordion{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
