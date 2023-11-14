package util;

import entity.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

public class HttpClirntUtil {
    public String doGet(String strUrl, Map<String, String> params) throws IOException {
        if (strUrl == null || strUrl.length() <= 0 || params == null || params.size() <= 0) {
            return strUrl;
        }

        //System.out.println(strUrl);

        StringBuffer queryString = new StringBuffer();
        queryString.append(strUrl);
        //System.out.println(queryString);
        for (Map.Entry<?, ?> pair : params.entrySet()) {
            queryString.append(pair.getKey() + "=");
            //System.out.println(queryString);
            //    第一种方式使用的 jdk 自带的转码方式  第二种方式使用的 spring 的转码方法 两种均可
            queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8").replace("+", "%20") + "&");
            //queryString.append(UriUtils.encode((String) pair.getValue(), "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }

        //发送http请求并接收http响应，得到返回的json值
        java.net.URL url = new URL(queryString.toString());
        //System.out.println(queryString.toString());
        URLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();

        InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        StringBuffer result = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
        isr.close();
        //System.out.println("http"+result.toString());
        return result.toString();
    }


}
