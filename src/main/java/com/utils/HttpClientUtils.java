package com.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpClient工具类
 */

public class HttpClientUtils {

    /**
     * 定义了一个名为 doGet 的静态方法
     * 其参数为一个字符串类型的 uri，表示请求的地址
     * 使用了 URL 类来创建一个 URL 对象，并将 uri 传入构造方法中
     * 通过 url.openConnection() 方法获取一个 HttpURLConnection 对象
     * 并强制类型转换为 HttpURLConnection 类型
     */
    public static String doGet(String uri) {

        StringBuilder result = new StringBuilder();
        try {
            String res = "";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line+"\n";
            }
            in.close();
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

