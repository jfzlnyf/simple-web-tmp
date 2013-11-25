package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import com.snda.sysdev.gplusshop.web.service.DishService;
import com.snda.sysdev.gplusshop.web.service.LoginService;
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
    LoginService loginService;

    @Resource
    DishService dishService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getDishList(
            HttpSession session,
            @RequestParam(value = "restaurant") String restaurantId,
            @RequestParam(value = "category") String categoryId
    ){
        try {
            JSONArray retArray=dishService.getDishList(loginService.getToken(session),restaurantId,categoryId);
            return JSONObject.fromObject(new ReturnBean(true,"success",retArray)).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return JSONObject.fromObject(new ReturnBean(false,"server error")).toString();
    }


    @RequestMapping(value = "/edit")
    @ResponseBody
    public String editDishes(
            HttpSession session,
            @RequestBody String dishJson

    ){
        try {
            JSONArray editArray=new JSONArray();
            if(dishJson.startsWith("[")){
                //array
                editArray=JSONArray.fromObject(dishJson);
            }else if(dishJson.startsWith("{")){
                //object
                JSONObject editSingle=JSONObject.fromObject(dishJson);
                editArray.add(editSingle);
            }
            return dishService.mergeDishes(loginService.getToken(session), editArray).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return JSONObject.fromObject(new ReturnBean(false,"server error")).toString();
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public String deleteCategories(
            HttpSession session,
            @RequestParam(value = "restaurantId") String restaurantId,
            @RequestParam(value = "categoryId") String categoryId,
            @RequestParam(value = "dishIds") List<String> dishIds

    ){
        try {
            return dishService.deleteDishes(loginService.getToken(session), restaurantId, categoryId,dishIds).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return JSONObject.fromObject(new ReturnBean(false,"server error")).toString();
    }







}
