package cn.cocoding.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.cocoding.cmfz.entity.Log;

public interface LogDao {
    int insert(@Param("log") Log log);

    int insertSelective(@Param("log") Log log);

    int insertList(@Param("logs") List<Log> logs);

    int update(@Param("log") Log log);
}
