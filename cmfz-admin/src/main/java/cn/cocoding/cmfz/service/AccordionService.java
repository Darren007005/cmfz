package cn.cocoding.cmfz.service;

import java.util.List;
import cn.cocoding.cmfz.entity.Accordion;
public interface AccordionService{

    int insert(Accordion accordion);

    int insertSelective(Accordion accordion);

    int insertList(List<Accordion> accordions);

    int update(Accordion accordion);
    //查询父级分类通过level ----- level = 1
    List<Accordion> queryAccordionsByLevel(Integer level);
    //根据前台传来的text查询出该text下所有的二级分类
    List<Accordion> queryAccordionsByText(String text);
}
