package service;

import entity.Address;
import entity.Coordinate;
import util.HttpClirntUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


//获取地址坐标的经纬度的方法类
public class Getcoordinate {

    private HttpClirntUtil httpClirntUtil;  //Http实用程序
    private ParseJson parseJson;           //解析Json的服务

    //初始化（定义数据初始化）
    public Getcoordinate() {
        httpClirntUtil = new HttpClirntUtil();
        parseJson = new ParseJson();
    }

    /*@description调用百度地图API获取指定地址的经纬度
     *@param
     * @return Coordinate 经纬度
     */
    public Coordinate getcoordinate_bybaidu(Address address, String AK) throws IOException {
        //百度地图API参数
        String address1 = address.getAddress();
//        System.out.println(address1+AK);

        String url = "https://api.map.baidu.com/geocoding/v3?";
        Map params = new LinkedHashMap<String, String>();
        params.put("address", address1);
        params.put("output", "json");
        params.put("ak", AK);   //个人的AK密钥


        //调用百度地图API
        String result = httpClirntUtil.doGet(url, params);    //发出http请求
        Coordinate coordinate = parseJson.ParseFromBaidu_coordinate(address, result);  //解析返回的JSon获取坐标
        return coordinate;

    }


}
