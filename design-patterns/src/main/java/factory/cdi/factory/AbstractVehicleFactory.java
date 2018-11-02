package factory.cdi.factory;

import factory.cdi.vehicle.Vehicle;

/**
 * Created by steflind on 2018-10-25.
 */
public interface AbstractVehicleFactory {
    Vehicle createVehicle();
}
