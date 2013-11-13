package com.snda.sysdev.gplusshop.web.action;

import com.snda.sysdev.gplusshop.web.model.Message;
import com.snda.sysdev.gplusshop.web.util.SignatureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 * User: nieyunfei
 * Date: 13-11-7
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class APIAction {

    @Value(value = "${weixin.token}")
    String token;

    @Value(value = "${weixin.user}")
    String weixinUser;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(value = "signature",required = false) String signature,
            @RequestParam(value = "timestamp",required = false) String timestamp,
            @RequestParam(value = "nonce",required = false) String nonce,
            @RequestParam(value = "echostr",required = false) String echostr
    ) {
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("token:"+token);
        String mySignature= SignatureUtil.createSignature(token,timestamp,nonce);
        System.out.println(mySignature);
        if(signature.equals(mySignature)){
            return echostr;
        }else{
            return "false";
        }
    }


    String template="<xml>\n" +
            "<ToUserName><![CDATA[${toUser}]]></ToUserName>\n" +
            "<FromUserName><![CDATA[${fromUser}]]></FromUserName>\n" +
            "<CreateTime>${createTime}</CreateTime>\n" +
            "<MsgType><![CDATA[text]]></MsgType>\n" +
            "<Content><![CDATA[${content}]]></Content>\n" +
            "</xml>";


    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @ResponseBody
    public String hello(
            HttpServletRequest request,
            @RequestBody String requestBody){
        System.out.println(request.getQueryString());
        System.out.println(requestBody);
        try {
            JAXBContext ctx= JAXBContext.newInstance(Message.class);
            Unmarshaller u = ctx.createUnmarshaller();
            Message message=(Message)u.unmarshal(new StringReader(requestBody));
            String openId=message.getFromUserName();
            String content=message.getContent();
            String replyMessageStr=null;
            if(content.equals("答题")){
                replyMessageStr=answer(message);
            }else{
                String reply=content+"_"+"ffffffuck";
                replyMessageStr=
                        template.replace("${toUser}", openId)
                                .replace("${fromUser}", message.getToUserName())
                                .replace("${createTime}", message.getCreateTime())
                                .replace("${content}", reply);
            }
            System.out.println("output:"+replyMessageStr);
            return replyMessageStr;
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "ok";
    }

    private String answer(Message message) {
       String test="<xml>\n" +
               "<ToUserName><![CDATA[${toUser}]]></ToUserName>\n" +
               "<FromUserName><![CDATA[${fromUser}]]></FromUserName>\n" +
               "<CreateTime>${createTime}</CreateTime>\n" +
               "<MsgType><![CDATA[news]]></MsgType>\n" +
               "<ArticleCount>2</ArticleCount>\n" +
               "<Articles>\n" +
               "<item>\n" +
               "<Title><![CDATA[官方激活码大放送啦]]></Title> \n" +
               "<Description><![CDATA[官方激活码大放送啦]]></Description>\n" +
               "<PicUrl><![CDATA[http://121.14.48.94/static/logo.png]]></PicUrl>\n" +
               "<Url><![CDATA[http://www.hearthstone.com.cn/home]]></Url>\n" +
               "</item>\n" +
               "<item>\n" +
               "<Title><![CDATA[答题送爱疯10]]></Title>\n" +
               "<Description><![CDATA[答题送爱疯10]]></Description>\n" +
               "<PicUrl><![CDATA[http://121.14.48.94/static/logo2.png]]></PicUrl>\n" +
               "<Url><![CDATA[http://121.14.48.94?openId=test]]></Url>\n" +
               "</item>\n" +
               "</Articles>\n" +
               "</xml> ";
        return test.replace("${toUser}", message.getFromUserName())
                .replace("${fromUser}", message.getToUserName())
                .replace("${createTime}", message.getCreateTime());
    }

}
