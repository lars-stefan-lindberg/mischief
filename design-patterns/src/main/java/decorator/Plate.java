package decorator;

/**
 * Created by steflind on 2018-10-29.
 */
@ClearanceSale
public class Plate implements Product {

    private String label = "Plate";
    private double price = 50.00;

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
