package model;

public class Cab {
    String number;
    String driverName;
    boolean isAvailable;
    Location currentLocation;
    Trip currentTrip;

    public Cab(String number,String driverName) {
        this.number= number;
        this.driverName = driverName;
        this.isAvailable = true;
    }

    public String getNumber() {
        return number;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "number='" + number + '\'' +
                ", driverName='" + driverName + '\'' +
                ", isAvailable=" + isAvailable +
                ", currentLocation=" + currentLocation + '}';
    }
}
