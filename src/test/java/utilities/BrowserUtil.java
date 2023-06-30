package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {


    public static void ScrollUp(WebElement element){
        Actions actions = new Actions(Driver.get());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

    }
    public static WebElement getElement(By locator){
        return Driver.get().findElement(locator);
    }
    public static void selectDropDownValue(By locator , String type,String value)
    {
        Select select = new Select(getElement(locator));
        switch (type){
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "visibletext":
                select.selectByVisibleText(value);
                break;
            default:
                System.out.println("please pass the correct selection criteria..");
                break;
        }
    }

    public static void ScrollDown(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue(element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }
    public static void doubleClick(WebElement element) {
        new Actions(Driver.get()).doubleClick(element).build().perform();
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    public static void takeSnapShot(WebElement webdriver, String file) {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File paymentFile = scrShot.getScreenshotAs(OutputType.FILE);
    }
//    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
//        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
//        return wait.until(ExpectedConditions.visibilityOf(element));
//    }
//    public static WebElement waitForClickablility(By locator, int timeout) {
//        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
//        return wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.get().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJS(Driver.get().findElement(by));
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static List<String> getListOfString(List<WebElement> listOfWebElements) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            String value = element.getText().trim();
            //If there is no text
            //do not add this black text into list
            if(value.length()>0){
                listOfStrings.add(value);
            }
        }
        return listOfStrings;
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
