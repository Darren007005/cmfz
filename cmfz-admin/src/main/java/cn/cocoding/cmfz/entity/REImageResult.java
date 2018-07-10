package cn.cocoding.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by huzi on 2018/7/8.
 */
public class REImageResult implements Serializable{
    private Integer errno;
    private List<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
