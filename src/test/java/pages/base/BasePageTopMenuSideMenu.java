package pages.base;

import org.openqa.selenium.WebDriver;
import pages.component.BaseComponent;

public abstract class BasePageTopMenuSideMenu<Header extends BaseComponent<?>,SideMenu extends BaseComponent<?>>
        extends BasePageTopMenu<Header>  {
    public BasePageTopMenuSideMenu(WebDriver driver) {
        super(driver);
    }

    public abstract SideMenu getSideMenu();
}
