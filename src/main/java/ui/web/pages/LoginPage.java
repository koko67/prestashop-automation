package ui.web.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;

import javax.xml.xpath.XPath;

public class LoginPage extends BasePageObject {


    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    WebElement passwordInput;

    public LoginPage() throws InterruptedException {
        waitUntilPageObjectIsLoaded();
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws InterruptedException {
        By byframe = By.id("framelive");
        By input = By.name("s");
        UIMethods.waitForElementPresentInFrame(5, input, byframe);
        driver.switchTo().frame("framelive");

//        Thread.sleep(20000);
//        ExpectedConditions.visibilityOfElementLocated(By.name("s"));
    }

}
