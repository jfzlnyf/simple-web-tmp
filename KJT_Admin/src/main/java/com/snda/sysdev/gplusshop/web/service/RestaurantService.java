package com.snda.sysdev.gplusshop.web.service;

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

    @Value("${kjt.restaurant.edit}")
    String editUrl;

    @Value("${kjt.restaurant.clone}")
    String cloneUrl;


    public String getRestaurantList(String token) {
        String content = null;
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
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return content;
    }
}
