package factory.cdi.service;

import factory.cdi.qualifiers.TieFighterType;
import factory.cdi.qualifiers.VehicleType;
import factory.cdi.qualifiers.XWingType;
import factory.cdi.vehicle.Vehicle;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-28.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class VehicleService {

    @Inject @VehicleType(VehicleType.Type.TIEFIGHTER)
    private Vehicle tieFighter;

    @Inject @VehicleType(VehicleType.Type.XWING)
    private Vehicle xWing;

    public void startService() {
        System.out.println("Tie fighter attack power: " + tieFighter.getAttackPower());
        System.out.println("Xwing attack power: " + xWing.getAttackPower());
    }
}
