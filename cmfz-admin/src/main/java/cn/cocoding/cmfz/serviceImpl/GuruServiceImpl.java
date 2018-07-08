package cn.cocoding.cmfz.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cocoding.cmfz.entity.Guru;
import cn.cocoding.cmfz.dao.GuruDao;
import cn.cocoding.cmfz.service.GuruService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuruServiceImpl implements GuruService{

    @Resource
    private GuruDao guruDao;

    @Override
    public int insert(Guru guru){
        return guruDao.insert(guru);
    }

    @Override
    public int insertSelective(Guru guru){
        return guruDao.insertSelective(guru);
    }

    @Override
    public int insertList(List<Guru> gurus){
        return guruDao.insertList(gurus);
    }

    @Override
    public int update(Guru guru){
        return guruDao.update(guru);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryGurus(String name, String value, int page, int rows) {
        Map<String,Object> map = new HashMap<>();
        int count = guruDao.count(name,value);
        List<Guru> gurus = guruDao.selectGurus(name,value,(page-1)*rows,rows);
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    public List<Guru> queryAllGuru() {
        return guruDao.selectAllGuru();
    }
}
