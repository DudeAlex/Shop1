package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BaseModel {

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
