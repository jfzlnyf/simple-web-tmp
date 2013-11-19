package com.snda.sysdev.gplusshop.web.service;

import com.snda.sysdev.gplusshop.web.model.ReturnBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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


    public static final String[] apiFields=new String[]{
            "enName",
            "cnName",
            "exName",
            "hasLunchSpecial",
            "hasDinnerSpecial",
            "hasComboApp",
            "printMethod",
            "dishTax",
            "deliverTax",
            "deliveryFee",
            "minimumDelivery",
            "forwardedPhone",
            "contactPhone1",
            "contactPhone2",
            "fax",
            "address1",
            "address2",
            "city",
            "state",
            "zipcode",
            "hourText",
            "website",
            "creditCards",
            "comment"
    };

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

    public ReturnBean mergeRestaurants(String token, JSONArray editArray) {
        if(CollectionUtils.isNotEmpty(editArray)){
            for (Object tmp : editArray) {
                JSONObject restaurantJson=(JSONObject)tmp;
                //clean cid from frontend
                restaurantJson.remove("cid");
                String restaurantId=restaurantJson.optString("rid");
                JSONObject oldInfo=getSingleRestaurant(token,restaurantId);
                //do some clean
                JSONObject param=cleanAndCombine(restaurantJson, oldInfo, apiFields);

                //only edit here
                editSingleRestaurant(token, restaurantId, param);
            }

        }
        return new ReturnBean(true,"");
    }

    private JSONObject cleanAndCombine(JSONObject restaurantJson, JSONObject oldInfo, String[] apiFields) {
        List<String> tmpList= Arrays.asList(apiFields);
        JSONObject retValue=new JSONObject();
        for (Object o : restaurantJson.keySet()) {
            String key=(String)o;
            if(tmpList.contains(key)){
                //in api
                String oldValue=oldInfo.optString(key);
                String newValue=restaurantJson.optString(key);
                //put in new json
                retValue.put(key + "Changed", !StringUtils.equals(oldValue, newValue));
                retValue.put(key, restaurantJson.get(key));
            }
        }
        return retValue;
    }

    private String editSingleRestaurant(String token, String restaurantId, JSONObject restaurantJson) {
        String content = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url=editUrl
                    .replace("{restaurantId}", restaurantId);
            HttpPut httpget2 = new HttpPut(url);
            httpget2.addHeader("WSToken",token);
            httpget2.addHeader("Content-Type","application/json");
            StringEntity reqEntity = new StringEntity(restaurantJson.toString(),"UTF-8");
            httpget2.setEntity(reqEntity);
            HttpResponse response2 = httpclient.execute(httpget2);
            //todo
            if(true){
//            if(response2.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
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
