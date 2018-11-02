package decorator;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by steflind on 2018-10-29.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PricelistService {

    @ClearanceSale
    @Inject
    Product clearanceSaleProduct;

    @ChristmasSale
    @Inject
    Product christmasSaleProduct;

    public void createClearancePriceList() {
        System.out.println("Label: " + clearanceSaleProduct.generateLabel());
    }

    public void createChristmasPriceList() {
        System.out.println("Label: " + christmasSaleProduct.generateLabel());
    }
}
