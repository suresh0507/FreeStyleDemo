package io.cucumber.skeleton;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.logging.Level;


public class Hooks {
    public static final long DEFAULT_TIMEOUT = 45;
    public static WebDriver driver;
    private static Properties prop = new Properties();
    static String path = System.getProperty("user.dir");

    public static void openBrowser(String browser) {
        System.out.println("me"+browser);
        System.out.println("me"+browser );
        String browservalue = "webdriver." + browser + ".driver";
        switch (browser)
        {
            case "chrome":
                System.setProperty(browservalue, path+"/src/test/java/driver/"+browser+"driver.exe");
                driver = new ChromeDriver();
                break;
            case "gecko":

                System.setProperty("webdriver.gecko.driver", path+"/src/test/java/driver/"+browser+"driver.exe");
                driver = new FirefoxDriver(gecko_set_caps());
//                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                System.setProperty(browservalue, path+"/src/test/java/driver/"+browser+"driver.exe");
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }

    	driver.manage().deleteAllCookies();
    }
    private static DesiredCapabilities
    gecko_set_caps() {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return caps;

    }
    public static void scrollElement(WebElement elem) {
        try {
            JavascriptExecutor executor = ((JavascriptExecutor)driver);
            executor.executeScript("arguments[0].scrollIntoView(true);", elem);
        } catch (Exception e) {
            Assert.fail("Can't able to locate element" + e.getMessage());
        }
    }
    public static void waitVisible(WebElement elem) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(elem));
        } catch (Exception e) {
            Assert.fail("Element not visible" + e.getMessage());
        }
    }
    public static void highlight(WebElement ele) {
        if (Hooks.driver!= null) {
            ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].style.border='3px solid red'", ele);

        } else {
            Assert.fail("Problem in highlighting the element ");
        }
    }
    public static void robot() throws AWTException {
     report.robot();
    }
    }
