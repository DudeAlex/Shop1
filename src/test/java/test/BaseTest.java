package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.base.BaseModel;
import util.TestUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest extends BaseModel {

    @BeforeMethod
    public void setUp(){
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get("https://askomdch.com/");
    }
    @AfterMethod
    public void tearDown(Method method, ITestResult iTestResult) throws IOException {
        if(!iTestResult.isSuccess()){
            String screenshotNameWithPath = "./src/test/errorScreenshots/" + method.getName() + ".png";
            TestUtil.takeScreenshot(getDriver(), screenshotNameWithPath);
        }
        getDriver().quit();
    }
}
