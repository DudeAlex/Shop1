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
        loadProperties();
        loadDriver();
        goToURL();
    }

    @AfterMethod
    public void tearDown(Method method, ITestResult iTestResult) throws IOException {
        if(!iTestResult.isSuccess()){
            BaseTestUtil.takeScreenshot(getDriver(), method.getName());
        }
        getDriver().quit();
    }

    private void loadProperties() {
        BaseTestUtil.loadPropertiesData();
    }

    private void loadDriver() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void goToURL(){
        getDriver().get(BaseTestUtil.getWebSite());
    }
}
