import javafx.scene.transform.Scale;
import model.Cab;
import model.Location;
import model.Rider;
import model.Trip;
import service.CabManager;
import service.TripManager;
import strategies.DefaultPriceStrategies;
import strategies.PriceStrategies;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CabManager cabManager =new CabManager();
        PriceStrategies priceStrategies = new DefaultPriceStrategies();
        TripManager tripManager = new TripManager(cabManager, priceStrategies);

        System.out.println("Welcome to lld cab booking");
        Rider rider1 = new Rider("rider1");
        Rider rider2 = new Rider("rider2");
        Rider rider3 = new Rider("rider3");


        Cab cab1 = new Cab("car1" , "driver1");
        Cab cab2 = new Cab("car2" , "driver2");
        Cab cab3 = new Cab("car3" , "driver3");

        cabManager.createCab(cab1);
        cabManager.createCab(cab2);
        cabManager.createCab(cab3);

        cabManager.updateCabLocation(cab1.getNumber(), new Location(1.0, 2.0));
        cabManager.updateCabLocation(cab2.getNumber(), new Location(3.0, 3.0));
        cabManager.updateCabLocation(cab3.getNumber(), new Location(10.0, 12.0));

        tripManager.createTrip(rider1,new Location(5.0,2.3), new Location(10.0,12.3));
        tripManager.tripHistory(rider1);

        tripManager.createTrip(rider1,new Location(1.0,2.3), new Location(12.0,12.3));
        List<Trip> rider1trip= tripManager.tripHistory(rider1);
        System.out.println(rider1trip);
        tripManager.endTrip(cab1);
    }

}
