package model;
enum  TripStatus{
    IN_PROGRESS, FINISHED;
}

public class Trip {

    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(Rider rider, Cab cab, Double price, Location fromPoint, Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.tripStatus = TripStatus.IN_PROGRESS;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void endTrip(){
        this.tripStatus = TripStatus.FINISHED;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "rider=" + rider +
                ", cab=" + cab +
                ", tripStatus=" + tripStatus +
                ", price=" + price +
                ", fromPoint=" + fromPoint +
                ", toPoint=" + toPoint +
                '}';
    }
}
