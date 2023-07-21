package pages.component;

import pages.base.BasePage;
import pages.base.BasePageTopMenu;

public abstract class BaseComponent<Page extends BasePageTopMenu<?>> extends BasePage {

    public BaseComponent(Page page){
        super(page.getDriver());
    }
}
