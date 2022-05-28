package service;

import model.Cab;
import model.Location;
import model.Rider;
import model.Trip;
import strategies.PriceStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripManager {
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;

    public Map<String, List<Trip>> trips = new HashMap<>();
    CabManager cabManager;
    PriceStrategies priceStrategies;

    public TripManager(CabManager cabManager, PriceStrategies priceStrategies) {
        this.cabManager = cabManager;
        this.priceStrategies = priceStrategies;
    }

    public void createTrip(Rider rider,
                           Location fromPoint,
                           Location toPoint) {
        List<Cab> cabs = cabManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
        if (cabs.isEmpty())
            throw new RuntimeException("No cab available");

        Cab selectedCab = cabs.stream().filter(cab -> cab.getCurrentTrip() == null).findAny().get();
        Double price = priceStrategies.findPrice(fromPoint, toPoint);

        Trip newTrip = new Trip(rider, selectedCab, price, fromPoint, toPoint);
        if (!trips.containsKey(rider.getName())) {
            trips.put(rider.getName(), new ArrayList<>());
        }
        trips.get(rider.getName()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
        System.out.println("trip Created - " + newTrip);
    }

    public List<Trip> tripHistory(Rider rider) {
        if (!trips.containsKey(rider.getName())) {
            throw new RuntimeException("No History Found");
        }
       return trips.get(rider.getName());
    }

    public void endTrip(Cab cab){
        if(cab.getCurrentTrip() == null)
            throw new RuntimeException("Trip not found");
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
