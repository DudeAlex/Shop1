package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class HomePageTest extends BaseTest{
    @Test
    public void testVerifyTitleOfHomePageIsCorrect(){
        String homePageTitle = new HomePage(getDriver()).getHomePageTitleText();
        Assert.assertEquals(homePageTitle,"AskOmDch");
    }
    @Test
    public void testErrorTest(){
        Assert.fail( "Error test");
    }
}
