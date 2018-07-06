package cn.cocoding.cmfz.entity;

import java.io.Serializable;

/**
 * Created by huzi on 2018/7/6.
 */
public class Guru implements Serializable{
    private Integer guruId;
    private String guruName;
    private String guruImage;
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
