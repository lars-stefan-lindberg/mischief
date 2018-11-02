package factory.cdipower.factory;

import factory.cdipower.qualifiers.SpaceshipLiteral;
import factory.cdipower.qualifiers.SpaceshipType;
import factory.cdipower.qualifiers.Spaceship;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-28.
 */
@Dependent
public class SpaceshipFactory {

    @Inject
    @Any
    private Instance<SpaceshipType> spaceships;

    public SpaceshipType getSpaceship(Spaceship.Type type) {
        SpaceshipLiteral literal = new SpaceshipLiteral(type);
        Instance<SpaceshipType> typeSpaceships = spaceships.select(literal);
        return typeSpaceships.get();
    }
}
