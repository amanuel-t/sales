package cars.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class shoppingResultsPage extends basePage {
    WebDriver driver;

    public shoppingResultsPage() {PageFactory.initElements(Driver.get(), this);
    }

    //   public shoppingResultsPage(){PageFactory.initElements(Driver.get(), this);}
    @FindBy(id = "make-model-search-stocktype")
    public WebElement userName;

    @FindBy(xpath = "//label[@for='active_filter_tags-stock_type-used']")
    public WebElement usedFilter;
    @FindBy(xpath = " //label[@for='active_filter_tags-makes-honda']")
    public WebElement makeFilter;
    @FindBy(xpath = "//label[@for='active_filter_tags-models-honda-pilot']")
    public WebElement modelFilter;
    @FindBy(xpath = "//label[@for='active_filter_tags-list_price_range--50000']")
    public WebElement priceFilter;
    @FindBy(id = "stock-type-select")
    public WebElement New;
    @FindBy(xpath = "//label[@for='active_filter_tags-stock_type-new']")
    public WebElement newFilter;
    @FindBy(xpath = "//label[@for='trim_honda-pilot-ex_l_8_passenger']")
    public WebElement passengerTrim;
    @FindBy(xpath = "//label[@for='active_filter_tags-trims-honda-pilot-ex_l_8_passenger']")
    public WebElement TrimFilter;
    @FindBy(xpath = "//a[@class='vehicle-card-link js-gallery-click-link']")
    public List<WebElement> AvailableCars;

    public void assertingFilters(WebElement element, String value) {
        Assert.assertEquals(element.getText(), value);
    }

    public vehicleDetailPage selectElementByIndex(List<WebElement> element, int index) {
        WebElement selectElement = element.get(index);
        selectElement.click();
        return new vehicleDetailPage();
    }


}
