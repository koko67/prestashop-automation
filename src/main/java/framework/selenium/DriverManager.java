package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance = null;

    protected DriverManager() {
        initialize();
    }

    public static DriverManager getInstance() {
        if(instance == null || instance.driver == null) {
            instance = new DriverManager();
        }
        return instance;
    }


    private void initialize() {
        String driverPath = System.getProperty("user.dir");
        // Firefox
//        System.setProperty("webdriver.gecko.driver", driverPath + "\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
        // Chrome
        System.setProperty("webdriver.chrome.driver", driverPath + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 50, 100);
    }


    public WebDriver getWebDriver() {
        return driver;
    }


    public WebDriverWait getWait() {
        return wait;
    }

    public int getImplicitWait() {
        return 50;
    }

    public void quitDriver() {
        try {

            driver.quit();
        } catch (Exception e) {
        }
        driver = null;
    }
}