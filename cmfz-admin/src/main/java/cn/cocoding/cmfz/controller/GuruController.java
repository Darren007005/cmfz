package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.entity.Guru;
import cn.cocoding.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by huzi on 2018/7/6.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    //查询满足需求条件的法师
    @RequestMapping("/guruJson")
    @ResponseBody
    public Map<String, Object> getGurus(String name,String value,int page, int rows){
        /*
        * 增加模糊查询，此处的name为模糊查询的条件，值需要和数据库中的字段名相同
        * value是输入框中的内容，以此作为模糊查询的where
        * */
        return guruService.queryGurus(name,value,page,rows);
    }
    //更新数据
    @RequestMapping("/update")
    @ResponseBody
    public String updateGuru(Guru guru){
        int i = guruService.update(guru);
        if(i>0){
            return "success";
        }
        return "fail";
    }

}
