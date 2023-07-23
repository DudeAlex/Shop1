package test.base;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest{
    @Test
    public void testVerifyShopNowButtonExists(){
        String storeButtonText = new HomePage(getDriver()).verifyShopNowButton();

        Assert.assertEquals(storeButtonText, "SHOP NOW");
    }
    @Test
    public void testVerifyShopNowButtonExists2(){
        String storeButtonText = new HomePage(getDriver()).verifyShopNowButton();

        Assert.assertEquals(storeButtonText, "SHOP NOW");
    }

    @Test
    public void verifyHeaderTitleIsPresent(){
        String titleHeaderText = new HomePage(getDriver()).getHeader().getHomePageTitleLinkText();

        Assert.assertEquals(titleHeaderText, "AskOmDch");
    }
}
