package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-13
 * Time: 上午12:03
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/dish")
@Controller
public class DishAction {

    @Resource
    DishService dishService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getDishList(
            HttpSession session,
            @RequestParam(value = "restaurantId") String restaurantId,
            @RequestParam(value = "categoryId") String categoryId
    ){
            return dishService.getDishList(LoginAction.getToken(session),restaurantId,categoryId);
    }

}
