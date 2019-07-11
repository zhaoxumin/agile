package com.agile.go.base.result;

/**
 * @ClassName BaseResponse
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/24 16:52
 * @Version 1.0
 **/
public class BaseResponse <T> {
    private String code;
    private String desc;
    private int result;
    private T data;


    public BaseResponse() {
    }

    public BaseResponse(String code, String desc, int result, T data) {
        this.code = code;
        this.desc = desc;
        this.result = result;
        this.data = data;
    }

    public BaseResponse(String desc, int result, T data) {
        this.desc = desc;
        this.result = result;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

