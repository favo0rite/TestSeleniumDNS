package tests;

import basetestsclass.BaseTestClass;
import org.junit.Test;

public class TestDNS extends BaseTestClass {

    @Test
    public void test() {
        app.getMainPage()
                .enterInInputField("playstation")
                .clickByPs4()
                .clickByProductWarranty()
                .clickByPeriodWarrantyTwoYears()
                .checkTextHasChanged("32 449")
                .addToAbstractBasket()
                .clickButtonBuyProduct()
                .searchProduct("Detroit")
                .addToAbstractBasket()
                .clickButtonBuyProduct()
                .assertPrice("35 048")
                .goToBasket()
                .assertCheckSelectedWarranty()
                .assertPricesProducts()
                .deleteDetroitWithBasket()
                .assertDeleteDetroit()
                .assertChangePriceBasket("32 449")
                .clickButtonPlusPs4()
                .clickButtonPlusPs4()
                .assertChangePriceBasket("97 347")
                .clickByRestoreLastRemoved()
                .assertChangePriceBasket("99 946");
    }
}
