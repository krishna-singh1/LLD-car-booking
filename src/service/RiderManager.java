package service;

import model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(Rider rider) {
        if (riders.containsKey(rider.getName())) {
            throw new RuntimeException("Rider Already not Exist");
        }
        riders.put(rider.getName(), rider);
        System.out.println("Rider Created - " + rider.getName());
    }

    public Rider getRider(String riderName) {
        if (!riders.containsKey(riderName)) {
            throw new RuntimeException("Rider not Exist");
        }
        return riders.get(riderName);
    }
}
