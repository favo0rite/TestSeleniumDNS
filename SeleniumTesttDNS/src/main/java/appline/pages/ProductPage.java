package appline.pages;

import appline.utilsdata.AbstractBasket;
import appline.utilsdata.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//div[@class='price-item-description']//p")
    WebElement productDescription;

    @FindBy(xpath = "//h1[@data-product-param='name']")
    WebElement productName;

    @FindBy(xpath = "//span[@class='current-price-value']")
    WebElement productPriceValue;

    @FindBy(xpath = "//select[@class='form-control select']")
    WebElement productWarranty;

    public WebElement getProductDescription() {
        return productDescription;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPriceValue() {
        return productPriceValue;
    }

    @FindBy(xpath = "//option[@data-additional-years='2']")
    WebElement periodWarrantyTwoYears;

    @FindBy(xpath = "//button[text()='Купить']")
    WebElement buttonBuyProduct;


    public ProductPage addToAbstractBasket() {
        String name = getProductName().getText();
        int price = Integer.parseInt(getProductPriceValue().getText().replaceAll(" ", ""));
        String description = getProductDescription().getText();
        Product product = new Product(name, price, description);
        AbstractBasket.addToProductList(product);
        return this;

    }
    public ProductPage clickByProductWarranty() {
        elementToBeClickable(productWarranty).click();
        return this;
    }

    public ProductPage clickByPeriodWarrantyTwoYears() {
        elementToBeClickable(periodWarrantyTwoYears).click();
        return this;
    }

    public MainPage clickButtonBuyProduct() {
        elementToBeClickable(buttonBuyProduct).click();
        return new MainPage();
    }



    public ProductPage checkTextHasChanged(String value) {
        elementTextToBePresent(productPriceValue, value);
        return this;
    }



}
