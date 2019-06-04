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

    @FindBy(id = "content-wrapper")
    WebElement resultPane;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    WebElement SignInButton;

    public MainWebPage() throws InterruptedException {
        waitUntilPageObjectIsLoaded();
        PageFactory.initElements(driver, this);
//        driver.switchTo().frame(frame);
//        searchInput = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
//        searchButton = driver.findElement(By.xpath("//*[@id=\\\"search_widget\\\"]/form/button"));
    }

    public LoginPage clickSignInButton() throws InterruptedException {
        SignInButton.click();
        return new LoginPage();
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

    public boolean existResultSearchElementByText(String text){
        By result = By.xpath("//article//h2//a[contains(text(), 'Hummingbird printed t-shirt')]");
        String resultText = resultPane.findElement(result).getText();
        return resultText != null;
    }

    public MainWebPage clickEmailAddressSubscribe() {
        By emailAddresInput = By.name("email");
        driver.findElement(emailAddresInput).click();
        return this;
    }

    public MainWebPage typeEmailAddresSubscribe(String arg0) {
        By emailAddresInput = By.name("email");
        driver.findElement(emailAddresInput).sendKeys(arg0);
        return this;
    }

    public void clickSubscribeNewlettersButton() {
        By subscribeButton = By.name("submitNewsletter");
        driver.findElement(subscribeButton).click();
    }

    public boolean isMessageDisplayed(String message) {
        By messageLocator = By.xpath("//footer[@id='footer']//p[contains(text(), '" + message + "')]");
        String displayedMessage = driver.findElement(messageLocator).getText();
        boolean isDisplayed = displayedMessage.contains(message);
        return false;
    }
}