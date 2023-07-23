package test.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.base.BaseModel;
import util.BaseTestUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest extends BaseModel {

    @BeforeMethod
    public void setUp(){
        startDriver();
        setUpImplicitWaitMaximizeWindow();
        goToURLStoredInProperties();
    }

    @AfterMethod
    public void tearDown(Method method, ITestResult iTestResult) throws IOException {
        if(!iTestResult.isSuccess()){
            BaseTestUtil.takeScreenshot(getDriver(), method.getName());
        }
        quitDriver();
    }

    private void startDriver() {

        int count = 0;
        do {
            try {
                Thread.sleep(500);
                getDriver();
            } catch (Exception e) {
                if (++count >= 3) {
                    throw new RuntimeException(e);
                }
            }
        } while (getDriver() == null);
    }
    private void setUpImplicitWaitMaximizeWindow() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    private void goToURLStoredInProperties(){
        getDriver().get(BaseTestUtil.getWebSite());
    }
}
