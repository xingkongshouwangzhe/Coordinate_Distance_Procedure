package util;

import entity.Address;
import entity.Coordinate;
import service.Getcoordinate;

import java.io.IOException;

public class Use_coordinate {


    public Coordinate use_coordinate_baidu(Address address, String key) throws IOException {

        Getcoordinate gc = new Getcoordinate();
        Coordinate coordinate = gc.getcoordinate_bybaidu(address, key);

//        System.out.println(address+key);
//        String lat_lng = coordinate.getLat()+","+coordinate.getLng();

        return coordinate;
    }

}
