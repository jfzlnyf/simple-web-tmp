package com.snda.sysdev.gplusshop.web.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RestaurantService {

    @Value("${kjt.restaurant.list}")
    String listUrl;

    @Value("${kjt.restaurant.info}")
    String infoUrl;


    @Value("${kjt.restaurant.edit}")
    String editUrl;

    @Value("${kjt.restaurant.clone}")
    String cloneUrl;


    public JSONArray getRestaurantList(String token) {
        String content = null;
        JSONArray listJsonArray=new JSONArray();
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget2 = new HttpGet(listUrl);
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
            JSONObject listJson=JSONObject.fromObject(content);
            if(listJson!=null){
                listJsonArray=listJson.optJSONArray("restaurants");
                for (Object o : listJsonArray) {
                    JSONObject baseInfo=(JSONObject)o;
                    String restaurantId=baseInfo.optString("rid");
                    JSONObject extraInfo=getSingleRestaurant(token,restaurantId);
                    if(extraInfo!=null){
                        baseInfo.putAll(extraInfo);
                    }
                }
                return listJsonArray;
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return listJsonArray;
    }

    public JSONObject getSingleRestaurant(String token, String restaurantId) {
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=infoUrl.replace("{restaurantId}",restaurantId);
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
            JSONObject extraJson=JSONObject.fromObject(content);
            return extraJson;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
