package pages.base;

import org.openqa.selenium.WebDriver;
import pages.component.HeaderComponent;

public abstract class BasePageHeaderComponentPage extends BasePageTopMenu<HeaderComponent<?>> {
    public BasePageHeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent<?> getHeader(){
        return new HeaderComponent<>(this);
    }
}
