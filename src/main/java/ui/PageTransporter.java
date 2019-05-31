package ui;

import framework.selenium.DriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import ui.web.pages.MainWebPage;

import static framework.selenium.UIMethods.isElementDisplayed;


public class PageTransporter {
    private String baseWebURL = "";

    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {

    }

    private void goToURL(String url) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();

        //Time out receiving message from renderer is thrown for chrome executions
        try {
            driver.navigate().to(url);
        } catch (TimeoutException e) {

            driver.navigate().to(url);
        }

    }

    public String getCurrentURL() {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        return driver.getCurrentUrl();
    }

    public MainWebPage navigateToMainWebPage(String url) throws InterruptedException {
        goToURL(url);
        return new MainWebPage();
    }


}
