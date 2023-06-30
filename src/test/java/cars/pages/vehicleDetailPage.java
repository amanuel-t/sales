package cars.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class vehicleDetailPage extends basePage{
    @FindBy(id= "first_name")
    public WebElement firstName;
    @FindBy(id= "last_name")
    public WebElement lastName;
    @FindBy(id= "email")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"fields-lead-form-embedded\"]/section/div/div[2]/spark-button")
    public WebElement checkAvailability;
    @FindBy(xpath= "//div[@class='full-calc']")
    public WebElement paymentCalculator;

    public void customerIn(String firstN, String lastN,String emailAddress)
    {
        firstName.sendKeys(firstN);
        lastName.sendKeys(lastN);
        email.sendKeys(emailAddress);
    }

}

