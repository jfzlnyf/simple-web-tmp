package com.snda.sysdev.gplusshop.web.service;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                    .replace("${restaurantId}",restaurantId)
                    .replace("${categoryId}",categoryId);
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

    public String editSingleCategory(String token,String restaurantId,String categoryId,JSONObject singleCategory){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=editUrl
                    .replace("${restaurantId}", restaurantId)
                    .replace("${categoryId}", categoryId);
            HttpPut httpget2 = new HttpPut(url);
            httpget2.addHeader("WSToken",token);
            StringEntity reqEntity = new StringEntity(singleCategory.toString(),"UTF-8");
            httpget2.setEntity(reqEntity);
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

    public String deleteSingleCategory(String token,String restaurantId,String categoryId){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=deleteUrl
                    .replace("${restaurantId}", restaurantId)
                    .replace("${categoryId}", categoryId);
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

    public ReturnBean editCategories(String token,String restaurantId,JSONArray categoryArray){
        if(CollectionUtils.isNotEmpty(categoryArray)){
            for (Object tmp : categoryArray) {
                JSONObject categoryJson=(JSONObject)tmp;
                String categoryId=categoryJson.optString("categoryId");
                categoryJson.remove("categoryId");
                editSingleCategory(token,restaurantId,categoryId,categoryJson);
            }
        }
        return new ReturnBean(true,"");
    }
}
