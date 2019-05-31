package framework.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;


public class UIMethods {


    public static void waitForPageLoaded() {
        Wait wait = DriverManager.getInstance().getWait();
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete") ||
                        ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("loaded");
            }
        };

        try {
            wait.until(expectation);
        } catch(Exception e) {

        }
    }


    public static boolean isElementPresent(By byElement) {
        try {
            WebDriver driver = DriverManager.getInstance().getWebDriver();
            driver.findElement(byElement);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static boolean isElementDisplayed(By byElement, long implicitWait ) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        try {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.MILLISECONDS);
            driver.findElement(byElement);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts()
                    .implicitlyWait(DriverManager.getInstance().getImplicitWait(), TimeUnit.SECONDS);
        }
    }


    public static boolean isElementDisplayed(By byElement) {
        return isElementDisplayed(byElement, 3000);
    }

    public static void selectCheckBox(WebElement checkBox) {
        if(!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public static void clearCheckBox(WebElement checkBox) {
        if(checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public static void selectRadioButton(WebElement radioButton) {
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public static boolean isColorThemeLight(By byElement) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        String parentWindowHandle = driver.getWindowHandle();
        try {
            driver.switchTo().frame(driver.findElement(byElement));
            return isElementPresent(By.xpath("//link[contains(@href,'themes/light/css')]"));
        } finally {
            driver.switchTo().window(parentWindowHandle);
        }
    }

    public static boolean isColorThemeStandard(By byElement) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        String parentWindowHandle = driver.getWindowHandle();
        try {
            driver.switchTo().frame(driver.findElement(byElement));
            return isElementPresent(By.xpath("//link[contains(@href,'default/css')]"));
        } finally {
            driver.switchTo().window(parentWindowHandle);
        }
    }



    public static boolean waitForElementPresent(int maxCount, By byElement) {
        boolean result = false;
        int count = 1;
        while (!result && count <= maxCount) {
            result = isElementPresent(byElement);
            count++;
        }
        return result;
    }


    public static boolean waitForOneOfTwoElementsPresent(int maxCount, By firstElementBy, By secondElementBy) {
        boolean success = false;
        boolean failed = false;
        int count = 1;
        while (!success && !failed && count <= maxCount) {
            success = isElementPresent(firstElementBy);
            if (!success) {
                failed = isElementPresent(secondElementBy);
            }
            count++;
        }
        return success;
    }


    public static boolean waitForElementPresentInFrame(int maxCount, By byElement, By byFrame) {
        boolean result = false;
        int count = 1;
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        Wait wait = DriverManager.getInstance().getWait();
        String parentWindowHandle = driver.getWindowHandle();
        while (!result && count <= maxCount) {
            try {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(byFrame));
                result = isElementPresent(byElement);
                System.out.println("THE RESULT IS " + result);
                count++;
            } finally {
                driver.switchTo().window(parentWindowHandle);
            }
        }
        return result;
    }


    public static boolean waitForElementRemoved(int maxCount, By byElement) {
        boolean result = true;
        int count = 1;
        try {
            while (result && count <= maxCount) {
                Thread.sleep(5000);
                result = isElementPresent(byElement);
                count++;
            }
        } catch (InterruptedException e) {

        }
        return !result;
    }


    public static String waitForWindowOpen(int maxCount, String windowTitle) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        int count = 1;
        String window = "";
        String parentWindowHandle = driver.getWindowHandle();
        try {
            while (window.isEmpty() && count <= maxCount) {
                Thread.sleep(1000);

                //To get all the window handles
                for (String winHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(winHandle);

                    //To check if the window is the desired
                    if (driver.getTitle().contains(windowTitle)) {
                        window = winHandle;
                        break;
                    }
                }

                //To switch back to parent window
                driver.switchTo().window(parentWindowHandle);
                count++;
            }
        } catch (InterruptedException e) {

        }
        return window;
    }


    public static WebElement getStaleElement(By by) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        try {
            return driver.findElement(by);
        } catch (StaleElementReferenceException e) {
            return getStaleElement(by);
        }
    }
}
