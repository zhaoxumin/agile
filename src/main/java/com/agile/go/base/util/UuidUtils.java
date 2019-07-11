package com.agile.go.base.util;

import java.util.UUID;

/**
 * @ClassName UuidUtils
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/24 17:25
 * @Version 1.0
 **/
public class UuidUtils {

    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
