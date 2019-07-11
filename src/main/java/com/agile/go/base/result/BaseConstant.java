package com.agile.go.base.result;

/**
 * @ClassName BaseConstant
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/24 17:55
 * @Version 1.0
 **/
public interface BaseConstant {

    interface HttpRequestMsg {
        int success=1;
        int fail=0;
        String successCode ="PMA_SUS-1000";// 成功
        String failCode = "PMA_EXP-1000";// 失败
        String okMsg = "请求成功";
        String errMsg = "请求失败";
    }
}
