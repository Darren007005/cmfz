package cn.cocoding.cmfz.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.cocoding.cmfz.entity.Log;
import cn.cocoding.cmfz.dao.LogDao;
import cn.cocoding.cmfz.service.LogService;

@Service
public class LogServiceImpl implements LogService{

    @Resource
    private LogDao logDao;
    @Override
    public int modifyInsertSelective(Log log) {
        return logDao.insert(log);
    }
}
