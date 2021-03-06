package decorator;

import javax.inject.Named;

/**
 * Created by steflind on 2018-10-29.
 */
@ChristmasSale
public class Table implements Product {

    private String label = "Dining Table";
    private double price = 100.00;

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    public String generateLabel() {
        return price + ", " + label;
    }
}
