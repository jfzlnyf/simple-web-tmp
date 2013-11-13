package com.snda.sysdev.gplusshop.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nieyunfei
 * Date: 13-11-8
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class SignatureUtil {

    public static String createSignature(String key,Object... args){
        List<String> argStrList=new ArrayList<>();
        for (Object arg : args) {
            if(arg!=null){
               argStrList.add(arg.toString());
            }
        }
        argStrList.add(key);
        Collections.sort(argStrList);
        StringBuilder beforeSHA=new StringBuilder();
        for (String paraStr : argStrList) {
            beforeSHA.append(paraStr);
        }
        String afterSHA=null;
        try {
            MessageDigest instance=MessageDigest.getInstance("SHA-1");
            instance.update(beforeSHA.toString().getBytes());
            afterSHA=bytes2Hex(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return afterSHA;
    }

    public static String bytes2Hex(byte[]bts) {
        String des="";
        String tmp=null;
        for (int i=0;i<bts.length;i++) {
            tmp=(Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length()==1) {
                des+="0";
            }
            des+=tmp;
        }
        return des;
    }



}
