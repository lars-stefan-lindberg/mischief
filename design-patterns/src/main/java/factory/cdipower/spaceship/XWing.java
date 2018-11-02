package factory.cdipower.spaceship;

import factory.cdipower.qualifiers.SpaceshipType;
import factory.cdipower.qualifiers.Spaceship;

import javax.enterprise.context.Dependent;

/**
 * Created by steflind on 2018-10-28.
 */
@Spaceship(Spaceship.Type.XWING)
@Dependent
public class XWing implements SpaceshipType {
    public String getName() {
        return "X-wing!";
    }
}
