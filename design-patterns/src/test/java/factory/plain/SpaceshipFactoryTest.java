package factory.plain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by steflind on 2018-10-25.
 */
public class SpaceshipFactoryTest {

    @Test
    public void abstractFactoryTest() {

        assertAbstractVehicleFactory("useXWings", 2000);
        assertAbstractVehicleFactory("useTieFighters", 1000);
    }

    private void assertAbstractVehicleFactory(String userInput, int attackPower) {
        AbstractVehicleFactory vehicleFactory = null;
        if(userInput.equalsIgnoreCase("useXWings")) {
            vehicleFactory = new XWingFactory();
        } else if(userInput.equalsIgnoreCase("useTieFighters")) {
            vehicleFactory = new TieFigherFactory();
        }
        Vehicle vehicle1 = vehicleFactory.createVehicle();

        assertThat(vehicle1.getAttackPower())
                .isEqualTo(attackPower);
        Vehicle vehicle2 = vehicleFactory.createVehicle();
        assertThat(vehicle1)
                .isNotEqualTo(vehicle2);
    }
}
