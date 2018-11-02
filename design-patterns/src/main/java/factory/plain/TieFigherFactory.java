package factory.plain;

/**
 * Created by steflind on 2018-10-25.
 */
public class TieFigherFactory implements AbstractVehicleFactory {

    public Vehicle createVehicle() {
        return new TieFighter();
    }
}
