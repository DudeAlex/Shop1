package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePageHeaderComponentPage;

public class HomePage extends BasePageHeaderComponentPage {

    @FindBy(xpath = "//a[@href='/store']")
    WebElement storeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String verifyShopNowButton(){
        return storeButton.getText();
    }
}
