package cn.cocoding.cmfz.service;

import java.util.List;
import cn.cocoding.cmfz.entity.Manager;
public interface ManagerService{

    int insert(Manager manager);

    int insertSelective(Manager manager);

    int insertList(List<Manager> managers);

    int update(Manager manager);

    //根据managerName查询用户
    Manager queryManagerByNameAndPwd(String managerName,String managerPassword);
}
