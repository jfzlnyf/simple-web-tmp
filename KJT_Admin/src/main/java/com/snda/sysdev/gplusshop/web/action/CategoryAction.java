package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午11:59
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/category")
@Controller
public class CategoryAction {

    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getCategoryList(
            HttpSession session,
            @RequestParam(value = "restaurantId") String restaurantId
    ){
          return categoryService.getCategoryList(LoginAction.getToken(session),restaurantId);
    }
}
