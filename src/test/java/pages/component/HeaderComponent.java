package pages.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePageTopMenu;

public class HeaderComponent<Page extends BasePageTopMenu<?>> extends BaseComponent<Page>{


    public HeaderComponent(Page page)
    {
        super(page);
    }

    @FindBy(xpath = "//a[@href='https://askomdch.com/']")
    WebElement titleHomePage;

    @FindBy(xpath = "//li[@id='menu-item-1227']/a")
    private WebElement storeMenuItem;

    public String getHomePageTitleLinkText(){

        return titleHomePage.getText();
    }


}
