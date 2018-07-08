package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.entity.Accordion;
import cn.cocoding.cmfz.service.AccordionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huzi on 2018/7/5.
 */
@Controller
@RequestMapping("/accordion")
public class AccordionController {
    @Autowired
    private AccordionService accordionService;
    //获取一级分类
    @RequestMapping("/getParentMenu")
    @ResponseBody
    public List<Accordion> getParentMenu(){
        return accordionService.queryAccordionsByLevel(1);
    }
    //根据一级分类传来的id获取该id下的二级分类
    @RequestMapping("/getMenuTree")
    @ResponseBody
    public List<Accordion> getMenuTree(String text){
        return accordionService.queryAccordionsByText(text);
    }
}
