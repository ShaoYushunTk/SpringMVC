package org.example.controller;

/**
 *
 * 表现层与前端数据传输协议定义
 *
 * 将返回结果的数据进行统一，具体如何来做，大体的思路为:
 * 1.为了封装返回的结果数据:创建结果模型类，封装数据到data属性中
 * 2.为了封装返回的数据是何种操作及是否操作成功:封装操作结果到code属性中
 * 3.操作失败后为了封装返回的错误信息:封装特殊消息到message(msg)属性中
 */
public class Result {
    private Object data;
    private Integer code;
    private String msg;

    public Result(Integer code, Object data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Result() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
