package com.web.javaweb.student.util;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/12 - 09 - 12 - 9:32
 * @Description: com.web.javaweb.student.util
 * @version: 1.0
 */
public class ExcludeResourceUtil {
    //不需要过滤的url
    static String[] urls = {".js",".css",".ico",".jpg",".png"};

    public static boolean shouldExclude(String uri){
        boolean flag = false;
        for(String str :urls){
            if (uri.contains(str)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
