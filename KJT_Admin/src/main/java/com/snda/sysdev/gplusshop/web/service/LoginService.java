package com.snda.sysdev.gplusshop.web.service;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-11
 * Time: 下午11:59
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoginService {

    @Value("${kjt.login}")
    String loginUrl;

    public String doLogin(String username, String password, HttpSession session) {
        String token=null;
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(loginUrl);
            httpPost.getParams().setParameter("http.protocol.content-charset", "UTF-8");
            httpPost.addHeader("Connection", "close");
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("username",username));
            nvps.add(new BasicNameValuePair("password",password));
            UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(nvps,"UTF-8");
            httpPost.setEntity(formEntity);
            HttpResponse response = httpclient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                Header[] headers=response.getHeaders("WSToken");
                if(headers!=null && headers.length>0){
                    token=headers[0].getValue();
                    session.setAttribute("token",token);
                    session.setAttribute("password",password);
                    session.setAttribute("username",username);
                    session.setAttribute("updateTime",new Date());
                }
            }else{
                System.out.println("login failed,status code:"+response.getStatusLine().getStatusCode());
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return token;
    }


    public String getToken(HttpSession session){
        try {
            if(checkLogin(session)){
                String token=null;
                //already login
                Date updateTime=(Date)session.getAttribute("updateTime");
                if((System.currentTimeMillis()-updateTime.getTime())/1000>120){
                   //login again to refresh token
                    token=doLogin(session.getAttribute("username")+"",session.getAttribute("password")+"",session);
                    System.out.println("token refreshed");
                }else{
                    token=session.getAttribute("token")+"";
                }
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }


    public static boolean checkLogin(HttpSession session){
        if(session.getAttribute("token")!=null){
           return true;
        }
        return false;
    }

}
