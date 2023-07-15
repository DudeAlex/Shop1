package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseModel {
    private WebDriver driver;
    private WebDriverWait wait2;
    private WebDriverWait wait5;
    private WebDriverWait wait10;

    public WebDriver getDriver() {
        if (driver == null)
            driver = new ChromeDriver();

        return driver;
    }

    public WebDriverWait getWait2() {
        if (wait2 == null)
            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        return wait2;
    }
    public WebDriverWait getWait5() {
        if (wait5 == null)
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait5;
    }
    public WebDriverWait getWait10() {
        if (wait10 == null)
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait10;
    }
}
