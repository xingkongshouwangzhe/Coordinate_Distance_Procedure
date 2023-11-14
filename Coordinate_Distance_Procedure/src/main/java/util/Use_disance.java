package util;

import entity.Address;
import entity.Distance_car;
import service.Getdistance;

public class Use_disance {


    public Distance_car use_disance_baidu(Address start_address, Address end_address, String key) throws Exception {


        Use_coordinate us = new Use_coordinate();

        String start_coordinate = us.use_coordinate_baidu(start_address, key).getLat() +
                "," + us.use_coordinate_baidu(start_address, key).getLng();

        String end_coordinate = us.use_coordinate_baidu(end_address, key).getLat() +
                "," + us.use_coordinate_baidu(end_address, key).getLng();


        Getdistance gd = new Getdistance();
        Distance_car baidu;
        baidu = gd.getdistance_bybaidu(start_coordinate, end_coordinate, key);

        baidu.setOrigin_address(start_address.getAddress());
        baidu.setDestination_address(end_address.getAddress());

        baidu.setOrigin(baidu.getOrigin_address() + "(" + baidu.getOrigin_coordinate() + ")");
        baidu.setDestination(baidu.getDestination_address() + "(" + baidu.getDestination_coordinate() + ")");

//        System.out.println(baidu.getOrigin_address()+","+baidu.getDestination_address());
//        System.out.println(baidu.getOrigin_coordinate()+","+baidu.getDestination_coordinate());
//        System.out.println(baidu.getOrigin()+"到"+baidu.getDestination()+":"+baidu.getDisance());

        return baidu;
    }

}
