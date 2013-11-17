package com.snda.sysdev.gplusshop.web.service;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-13
 * Time: 上午12:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DishService {

    @Value("${kjt.dish.list}")
    String listUrl;

    @Value("${kjt.dish.edit}")
    String editUrl;

    @Value("${kjt.dish.add}")
    String addUrl;

    @Value("${kjt.dish.delete}")
    String deleteUrl;

    public String getDishList(String token,String restaurantId,String categoryId){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url="listUrl"
                    .replace("{restaurantId}",restaurantId)
                    .replace("{categoryId}",categoryId);
            HttpGet httpget2 = new HttpGet(url);
            httpget2.addHeader("WSToken",token);
            HttpResponse response2 = httpclient.execute(httpget2);
            if(response2.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                BufferedReader in = null;
                in = new BufferedReader(new InputStreamReader(response2.getEntity()
                        .getContent()));
                StringBuffer sb = new StringBuffer("");
                String line;
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                content = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return content;
    }

    public String editSingleDish(String token,String restaurantId,String categoryId,String dishId,JSONObject singleDish){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=editUrl
                    .replace("{restaurantId}", restaurantId)
                    .replace("{categoryId}", categoryId)
                    .replace("{dishId}", dishId);
            HttpPut editRequest = new HttpPut(url);
            editRequest.addHeader("WSToken", token);
            editRequest.addHeader("Content-Type", "application/json");
            StringEntity reqEntity = new StringEntity(singleDish.toString(),"UTF-8");
            editRequest.setEntity(reqEntity);
            HttpResponse response2 = httpclient.execute(editRequest);
            if(response2.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                BufferedReader in = null;
                in = new BufferedReader(new InputStreamReader(response2.getEntity()
                        .getContent()));
                StringBuffer sb = new StringBuffer("");
                String line;
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                content = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return content;
    }

    public String deleteSingleDish(String token,String restaurantId,String categoryId,String dishId){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=deleteUrl
                    .replace("{restaurantId}", restaurantId)
                    .replace("{categoryId}", categoryId)
                    .replace("{dishId}", dishId);
            HttpDelete httpget2 = new HttpDelete(url);
            httpget2.addHeader("WSToken",token);
            HttpResponse response2 = httpclient.execute(httpget2);
            if(response2.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                BufferedReader in = null;
                in = new BufferedReader(new InputStreamReader(response2.getEntity()
                        .getContent()));
                StringBuffer sb = new StringBuffer("");
                String line;
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                content = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return content;
    }


    public ReturnBean editDishes(String token,String restaurantId,String categoryId,JSONArray dishArray){
        if(CollectionUtils.isNotEmpty(dishArray)){
            for (Object tmp : dishArray) {
                JSONObject dishJson=(JSONObject)tmp;
                String dishId=dishJson.optString("dishId");
                dishJson.remove("dishId");
                editSingleDish(token, restaurantId, categoryId, dishId, dishJson);
            }
        }
        return new ReturnBean(true,"");
    }

    public ReturnBean mergeDishes(String token,String restaurantId,String categoryId,JSONArray dishArray){
        if(CollectionUtils.isNotEmpty(dishArray)){
            for (Object tmp : dishArray) {
                JSONObject dishJson=(JSONObject)tmp;
                String dishId=dishJson.optString("did");
                if(StringUtils.isNotEmpty(dishId)){
                    //edit
                    dishJson.remove("did");
                    editSingleDish(token, restaurantId, categoryId, dishId, dishJson);
                }else{
                    //add
                    dishJson.put("rid",restaurantId);
                    dishJson.put("cid",categoryId);
                    addSingleDish(token, restaurantId, categoryId, dishJson);
                }
            }

        }
        return new ReturnBean(true,"");
    }

    public ReturnBean deleteDishes(String token,String restaurantId,String categoryId,List<String> dishIds){
        if(CollectionUtils.isNotEmpty(dishIds)){
            for (String dishId : dishIds) {
                deleteSingleDish(token,restaurantId,categoryId,dishId);
            }
        }
        return new ReturnBean(true,"");
    }

    public String addSingleDish(String token,String restaurantId, String categoryId,JSONObject dishJson){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=addUrl
                    .replace("{restaurantId}", restaurantId)
                    .replace("{categoryId}", categoryId);
            HttpPost addRequest = new HttpPost(url);
            addRequest.addHeader("WSToken", token);
            addRequest.addHeader("Content-Type", "application/json");
            JSONObject allInfo=new JSONObject();
            JSONArray list=new JSONArray();
            list.add(dishJson);
            allInfo.put("dishes",list);
            StringEntity reqEntity = new StringEntity(allInfo.toString(),"UTF-8");
            addRequest.setEntity(reqEntity);
            HttpResponse response2 = httpclient.execute(addRequest);
            //todo
            if(true){
                BufferedReader in = null;
                in = new BufferedReader(new InputStreamReader(response2.getEntity()
                        .getContent()));
                StringBuffer sb = new StringBuffer("");
                String line;
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                content = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(content);
        return content;
    }


}
