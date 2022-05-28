package strategies;

import model.Location;

public interface PriceStrategies {
    Double findPrice(Location fromPoint, Location toPoint);
}
