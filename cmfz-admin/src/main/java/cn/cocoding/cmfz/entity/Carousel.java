package cn.cocoding.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huzi on 2018/7/5.
 */
public class Carousel implements Serializable{
    private Integer carouselId;
    private String carouselName;
    private String carouselDescribe;
    private String carouselStatus;
    private Date carouselDate;

    public Carousel() {
    }

    public Carousel(Integer carouselId, String carouselName, String carouselDescribe, String carouselStatus, Date carouselDate) {
        this.carouselId = carouselId;
        this.carouselName = carouselName;
        this.carouselDescribe = carouselDescribe;
        this.carouselStatus = carouselStatus;
        this.carouselDate = carouselDate;
    }

    public Integer getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Integer carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselName() {
        return carouselName;
    }

    public void setCarouselName(String carouselName) {
        this.carouselName = carouselName;
    }

    public String getCarouselDescribe() {
        return carouselDescribe;
    }

    public void setCarouselDescribe(String carouselDescribe) {
        this.carouselDescribe = carouselDescribe;
    }

    public String getCarouselStatus() {
        return carouselStatus;
    }

    public void setCarouselStatus(String carouselStatus) {
        this.carouselStatus = carouselStatus;
    }

    public Date getCarouselDate() {
        return carouselDate;
    }

    public void setCarouselDate(Date carouselDate) {
        this.carouselDate = carouselDate;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "carouselId=" + carouselId +
                ", carouselName='" + carouselName + '\'' +
                ", carouselDescribe='" + carouselDescribe + '\'' +
                ", carouselStatus='" + carouselStatus + '\'' +
                ", carouselDate=" + carouselDate +
                '}';
    }
}
