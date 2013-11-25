package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import com.snda.sysdev.gplusshop.web.service.CategoryService;
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
 * Date: 13-11-12
 * Time: 下午11:59
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/category")
@Controller
public class CategoryAction {

    @Resource
    LoginService loginService;

    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getCategoryList(
            HttpSession session,
            @RequestParam(value = "restaurant") String restaurantId
    ){
        try {
            JSONArray  retArray=categoryService.getCategoryList(loginService.getToken(session),restaurantId);
            return JSONObject.fromObject(new ReturnBean(true,"success",retArray)).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return JSONObject.fromObject(new ReturnBean(false,"server error")).toString();
    }




    @RequestMapping(value = "/edit")
    @ResponseBody
    public String editCategories(
            HttpSession session,
            @RequestBody String categoryJson

    ){
        try {
            JSONArray editArray=new JSONArray();
            if(categoryJson.startsWith("[")){
                //array
                editArray=JSONArray.fromObject(categoryJson);
            }else if(categoryJson.startsWith("{")){
                //object
                JSONObject editSingle=JSONObject.fromObject(categoryJson);
                editArray.add(editSingle);
            }
            return categoryService.mergeCategories(loginService.getToken(session), editArray).toString();
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
            @RequestParam(value = "categoryIds") List<String> categoryIds

    ){
        try {
            return categoryService.deleteCategories(loginService.getToken(session), restaurantId, categoryIds).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return JSONObject.fromObject(new ReturnBean(false,"server error")).toString();
    }





}
