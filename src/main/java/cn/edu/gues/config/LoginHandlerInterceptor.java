package cn.edu.gues.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:46
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object jobNo = request.getSession().getAttribute("jobNo");
        Object name = request.getSession().getAttribute("name");
        if (jobNo==null ||name==null){
            request.setAttribute("error","无权限，请登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}

