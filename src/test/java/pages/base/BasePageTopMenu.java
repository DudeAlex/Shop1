package pages.base;

import org.openqa.selenium.WebDriver;
import pages.component.BaseComponent;

public abstract class BasePageTopMenu<Header extends BaseComponent<?>> extends BasePage{

    public BasePageTopMenu(WebDriver driver){
        super(driver);
    }

    public abstract Header getHeader();
}
