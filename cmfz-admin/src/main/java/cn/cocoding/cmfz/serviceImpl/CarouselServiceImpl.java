package cn.cocoding.cmfz.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cocoding.cmfz.entity.Carousel;
import cn.cocoding.cmfz.dao.CarouselDao;
import cn.cocoding.cmfz.service.CarouselService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService{

    @Resource
    private CarouselDao carouselDao;

    @Override
    public int insert(Carousel carousel){
        return carouselDao.insert(carousel);
    }

    @Override
    public int insertSelective(Carousel carousel){
        return carouselDao.insertSelective(carousel);
    }

    @Override
    public int insertList(List<Carousel> carousels){
        return carouselDao.insertList(carousels);
    }

    @Override
    public int update(Carousel carousel){
        return carouselDao.update(carousel);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryAllCarousel(int page, int rows) {
        Map<String, Object> map = new HashMap<>();
        List<Carousel> carousels = carouselDao.selectAllCarousel((page-1)*rows,rows);
        int count = carouselDao.count();
        map.put("total",count);
        map.put("rows",carousels);
        return map;
    }



}
