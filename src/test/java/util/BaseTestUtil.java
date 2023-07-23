package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseTestUtil {

    private final static Properties properties = new Properties();

    public static void loadPropertiesData(){
        try(InputStream inputStream = new FileInputStream("src/test/resources.properties")){
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver initializeDriver(){
        loadPropertiesData();
        String browserType = properties.getProperty("browser");
        return switch (browserType) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new RuntimeException("wrong driver provided: " + browserType );
        };
    }

    public static String getWebSite(){
        loadPropertiesData();
        return properties.getProperty("url");
    }
    public static void takeScreenshot(WebDriver driver,String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(getFormattedFileName(testName));
        FileUtils.copyFile(source,destFile);
    }


    private static String getFormattedDate(){
        String pattern = "MM-dd-HH-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date());
    }
    private static String getFormattedFileName(String testName){
        return String.format( "%s%s-%s.png", properties
                .getProperty("screenshotspath"),testName,getFormattedDate());
    }
}
