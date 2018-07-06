package cn.cocoding.cmfz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huzi on 2018/6/6.
 */
public class CheckValidateCode implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String StoreVcode = (String) httpServletRequest.getSession().getAttribute("Vcode");
        System.out.println(StoreVcode);
        String Vcode = httpServletRequest.getParameter("Vcode");
        System.out.println(Vcode);
        if(StoreVcode.equals(Vcode)){
            return true;
        }else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
