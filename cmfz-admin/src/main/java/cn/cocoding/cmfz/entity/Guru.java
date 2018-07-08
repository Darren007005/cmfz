package cn.cocoding.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by huzi on 2018/7/6.
 */
public class Guru implements Serializable{
    private Integer guruId;
    @Excel(name = "上师名称")
    private String guruName;
    private String guruImage;
    @Excel(name = "上师简介")
    private String guruIntroduction;

    public Integer getGuruId() {
        return guruId;
    }

    public void setGuruId(Integer guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruImage() {
        return guruImage;
    }

    public void setGuruImage(String guruImage) {
        this.guruImage = guruImage;
    }

    public String getGuruIntroduction() {
        return guruIntroduction;
    }

    public void setGuruIntroduction(String guruIntroduction) {
        this.guruIntroduction = guruIntroduction;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId=" + guruId +
                ", guruName='" + guruName + '\'' +
                ", guruImage='" + guruImage + '\'' +
                ", guruIntroduction='" + guruIntroduction + '\'' +
                '}';
    }
}
