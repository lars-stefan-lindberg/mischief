package factory.cdipower.qualifiers;

import factory.cdipower.qualifiers.Spaceship;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by steflind on 2018-10-28.
 */
public class SpaceshipLiteral extends AnnotationLiteral<Spaceship> implements Spaceship {

    private static final long serialVersionID = 1L;
    private Type type;

    public SpaceshipLiteral(Type type) {
        this.type = type;
    }

    public Type value() {
        return type;
    }
}
