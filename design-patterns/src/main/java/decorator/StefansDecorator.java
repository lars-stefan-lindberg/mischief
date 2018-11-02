package decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * Created by steflind on 2018-10-29.
 */
@Decorator
public class StefansDecorator implements Product {

    @ChristmasSale
    @Inject
    @Delegate
    private Product product;

    public void setLabel(String label) {

    }

    public void setPrice(double price) {

    }

    public String getLabel() {
        return null;
    }

    public double getPrice() {
        return 0;
    }

    public String generateLabel() {
        product.setPrice(product.getPrice() * 1.5);
        product.setLabel(product.getLabel() + " (Stefan was here)");
        return product.generateLabel();
    }
}
