package tests;
import cars.pages.carsMakePage;
import cars.pages.shoppingResultsPage;
import cars.pages.vehicleDetailPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.BrowserUtil;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class carsTest {
    carsMakePage carFilters = new carsMakePage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);

    @BeforeTest
    public void OpenTests() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().deleteAllCookies();
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
    }
    @AfterTest
    public void close() {
        Driver.closeDriver();
    }
    @Test(priority = 0)
    public void carsMakeTest() {


        carFilters.setCarsFilter(carFilters.used, "Used");
        carFilters.setCarsFilter(carFilters.makes, "Honda");
        carFilters.setCarsFilter(carFilters.models, "Pilot");
        carFilters.setCarsFilter(carFilters.maxPrice, "$50,000");
        carFilters.setCarsFilter(carFilters.maxDistance, "100 miles");
        carFilters.zipCode.clear();
        carFilters.zipCode.sendKeys("60008");
        carFilters.search.click();
    }
    @Test(priority = 1)
    public void shopingResultsTest() throws InterruptedException {
        shoppingResultsPage resultsPage = new shoppingResultsPage();
        resultsPage.assertingFilters(resultsPage.usedFilter, "Used");
        resultsPage.assertingFilters(resultsPage.makeFilter, "Honda");
        resultsPage.assertingFilters(resultsPage.modelFilter, "Pilot");
        resultsPage.assertingFilters(resultsPage.priceFilter, "Max price: $50,000");

        carFilters.setCarsFilter(resultsPage.New,"New");
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,400)");
        BrowserUtil.scrollToElement(resultsPage.newFilter);


      //  ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", resultsPage.newFilter);
        resultsPage.assertingFilters(resultsPage.newFilter, "New");

        Assert.assertNotEquals(resultsPage.newFilter.getText(), "Used");

        resultsPage.passengerTrim.click();

      //  ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);",resultsPage.TrimFilter);

        wait.until(ExpectedConditions.visibilityOf(resultsPage.TrimFilter));


        Assert.assertEquals(resultsPage.TrimFilter.getText(), "EX-L 8-Passenger");

        resultsPage.AvailableCars.get(1).click();
        String actualTitle =Driver.get().getTitle();
        String expectedTitle =("New 2023 Honda Pilot EX-L 8-Passenger");
        boolean titleContain = actualTitle.contains(expectedTitle);
        if (titleContain){
            System.out.println("Web page title contains the expected string.");
        }else{
            System.out.println("Web page title does not contains the expected string.");
        }
    }
    @Test(priority = 2)
    public void vehicleDetailTest() throws IOException {

        Date currentDate = new Date();
        String screenShotDatedName = currentDate.toString().replace(" ","-").replace(":","-");
        vehicleDetailPage customerInfo = new vehicleDetailPage();
        customerInfo.firstName.sendKeys("car");
        customerInfo.lastName.sendKeys("owner");
        customerInfo.email.sendKeys("carowner@yahoo.com");

        File screensh =customerInfo.paymentCalculator.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screensh, new File("target/"+screenShotDatedName+".png"));

    }

}

