package mianban;

import entity.Address;
import entity.Coordinate;
import entity.Distance_car;
import util.FileUtil;
import util.Use_coordinate;
import util.Use_disance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mianban {
    JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField one_coordinate_textField_addr;
    private JTextField one_distance_textField_start;
    private JTextField one_distance_textField_end;
    private JButton one_coordinate_JButton;
    private JButton one_distance_JButton;
    private JTextField many_coordinate_textField_file;
    private JButton serch_Button1;
    private JButton many_coordinate_JButton;
    private JTextField many_distance_textField_file;
    private JButton serch_Button2;
    private JButton many_distance_JButton;
    private JLabel one_coordinate_JL_out;
    private JLabel one_distance_JL_out;
    private JPanel one_jpanel;
    private JPanel many_jpanel;
    private JLabel one_coordinate_jL1;
    private JLabel one_coordinate_JL2;
    private JLabel one_coordinate_JL3;
    private JLabel many_coordinate_JL1;
    private JLabel one_distance_JL1;
    private JLabel one_distance_JL_start;
    private JLabel one_distance_JL_end;
    private JLabel one_distance_JL_dis;
    private JLabel many_distance_JL1;
    private JTextField textField_key;
    private JTextArea textArea_out;
    private JLabel JLable_key;

//    public JTextField getOne_coordinate_textField_addr() {
//        return one_coordinate_textField_addr;
//    }
//
//    public JTextField getOne_distance_textField_start() {
//        return one_distance_textField_start;
//    }
//
//    public JTextField getOne_distance_textField_end() {
//        return one_distance_textField_end;
//    }
//
//    public JTextField getMany_coordinate_textField_file() {
//        return many_coordinate_textField_file;
//    }
//
//    public JTextField getMany_distance_textField_file() {
//        return many_distance_textField_file;
//    }


    public mianban() {
        one_coordinate_JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*获取textFieLd1的内容，判断是否为空
                为空，返回 输出“您未填入地址！！”，不为空则调用函数查询，
                并返回为经纬度并输出结果
                 */
                Address addr = new Address();
                addr.setAddress(one_coordinate_textField_addr.getText());
//                System.out.println(addr.getAddress());

                Use_coordinate useCoordinate = new Use_coordinate();
                try {
                    Coordinate coordinate = useCoordinate.use_coordinate_baidu(addr, textField_key.getText());
//                    System.out.println(coordinate.getLat()+","+coordinate.getLng());

                    one_coordinate_JL_out.setText(coordinate.getLat() + "," + coordinate.getLng());
//                    System.out.println(one_coordinate_JL_out.getText());

                    String result = coordinate.getAddress().getAddress() + "的坐标（纬度，经度）：" + one_coordinate_JL_out.getText();
//                    textArea_out.append(result+"\n");
                    textArea_out.setText(result);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        one_distance_JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*获取textField2和textField3的内容，判断是否为空
                为空，返回 输出“请您未填入起始地址或目的地址！！”
                不为空，则调用函数查询，返回距离并输出
                 */
                Address addr_start = new Address();
                Address addr_end = new Address();
                addr_start.setAddress(one_distance_textField_start.getText());
                addr_end.setAddress(one_distance_textField_end.getText());

                Use_disance ud = new Use_disance();
                try {
                    Distance_car distanceCar = ud.use_disance_baidu(addr_start, addr_end, textField_key.getText());

                    one_distance_JL_out.setText(distanceCar.getDistance() + "米");

                    String result = distanceCar.getOrigin() + " 到 " + distanceCar.getDestination() + " 的距离是："
                            + distanceCar.getDistance() + " 米。";
                    textArea_out.setText(result);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        serch_Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*打开文件选择器，只能选择文件，
                并将选择器的返回到textField4中
                 */
                //创建文件选择器fileChooser
                JFileChooser fileChooser = new JFileChooser("C:/");

                //设置选择的文件数量，默认为单选
                //fileChooser.setMultiSelectionEnabled(true);

                //选择器的选择模式，FILES_ONLY “只能打开文件”；DIRECTORIES_ONLY “只能打开文件夹”；
                // FILES_AND_DIRECTORIES “文件和文件夹都能打开”
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                //打开文件选择器窗口，获取返回值，用户点击“打开”或“保存”按钮，方法的返回值为0；
                //用户如果点击的是“取消”按钮，则方法的返回值为1;
                // JFileChooser类的静态属性APPROVE_OPTION表示这个返回值
                int val = fileChooser.showOpenDialog(null);
                if (val == JFileChooser.APPROVE_OPTION) {

                    //获取选择的文件的路径
                    many_coordinate_textField_file.setText(fileChooser.getSelectedFile().toString());
                } else {
                    many_coordinate_textField_file.setText("未选择文件");
                }


            }
        });
        serch_Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*打开文件选择器，只能选择文件，
                并将选择器的返回到textField4中
                 */
                //创建文件选择器fileChooser
                JFileChooser fileChooser = new JFileChooser("C:/");

                //设置选择的文件数量，默认为单选
                //fileChooser.setMultiSelectionEnabled(true);

                //选择器的选择模式，FILES_ONLY “只能打开文件”；DIRECTORIES_ONLY “只能打开文件夹”；
                // FILES_AND_DIRECTORIES “文件和文件夹都能打开”
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                //打开文件选择器窗口，获取返回值，用户点击“打开”或“保存”按钮，方法的返回值为0；
                //用户如果点击的是“取消”按钮，则方法的返回值为1;
                // JFileChooser类的静态属性APPROVE_OPTION表示这个返回值
                int val = fileChooser.showOpenDialog(null);
                if (val == JFileChooser.APPROVE_OPTION) {

                    //获取选择的文件的路径
                    many_distance_textField_file.setText(fileChooser.getSelectedFile().toString());
                } else {
                    many_distance_textField_file.setText("未选择文件");
                }

            }
        });
        many_coordinate_JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //批量处理经纬度

                FileUtil fileUtil = new FileUtil();
                Use_coordinate us = new Use_coordinate();

                List<String> addressList = fileUtil.txtToList(many_coordinate_textField_file.getText());
                List<Coordinate> coordinateList = new ArrayList<>();
                Coordinate coordinate_error = new Coordinate();


                for (String addr : addressList) {
                    Address address = new Address();
                    address.setAddress(addr);

                    coordinate_error.setAddress(address);

                    try {
                        Coordinate coordinate = us.use_coordinate_baidu(address, textField_key.getText());
                        if (coordinate != null) {
                            coordinateList.add(coordinate);
                            textArea_out.setText(coordinate.getAddress().getAddress() + "  成功！");
                        } else {
                            coordinateList.add(coordinate_error);
                            textArea_out.setText(coordinate_error.getAddress().getAddress() + "  失败！");
                        }

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                fileUtil.coordinateToTxt(many_coordinate_textField_file.getText() + "(result).txt", coordinateList);
                frame.success_frame("批量查询经纬度，文件写入完毕！");

            }
        });
        many_distance_JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //批量计算距离

                FileUtil fileUtil = new FileUtil();
                Use_disance ud = new Use_disance();


                List<String> addrList = fileUtil.txtToList(many_distance_textField_file.getText());
                List<Distance_car> distanceCarList = new ArrayList<>();
                Distance_car distanceCar_error = new Distance_car();

                for (String addr : addrList) {
                    Address addr_start = new Address();
                    Address addr_end = new Address();

                    String[] address = addr.split("，");
                    addr_start.setAddress(address[0]);
                    addr_end.setAddress(address[1]);

                    distanceCar_error.setOrigin_address(addr_start.getAddress());
                    distanceCar_error.setDestination_address(addr_end.getAddress());

                    try {
                        Distance_car distanceCar = ud.use_disance_baidu(addr_start, addr_end, textField_key.getText());

                        if (distanceCar != null) {
                            distanceCarList.add(distanceCar);
                            textArea_out.setText(distanceCar.getOrigin_address() + " 到 " + distanceCar.getDestination_address()
                                    + ":" + distanceCar.getDistance() + "米  成功！");
                        } else {
                            distanceCarList.add(distanceCar_error);
                            textArea_out.setText(distanceCar_error.getOrigin_address() + " 到 " + distanceCar_error.getDestination_address()
                                    + ":" + distanceCar_error.getDistance() + "米  失败！");
                        }

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                fileUtil.disanceToTxt(many_distance_textField_file.getText() + "(result).txt", distanceCarList);
                frame.success_frame("批量查询距离，文件写入完毕！");

            }
        });

    }

}
