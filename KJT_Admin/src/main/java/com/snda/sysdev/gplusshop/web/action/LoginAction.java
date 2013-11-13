package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
           @RequestParam(value = "username") String username,
           @RequestParam(value = "password") String password
    ) {
        ModelAndView mav=new ModelAndView("afterLogin");
        String token=loginService.doLogin(username,password,session);
        mav.addObject("token",token);
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
