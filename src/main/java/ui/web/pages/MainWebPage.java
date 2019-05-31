package ui.web.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;


public class MainWebPage extends BasePageObject {



    @FindBy(name = "s")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/button")
    WebElement searchButton;

    WebElement frame;

    public MainWebPage() throws InterruptedException {
        waitUntilPageObjectIsLoaded();
        PageFactory.initElements(driver, this);
//        driver.switchTo().frame(frame);
//        searchInput = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
//        searchButton = driver.findElement(By.xpath("//*[@id=\\\"search_widget\\\"]/form/button"));
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

    private void initElements(){
        searchInput = driver.findElement(By.name("s"));
        searchButton = driver.findElement(By.xpath(""));
    }

    public MainWebPage clickSearchInput(){
        searchInput.click();
        return this;
    }

    public MainWebPage typeString(String value){
        searchInput.sendKeys(value);
        return this;
    }

    public MainWebPage clickSearchButton(){
        searchButton.click();
        return this;
    }


}