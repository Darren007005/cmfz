package cn.cocoding.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.cocoding.cmfz.entity.Manager;


public interface ManagerDao {
    int insert(@Param("manager") Manager manager);

    int insertSelective(@Param("manager") Manager manager);

    int insertList(@Param("managers") List<Manager> managers);

    int update(@Param("manager") Manager manager);

    //根据用户名进行查询
    Manager selectByManagerName(String managerName);
}
