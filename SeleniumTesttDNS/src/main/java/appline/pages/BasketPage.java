package appline.pages;

import appline.utilsdata.AbstractBasket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[@data-commerce-target='basket_additional_warranty_24']/span[@class='base-ui-radio-button__icon base-ui-radio-button__icon_checked']")
    WebElement buttonCheckWarranty24;

    @FindBy(xpath = "//span[text()='27 499 ']")
    WebElement priceInBasketPs4;

    @FindBy(xpath = "//span[@class='price__current' and text()='2 599 ']")
    WebElement priceInBasketDetroit;

    @FindBy(xpath = "//div[@class='total-amount-block total-amount__info-block']//span[@class='price__current']")
    WebElement sumPriceBasket;

    @FindBy(xpath = "//a[text()='Игра Detroit: Стать человеком (PS4)']//parent::div[@class='cart-items__product-name']//following-sibling::div/div/button[text()='Удалить']")
    WebElement buttonDeleteDetroit;

    @FindBy(xpath = "//button[@class='count-buttons__button count-buttons__button_plus']")
    WebElement buttonPlus;

    @FindBy(xpath = "//span[@class='restore-last-removed']")
    WebElement restoreProduct;

    public BasketPage assertCheckSelectedWarranty() {
        elementToBeClickable(buttonCheckWarranty24);
        return this;
    }

    public BasketPage assertPricesProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='27 499 ']")));
        int priceInBasketPs4Int = Integer.parseInt(priceInBasketPs4.getText().replaceAll(" ", "")) +4950;
        int priceInBasketDetroitInt = Integer.parseInt(priceInBasketDetroit.getText().replaceAll(" ", ""));
        int sumPriceBasketInt = Integer.parseInt(sumPriceBasket.getText().replaceAll(" ", ""));
        assertEquals("Цена ps4 с гарантией в корзине не совпала", AbstractBasket.getProductToProductList(0).getPrice(), priceInBasketPs4Int);
        assertEquals("Цена Detroit в корзине не совпала", AbstractBasket.getProductToProductList(1).getPrice(), priceInBasketDetroitInt);
        assertEquals("Суммарная цена корзины не совпала", AbstractBasket.getSumAbstractBasket(), sumPriceBasketInt);

        return this;

    }

    public BasketPage deleteDetroitWithBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Игра Detroit: Стать человеком (PS4)']//parent::div[@class='cart-items__product-name']//following-sibling::div/div/button[text()='Удалить']")));
        elementToBeClickable(buttonDeleteDetroit).click();
        return this;
    }

    public BasketPage assertDeleteDetroit() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='Игра Detroit: Стать человеком (PS4)']" +
                "//parent::div[@class='cart-items__product-name']" +
                "//following-sibling::div/div/button[text()='Удалить']")));
        return this;

    }

    public BasketPage assertChangePriceBasket(String value) {
        elementTextToBePresent(sumPriceBasket, value);
        assertEquals("Сумма в корзине не совпала", sumPriceBasket.getText().replaceAll(" ", ""), value.replaceAll(" ", ""));
        return this;
    }

    public BasketPage clickButtonPlusPs4() {
        elementToBeClickable(buttonPlus);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@disabled='disabled']/i[@class='count-buttons__icon-plus']")));
        clickElementJs(buttonPlus);
        return this;
    }

    public BasketPage clickByRestoreLastRemoved() {
        elementToBeClickable(restoreProduct);
        clickElementJs(restoreProduct);
        return this;
    }





}
