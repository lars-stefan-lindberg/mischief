package factory.cdipower.service;

import factory.cdipower.qualifiers.SpaceshipType;
import factory.cdipower.factory.SpaceshipFactory;
import factory.cdipower.qualifiers.Spaceship;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-28.
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ApplicationScoped
public class SpaceshipService {

    @Inject
    SpaceshipFactory spaceshipFactory;

    public void startService() {
        SpaceshipType st = spaceshipFactory.getSpaceship(Spaceship.Type.TIEFIGHTER);
        System.out.println(st.getName());

        st = spaceshipFactory.getSpaceship(Spaceship.Type.XWING);
        System.out.println(st.getName());
    }
}
