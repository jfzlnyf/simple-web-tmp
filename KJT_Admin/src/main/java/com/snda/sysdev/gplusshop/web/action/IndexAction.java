package com.snda.sysdev.gplusshop.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: nieyunfei
 * Date: 13-7-2
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexAction {
    private static Log log = LogFactory.getLog(IndexAction.class);




    @RequestMapping(value = "/")
    @ResponseBody
    public String index(
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(value = "openId",required = false)String openId
    ) {
        return "hello,"+openId;
    }


    @RequestMapping("/mobile/500")
    public ModelAndView to500(HttpServletResponse response) {
        response.setStatus(500);
        return new ModelAndView("500");
    }
}
