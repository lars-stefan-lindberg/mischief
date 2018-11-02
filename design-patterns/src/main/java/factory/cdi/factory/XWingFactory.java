package factory.cdi.factory;

import factory.cdi.qualifiers.VehicleType;
import factory.cdi.vehicle.Vehicle;
import factory.cdi.vehicle.XWing;
import factory.cdi.qualifiers.XWingType;

import javax.enterprise.inject.Produces;

/**
 * Created by steflind on 2018-10-25.
 */
public class XWingFactory implements AbstractVehicleFactory {

    @Produces @VehicleType(VehicleType.Type.XWING)
    public Vehicle createVehicle() {
        return new XWing();
    }
}
