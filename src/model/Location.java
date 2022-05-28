package model;

public class Location {
    private Double x;
    private Double y;

    public Location(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double distance(Location location){
        return Math.sqrt(
                Math.pow(this.x - location.x, 2) +
                Math.pow(this.y - location.y , 2));
    }
}
