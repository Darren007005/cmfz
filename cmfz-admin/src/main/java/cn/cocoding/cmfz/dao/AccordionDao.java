package cn.cocoding.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.cocoding.cmfz.entity.Accordion;

public interface AccordionDao {
    int insert(@Param("accordion") Accordion accordion);

    int insertSelective(@Param("accordion") Accordion accordion);

    int insertList(@Param("accordions") List<Accordion> accordions);

    int update(@Param("accordion") Accordion accordion);

    //根据level查询出所有的父级分类
    List<Accordion> selectAccordionsByLevel(Integer level);

    //根据一级的text查出一级的id -- 将该id作为查询二级的条件
    Accordion selectAccordionByText(String text);

    //根据查出的条件id,查询出该id下所有的二级分类
    List<Accordion> selectAccordionsByPid(Integer parentId);

}
