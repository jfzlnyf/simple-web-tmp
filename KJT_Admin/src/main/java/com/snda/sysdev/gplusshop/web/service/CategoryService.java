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
 * Date: 13-11-12
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CategoryService {

    @Value("${kjt.category.list}")
    String listUrl;

    @Value("${kjt.category.edit}")
    String editUrl;

    @Value("${kjt.category.add}")
    String addUrl;

    @Value("${kjt.category.delete}")
    String deleteUrl;

    public String getCategoryList(String token,String restaurantId){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=listUrl
                    .replace("{restaurantId}", restaurantId);
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
                    .replace("{restaurantId}", restaurantId)
                    .replace("{categoryId}", categoryId);
            HttpPut httpget2 = new HttpPut(url);
            httpget2.addHeader("WSToken",token);
            httpget2.addHeader("Content-Type","application/json");
            StringEntity reqEntity = new StringEntity(singleCategory.toString(),"UTF-8");
            httpget2.setEntity(reqEntity);
            HttpResponse response2 = httpclient.execute(httpget2);
            //todo
            if(response2.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
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

    public String deleteSingleCategory(String token,String restaurantId,String categoryId){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=deleteUrl
                    .replace("{restaurantId}", restaurantId)
                    .replace("{categoryId}", categoryId);
            HttpDelete deleteRequest = new HttpDelete(url);
            deleteRequest.addHeader("WSToken", token);
            HttpResponse response2 = httpclient.execute(deleteRequest);
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

    public ReturnBean mergeCategories(String token, String restaurantId, JSONArray categoryArray){
        if(CollectionUtils.isNotEmpty(categoryArray)){
            for (Object tmp : categoryArray) {
                JSONObject categoryJson=(JSONObject)tmp;
                String categoryId=categoryJson.optString("cid");
                if(StringUtils.isNotEmpty(categoryId)){
                    //edit
                    categoryJson.remove("cid");
                    editSingleCategory(token,restaurantId,categoryId,categoryJson);
                }else{
                    //add
                    categoryJson.put("rid",restaurantId);
                    addSingleCategory(token, restaurantId, categoryJson);
                }
            }

        }
        return new ReturnBean(true,"");
    }

    public ReturnBean deleteCategories(String token,String restaurantId,List<String> categoryIds){
        if(CollectionUtils.isNotEmpty(categoryIds)){
            for (String categoryId : categoryIds) {
                deleteSingleCategory(token,restaurantId,categoryId);
            }
        }
        return new ReturnBean(true,"");
    }

    public String addSingleCategory(String token,String restaurantId,JSONObject singleCategory){
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=addUrl
                    .replace("{restaurantId}", restaurantId);
            HttpPost addRequest = new HttpPost(url);
            addRequest.addHeader("WSToken", token);
            addRequest.addHeader("Content-Type", "application/json");
            JSONObject allInfo=new JSONObject();
            JSONArray list=new JSONArray();
            list.add(singleCategory);
            allInfo.put("categories",list);
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
