package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://askomdch.com/']")
    WebElement titleHomePage;

    public String getHomePageTitleText(){

        return titleHomePage.getText();
    }
}
