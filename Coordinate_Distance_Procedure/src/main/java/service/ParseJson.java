package service;

import entity.Address;
import entity.Coordinate;
import entity.Distance_car;
import mianban.frame;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class ParseJson {
    //服务状态码地址
    String status_url = "https://lbsyun.baidu.com/faq/api?" +
            "title=webapi/guide/webservice-geocoding-base#%" +
            "E6%9C%8D%E5%8A%A1%E7%8A%B6%E6%80%81%E7%A0%81";


    /*
     * @description 解析百度API返回结果JSON
     * @param String API调用返回结果
     * @return Coordinate 经纬度
     */
    public Coordinate ParseFromBaidu_coordinate(Address address, String response) {

        if (response != null && !response.isEmpty()) {
            Coordinate coordinate = new Coordinate();
            JSONObject json = JSONObject.fromObject(response);

            if (json.getInt("status") == 0) {
                double lng = json.getJSONObject("result").getJSONObject("location").getDouble("lng");
                double lat = json.getJSONObject("result").getJSONObject("location").getDouble("lat");
                coordinate.setAddress(address);
                coordinate.setLat(lat);
                coordinate.setLng(lng);
                coordinate.setPlatform("baidu");
                coordinate.setCoordinateSystem("BD-09");

                return coordinate;
            } else {

                String error = "状态码：" + json.getInt("status")
                        + "\n" + status_url;
                frame.error_frame(error);
            }
        }

        return null;
    }

    /*
     * @description 解析百度API返回结果JSON
     * @param String API调用返回结果
     * @return Coordinate 距离
     */
    public Distance_car ParseFromBaidu_distance(String response) {

        Distance_car distanceCar = new Distance_car();
        JSONObject json = JSONObject.fromObject(response);
//        System.out.println(json);
        int status = json.getInt("status");
        if (status != 0) {


            String error = "状态码：" + json.getInt("status")
                    + "\n" + status_url;
            frame.error_frame(error);
        }

        JSONObject result = json.getJSONObject("result");
        //System.out.println(result);
        JSONArray routes = result.getJSONArray("routes");
//        System.out.println(routes);
        JSONObject routes1 = routes.getJSONObject(0);
//        System.out.println(routes1);

        distanceCar.setOrigin_coordinate(result.getJSONObject("origin").getDouble("lat") + ","
                + result.getJSONObject("origin").getDouble("lng"));

        distanceCar.setDestination_coordinate(result.getJSONObject("destination").getDouble("lat") + ","
                + result.getJSONObject("destination").getDouble("lng"));

        distanceCar.setDistance(routes1.getDouble("distance"));

        distanceCar.setPlatform("百度");

//        System.out.println(distance);
        return distanceCar;
    }

}
