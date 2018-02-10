package com.universe.family.model.net;

import com.universe.family.utils.ResultStatus;

/**
 * 自定义返回结果
 * @author XieEnlong
 * @date 2015/7/14.
 */
public class ResultModel {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object ret;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getRet() {
        return ret;
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.msg = message;
        this.ret = "";
    }

    public ResultModel(int code, String message, Object content) {
        this.code = code;
        this.msg = message;
        this.ret = content;
    }

    public ResultModel(ResultStatus status) {
        this.code = status.getCode();
        this.msg = status.getMessage();
        this.ret = "";
    }

    public ResultModel(ResultStatus status, Object content) {
        this.code = status.getCode();
        this.msg = status.getMessage();
        this.ret = content;
    }

    public static ResultModel ok(Object content) {
        return new ResultModel(ResultStatus.SUCCESS, content);
    }

    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }
}
