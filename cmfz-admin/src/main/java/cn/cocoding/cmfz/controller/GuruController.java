package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.entity.Guru;
import cn.cocoding.cmfz.service.GuruService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.jeecgframework.poi.excel.entity.vo.MapExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

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
    //导出上师信息--excel
    //"注意：此处不要用异步请求方式访问。浏览器执行不会下载操作！"

    @RequestMapping("/exportExcel")
    public String exportExcel(ModelMap modelMap) throws IOException {
        //用于表中的字段名称（编号、名称、简介）
        List<ExcelExportEntity> entityList = new ArrayList<>();
        //变革的正文内容
        List<Map<String,Object>> dataResult = new ArrayList<>();
        //从数据库中查询所有上师信息，用List存储
        List<Guru> gurus=guruService.queryAllGuru();

        //设置表格的字段名称
        entityList.add(new ExcelExportEntity("上师编号", "guruId", 15));
        entityList.add(new ExcelExportEntity("上师名称", "guruName", 15));
        entityList.add(new ExcelExportEntity("上师简介", "guruIntroduction", 25));
        //遍历查询结果List
        for (Guru g:gurus) {
            Map<String, Object> map = new HashMap<>();
            map.put("guruId", g.getGuruId());
            map.put("guruName", g.getGuruName());
            map.put("guruIntroduction", g.getGuruIntroduction());
            dataResult.add(map);
        }
        modelMap.put(MapExcelConstants.ENTITY_LIST, entityList);
        modelMap.put(MapExcelConstants.MAP_LIST, dataResult);
        String fileName = "上师表";        //下载的文件名称

        modelMap.put("fileName", fileName);     //文件名称
        //title代表表格中的信息，sheetName代笔表格工作区名称
        modelMap.put("params", new ExportParams("上师信息表", "创建时间"+new Date().toLocaleString(),"基本信息"));
        //返回一个字符串"jeecgMapExcelView"，用高级视图解析器解析成文件下载操作。具体怎么操作不知道
        return MapExcelConstants.JEECG_MAP_EXCEL_VIEW;
    }
    //上师的批量导入
    @RequestMapping("/importExcel")
    @ResponseBody
    public String importExcel(MultipartFile fileExcel){
        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(2);
            params.setHeadRows(1);
            List<Guru> gurus = ExcelImportUtil.importExcel( fileExcel.getInputStream(), Guru.class, params);
            if ((gurus != null) && (guruService.insertList(gurus)>0)){
                return "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

}
