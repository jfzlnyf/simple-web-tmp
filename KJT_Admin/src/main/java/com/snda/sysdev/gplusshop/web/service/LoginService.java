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
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(loginUrl);
            httpPost.getParams().setParameter("http.protocol.content-charset", "UTF-8");
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
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return token;
    }
}
