package service;

import model.Cab;
import model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void createCab(Cab newCab) {
        if (cabs.containsKey(newCab.getNumber())) {
            throw new RuntimeException("Cab Already Exists");
        }
        cabs.put(newCab.getNumber(), newCab);
    }

    private Cab getCab(String cabNumber) {
        if (!cabs.containsKey(cabNumber)) {
            throw new RuntimeException("Cab not found");
        }
        return cabs.get(cabNumber);
    }

    public void updateCabLocation(String cabNumber, Location newLocation) {
        if (!cabs.containsKey(cabNumber)) {
            throw new RuntimeException("Cab not found");
        }
        cabs.get(cabNumber).setCurrentLocation(newLocation);
        System.out.println("Cab Location Updated");
    }


    public void updateCabAvailability(String cabNumber, boolean newAvailability) {
        if (!cabs.containsKey(cabNumber)) {
            throw new RuntimeException("Cab not found");
        }
        cabs.get(cabNumber).setAvailable(newAvailability);
        System.out.println("Cab Availability Updated");
    }

    public List<Cab> getCabs(Location fromPoint, Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            if (cab.isAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }

}
