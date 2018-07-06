package cn.cocoding.cmfz.entity;

import java.io.Serializable;

/**
 * Created by huzi on 2018/7/4.
 */
public class Manager implements Serializable{
    private String managerId;
    private String managerName;
    private String managerPassword;
    private Integer managerStatus;
    private String salt;

    public Manager() {
    }

    public Manager(String managerId, String managerName, String managerPassword, int managerStatus, String salt) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.managerStatus = managerStatus;
        this.salt = salt;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public int getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(int managerStatus) {
        this.managerStatus = managerStatus;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", managerStatus=" + managerStatus +
                ", salt='" + salt + '\'' +
                '}';
    }
}
