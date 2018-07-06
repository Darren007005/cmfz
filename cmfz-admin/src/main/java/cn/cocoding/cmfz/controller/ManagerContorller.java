package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.entity.Manager;
import cn.cocoding.cmfz.service.ManagerService;
import cn.cocoding.cmfz.util.CookiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by huzi on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
@SessionAttributes(value = {"managerName"})
public class ManagerContorller {
    @Autowired
    private ManagerService managerService;
    //访问登陆页面
    @RequestMapping("/login")
    public String login(HttpServletResponse response, Manager manager, boolean isRememberUsername, Model model) throws UnsupportedEncodingException {

        //根据前台传来的用户名和密码进行登陆判断
        Manager manager1 = managerService.queryManagerByNameAndPwd(manager.getManagerName(), manager.getManagerPassword());
        if(manager1!=null){
            //将用户名存到session中
            model.addAttribute("managerName",manager1.getManagerName());
            if(isRememberUsername){
                //调用工具cookiesUtil中的方法，创建cookie
                CookiesUtil.addCookie(response,"managerName",java.net.URLEncoder.encode(manager1.getManagerName(),"UTF-8"),30000);
            }
            return "main/main";
        }
        return "login";
    }

}
