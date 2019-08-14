package com.qch.shop.entity;

import com.qch.shop.constant.StatusConstant;

public class Result {

    private Integer status;
    private String msg;
    private Object obj;

    Result(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static Result ok() {
        return new Result(StatusConstant.SUCCESS, null, null);
    }

    public static Result ok(String msg) {
        return new Result(StatusConstant.SUCCESS, msg, null);
    }

    public static Result ok(String msg, Object obj) {
        return new Result(StatusConstant.SUCCESS, msg, obj);
    }

    public static Result error() {
        return new Result(StatusConstant.ERROR, null, null);
    }

    public static Result error(String msg) {
        return new Result(StatusConstant.ERROR, msg, null);
    }

    public static Result error(String msg, Object obj) {
        return new Result(StatusConstant.ERROR, msg, obj);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
