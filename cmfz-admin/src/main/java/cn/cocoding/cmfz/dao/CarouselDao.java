package cn.cocoding.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.cocoding.cmfz.entity.Carousel;

public interface CarouselDao {
    int insert(@Param("carousel") Carousel carousel);

    int insertSelective(@Param("carousel") Carousel carousel);

    int insertList(@Param("carousels") List<Carousel> carousels);

    int update(@Param("carousel") Carousel carousel);

    //查询所有的轮播图信息
    List<Carousel> selectAllCarousel(@Param("begin") int begin,@Param("rows") int rows);
    //查询轮播图总数量
    int count();
}
