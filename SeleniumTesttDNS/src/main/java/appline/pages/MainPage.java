package appline.pages;

import appline.utilsdata.AbstractBasket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Поиск по сайту']")
    WebElement searchInputField;

    @FindBy(xpath = "//span[@class='cart-link__price']")
    WebElement priceBasket;

    public ResultSearchPage enterInInputField(String value) {
        fillInputField(searchInputField, value);
        keyEnter(searchInputField);
        return new ResultSearchPage();
    }

    public ProductPage searchProduct(String value) {
        fillInputField(searchInputField, value);
        keyEnter(searchInputField);
        return new ProductPage();
    }

    public MainPage assertPrice(String priceValue) {
        elementTextToBePresent(priceBasket, "35 048");
        String priceBasketText = priceBasket.getText();
        int priceBasket = Integer.parseInt(priceBasketText.replaceAll(" ", ""));
        int priceAbstractBasket = AbstractBasket.getSumAbstractBasket();
        assertEquals("Общая сумма покупок и корзины не совпадает", priceBasket, priceAbstractBasket);
        System.out.println(priceAbstractBasket + " " + priceBasket);
        return this;
    }

    public BasketPage goToBasket() {
        elementToBeClickable(priceBasket).click();
        return new BasketPage();
    }
}
