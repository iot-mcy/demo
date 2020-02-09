package com.example.demo.model;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public static AjaxResponse success() {
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(0);
        response.setMessage("success");
        return response;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(0);
        response.setMessage("success");
        response.setData(data);
        return response;
    }

    public static AjaxResponse failure() {
        AjaxResponse response = new AjaxResponse();
        response.setIsok(false);
        response.setCode(1);
        response.setMessage("failure");
        return response;
    }
}
