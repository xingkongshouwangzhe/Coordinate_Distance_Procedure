package util;

import entity.Coordinate;
import entity.Distance_car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {


    /*
     * @description 读取txt文件中的地址到coordinateList
     * @param String 文件路径
     * @return List
     */

    public List<String> txtToList(String path) {

        List<String> addressList = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            String addr = null;
            while ((addr = br.readLine()) != null) {
                addressList.add(addr);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressList;
    }


    /*
     * @description 将地址坐标信息写入TXT文件中
     * @param String 文件路径
     * @param List<Coordinate> 坐标信息List
     * @return
     */
    public void coordinateToTxt(String path, List<Coordinate> coordinateList) {

        try {
            File tXtFile = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(tXtFile, false));
            bw.write("地址，纬度，经度，平台，坐标系");

            bw.newLine();
            for (Coordinate coordinate : coordinateList) {
                bw.write(coordinate.getAddress().getAddress() + "," + coordinate.getLat() + ","
                        + coordinate.getLng() + "," + coordinate.getPlatform() + ","
                        + coordinate.getCoordinateSystem());

                bw.newLine();
            }
            System.out.println("文件写入完毕！");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * @description 将驾车行驶距离信息写入CSV文件中
     * @param String 文件路径
     * @param List<Coordinate> 坐标信息List
     * @return
     */
    public void disanceToTxt(String path, List<Distance_car> distanceCarsList) {

        try {
            File tXtFile = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(tXtFile, false));
            bw.write("起始地，目的地，距离（单位：米），平台，起始地址，起始坐标，目的地址，目的坐标");

            bw.newLine();
            for (Distance_car distanceCar : distanceCarsList) {
                bw.write(distanceCar.getOrigin() + "," + distanceCar.getDestination() + ","
                        + distanceCar.getDistance() + "," + distanceCar.getPlatform() + ","
                        + distanceCar.getOrigin_address() + "," + distanceCar.getOrigin_coordinate() + ","
                        + distanceCar.getDestination_address() + "," + distanceCar.getDestination_coordinate());

                bw.newLine();
            }
            System.out.println("文件写入完毕！");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
