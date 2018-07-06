package cn.cocoding.cmfz.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.cocoding.cmfz.entity.Manager;
import cn.cocoding.cmfz.dao.ManagerDao;
import cn.cocoding.cmfz.service.ManagerService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ManagerDao managerDao;

    @Override
    public int insert(Manager manager){
        return managerDao.insert(manager);
    }

    @Override
    public int insertSelective(Manager manager){
        return managerDao.insertSelective(manager);
    }

    @Override
    public int insertList(List<Manager> managers){
        return managerDao.insertList(managers);
    }

    @Override
    public int update(Manager manager){
        return managerDao.update(manager);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Manager queryManagerByNameAndPwd(String managerName, String managerPassword) {
        Manager manager = managerDao.selectByManagerName(managerName);
        if(manager!=null){
            if(manager.getManagerPassword().equals(managerPassword)){
                return manager;
            }
        }
        return null;
    }
}
