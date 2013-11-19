package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import com.snda.sysdev.gplusshop.web.service.LoginService;
import com.snda.sysdev.gplusshop.web.service.RestaurantService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    LoginService loginService;

    @Resource
    RestaurantService restaurantService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getRestaurantList(
            HttpSession session
    ){
        JSONArray  retArray=restaurantService.getRestaurantList(loginService.getToken(session));
        return JSONObject.fromObject(new ReturnBean(true,"success",retArray)).toString();
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public String editRestaurants(
            HttpSession session,
            @RequestBody String restaurantJson

    ){
        System.out.println(restaurantJson);
        JSONArray editArray=new JSONArray();
        if(restaurantJson.startsWith("[")){
            //array
            editArray=JSONArray.fromObject(restaurantJson);
        }else if(restaurantJson.startsWith("{")){
            //object
            JSONObject editSingle=JSONObject.fromObject(restaurantJson);
            editArray.add(editSingle);
        }
        return restaurantService.mergeRestaurants(loginService.getToken(session), editArray).toString();
    }




}
