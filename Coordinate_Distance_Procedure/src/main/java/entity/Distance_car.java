package entity;

public class Distance_car {

    private String origin_address;
    private String origin_coordinate;
    private String origin;

//    origin = origin_address +
//            "(" + origin_coordinate + ")";

    private String destination_address;
    private String Destination_coordinate;
    private String destination;

//    destination = destination_address +
//            "(" + getDestination_coordinate + ")";

    private double distance;
    private String platform;


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin_address() {
        return origin_address;
    }

    public void setOrigin_address(String origin_address) {
        this.origin_address = origin_address;
    }

    public String getOrigin_coordinate() {
        return origin_coordinate;
    }

    public void setOrigin_coordinate(String origin_coordinate) {
        this.origin_coordinate = origin_coordinate;
    }

    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public String getDestination_coordinate() {
        return Destination_coordinate;
    }

    public void setDestination_coordinate(String destination_coordinate) {
        Destination_coordinate = destination_coordinate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}


