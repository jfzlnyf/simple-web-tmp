package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import com.snda.sysdev.gplusshop.web.service.RestaurantService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-12
 * Time: 上午12:32
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/restaurant")
@Controller
public class RestaurantAction {

    @Resource
    RestaurantService restaurantService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getRestaurantList(
            HttpSession session
    ){
        JSONArray  retArray=restaurantService.getRestaurantList(LoginAction.getToken(session));
        return JSONObject.fromObject(new ReturnBean(true,"success",retArray)).toString();
    }


}
