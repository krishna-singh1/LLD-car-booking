package strategies;

import model.Location;

public class DefaultPriceStrategies implements PriceStrategies{

    private static  final  Double PER_KM_PRICE = 12.0;
    @Override
    public Double findPrice(Location fromPoint, Location toPoint) {
        return  fromPoint.distance(toPoint) * PER_KM_PRICE;
    }
}
