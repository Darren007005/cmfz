package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.entity.Carousel;
import cn.cocoding.cmfz.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by huzi on 2018/7/5.
 */
@Controller
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    //返回给carousel.jsp 所有轮播图json格式数据
    @RequestMapping("/carouselJson")
    @ResponseBody
    public Map<String, Object> getCarousel(int page,int rows){
        return carouselService.queryAllCarousel(page,rows);
    }
}
