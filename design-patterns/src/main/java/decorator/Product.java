package decorator;

/**
 * Created by steflind on 2018-10-29.
 */
public interface Product {

    public void setLabel(String label);
    public void setPrice(double price);
    public String getLabel();
    public double getPrice();
    public String generateLabel();
}
