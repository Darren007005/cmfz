package cn.cocoding.cmfz.controller;

import cn.cocoding.cmfz.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by huzi on 2018/6/6.
 */
@Controller
public class CreateVcodeController {
    //生成验证码并打回页面
    @RequestMapping("/getVcode")
    public void validateCode(HttpSession session, HttpServletResponse response) throws IOException {
        //1.创建工具对象，并生成验证码
        CreateValidateCode vCode = new CreateValidateCode(80, 30, 4, 8);

        //2.保存在Session作用域
        session.setAttribute("Vcode", vCode.getCode());

        //3.使用response获得指向客户端的流对象，并输出
        vCode.write(response.getOutputStream());
    }
}
