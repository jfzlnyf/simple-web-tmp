package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-11
 * Time: 下午11:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginAction {

    @Resource
    LoginService loginService;

    @RequestMapping(value = "/login")
    public ModelAndView login(
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response,
           @RequestParam(value = "username") String username,
           @RequestParam(value = "password") String password
    ) {
        String token=loginService.doLogin(username,password,session);
        if(StringUtils.isNotEmpty(token)){
            try {
                response.sendRedirect("/index");
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return new ModelAndView("index");
        }else{
            return new ModelAndView("loginError");
        }

    }

    @RequestMapping(value = "/beforeLogin")
    public ModelAndView login() {
        ModelAndView mav=new ModelAndView("beforeLogin");
        return mav;
    }




    public static boolean checkLogin(HttpSession session){
        if(session.getAttribute("token")!=null){
           return true;
        }
        return false;
    }

    public static String getToken(HttpSession session){
        if(checkLogin(session)){
            return session.getAttribute("token")+"";
        }
        return null;
    }

}
