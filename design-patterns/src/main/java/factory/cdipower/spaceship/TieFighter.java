package factory.cdipower.spaceship;

import factory.cdipower.qualifiers.SpaceshipType;
import factory.cdipower.qualifiers.Spaceship;

import javax.enterprise.context.Dependent;

/**
 * Created by steflind on 2018-10-28.
 */
@Spaceship(Spaceship.Type.TIEFIGHTER)
@Dependent
public class TieFighter implements SpaceshipType {
    public String getName() {
        return "Tie fighter!";
    }
}
