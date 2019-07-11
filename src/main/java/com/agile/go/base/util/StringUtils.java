package com.agile.go.base.util;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/29 11:55
 * @Version 1.0
 **/
public class StringUtils {
    /**
     * 1.判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return (obj == null || "".equals(obj));
    }

    /**
     * StringUtil.hasLength(null) = false
     * StringUtil.hasLength("") = false
     * StringUtil.hasLength(" ") = true
     * StringUtil.hasLength("Hello") = true
     *
     * @param str
     * @return
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean hasLength(String str) {
        return (str != null && !str.isEmpty());
    }

    /**
     * StringUtil.hasText(null) = false
     * StringUtil.hasText("") = false
     * StringUtil.hasText(" ") = false
     * StringUtil.hasText("12345") = true
     * StringUtil.hasText(" 12345 ") = true
     *
     * @param str
     * @return
     */
    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasText(String str) {
        return (str != null && !str.isEmpty() && hasText((CharSequence) str));
    }

    public static boolean containsWhitespace(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否包含空格
     *
     * @param str
     * @return
     */
    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    /**
     * 去掉首尾的空格
     *
     * @param str
     * @return
     */
    public static String trimWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 去掉所有的空格
     *
     * @param str
     * @return
     */
    public static String trimAllWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        int len = str.length();
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 去掉头边空格
     *
     * @param str
     * @return
     */
    public static String trimLeadingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * 去掉尾部空格
     *
     * @param str
     * @return
     */
    public static String trimTrailingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 转换byte类型为String类型
     *
     * @param byteStr
     * @return
     */
    public static String byteStrToString(String byteStr) throws UnsupportedEncodingException {
        if (!isEmpty(byteStr)) {
            String[] t = byteStr.split(",");
            byte[] b = new byte[t.length];

            for (int i = 0; i < t.length; i++) {
                b[i] = Byte.valueOf(t[i]);
            }

            return new String(b, "UTF-8");
        }
        return "";
    }

    /**
     * 判断字符串是否为空
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static String firstLowerCase(String str) {
        if (Character.isLowerCase(str.charAt(0)))
            return str;
        else
            return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static String firstUpCase(String str) {
        if (Character.isUpperCase(str.charAt(0)))
            return str;
        else
            return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
    }

}
