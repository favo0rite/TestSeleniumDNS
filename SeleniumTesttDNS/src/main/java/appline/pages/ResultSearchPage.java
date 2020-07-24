package appline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultSearchPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'PlayStation 4 Slim Black')]")
    public WebElement ps4;

    public ProductPage clickByPs4(){
        elementToBeClickable(ps4).click();
        return new ProductPage();
    }
}
