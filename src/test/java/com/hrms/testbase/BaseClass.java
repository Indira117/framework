package com.hrms.testbase;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    /**
     * this method will open the browser, set up configuration and navigate to url
     */

    public static void setUp() {

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":

                // System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); -1 way
                WebDriverManager.chromedriver().setup(); //2 way to setup webrowser same version

                driver = new ChromeDriver();
                break;

            case "firefox":
                // System.setProperty("webdriver.chrome.driver","drivers/chrome.exe");
                WebDriverManager.firefoxdriver().setup(); //2 way to setup webrowser same version
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        PageInitializer.initializePageObjects();

        }

    /**
     * this method will close any open web browser
     */

    public static void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}