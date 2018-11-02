package factory.cdi.factory;

import factory.cdi.qualifiers.VehicleType;
import factory.cdi.vehicle.TieFighter;
import factory.cdi.vehicle.Vehicle;
import factory.cdi.qualifiers.TieFighterType;

import javax.enterprise.inject.Produces;

/**
 * Created by steflind on 2018-10-25.
 */
public class TieFigherFactory implements AbstractVehicleFactory {

    @Produces @VehicleType(VehicleType.Type.TIEFIGHTER)
    public Vehicle createVehicle() {
        return new TieFighter();
    }
}
