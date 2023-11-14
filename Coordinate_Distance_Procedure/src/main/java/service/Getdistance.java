package service;

import entity.Distance_car;
import util.HttpClirntUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class Getdistance {

    private HttpClirntUtil httpClirntUtil;  //Http实用程序
    private ParseJson parseJson;

    public Getdistance() {
        httpClirntUtil = new HttpClirntUtil();
        parseJson = new ParseJson();
    }

    public Distance_car getdistance_bybaidu(String origin, String destination, String AK) throws Exception {
        //百度地图API参数
        String url = "https://api.map.baidu.com/directionlite/v1/driving?";
        Map params = new LinkedHashMap<String, String>();
        params.put("origin", origin);
        params.put("destination", destination);
        params.put("ak", AK);   //个人的AK密钥


        //调用百度地图API
        String result = httpClirntUtil.doGet(url, params);    //发出http请求
        Distance_car distance = parseJson.ParseFromBaidu_distance(result);  //解析返回的JSon获取坐标
        return distance;
    }

}
