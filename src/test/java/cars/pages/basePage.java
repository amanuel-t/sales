package cars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class basePage {
    public basePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath= "(//a[contains(text(),'Cars for Sale')])[1]")
    public WebElement CarsSaleDashboard;


}
