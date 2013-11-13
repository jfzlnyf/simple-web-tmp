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
                    .replace("${restaurantId}", restaurantId);
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
}
