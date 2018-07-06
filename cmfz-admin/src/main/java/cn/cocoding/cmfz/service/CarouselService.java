package cn.cocoding.cmfz.service;

import java.util.List;
import java.util.Map;

import cn.cocoding.cmfz.entity.Carousel;

public interface CarouselService {

    int insert(Carousel carousel);

    int insertSelective(Carousel carousel);

    int insertList(List<Carousel> carousels);

    int update(Carousel carousel);

    //查询所有的轮播图信息
    Map<String,Object> queryAllCarousel(int page, int rows);
}
