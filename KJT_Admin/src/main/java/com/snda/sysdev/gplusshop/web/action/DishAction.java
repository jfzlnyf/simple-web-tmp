package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.service.DishService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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


    @RequestMapping(value = "/edit")
    @ResponseBody
    public String editDishes(
            HttpSession session,
            @RequestParam(value = "restaurantId") String restaurantId,
            @RequestParam(value = "categoryId") String categoryId,
            @RequestBody String dishJson

    ){
        JSONArray editArray=new JSONArray();
        if(dishJson.startsWith("[")){
            //array
            editArray=JSONArray.fromObject(dishJson);
        }else if(dishJson.startsWith("{")){
            //object
            JSONObject editSingle=JSONObject.fromObject(dishJson);
            editArray.add(editSingle);
        }
        return dishService.mergeDishes(LoginAction.getToken(session), restaurantId, categoryId,editArray).toString();
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public String deleteCategories(
            HttpSession session,
            @RequestParam(value = "restaurantId") String restaurantId,
            @RequestParam(value = "categoryId") String categoryId,
            @RequestParam(value = "dishIds") List<String> dishIds

    ){
        return dishService.deleteDishes(LoginAction.getToken(session), restaurantId, categoryId,dishIds).toString();
    }







}
