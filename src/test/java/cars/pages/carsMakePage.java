package cars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class carsMakePage extends basePage{

    @FindBy(id= "make-model-search-stocktype")
    public WebElement used;

    @FindBy(id= "makes")
    public WebElement makes;

    @FindBy(id= "models")
    public  WebElement models;

    @FindBy(id= "make-model-max-price")
    public WebElement maxPrice;

    @FindBy(id= "make-model-maximum-distance")
    public WebElement maxDistance;

    @FindBy(id= "make-model-zip")
    public WebElement zipCode;

    @FindBy(xpath= "(//button[@class='sds-button'])[1]")
    public WebElement search;

    public static void setCarsFilter(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }




}