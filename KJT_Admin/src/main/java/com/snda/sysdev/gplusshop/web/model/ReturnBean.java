package com.snda.sysdev.gplusshop.web.model;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;


/**
 * Created by IntelliJ IDEA.
 * User: luwenjia
 * Date: 2009-7-8
 * Time: 10:39:01
 * To change this template use File | Settings | File Templates.
 */
public class ReturnBean {
    public boolean success = false;
    public String message = "";
    public Object data;
    public Long total=0l;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ReturnBean() {
    }

    public ReturnBean(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ReturnBean(boolean b, String s) {
        this.success = b;
        this.message = s;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
