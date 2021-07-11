package ui.pages.metricConversionsPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.PageBase;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

@Getter
public class TemperaturePage extends PageBase {
    @FindBys
            ({
                    @FindBy(id = "popLinks"),
                    @FindBy(linkText = "Celsius to Fahrenheit")
            })
    private WebElement celsiusToFahrenheitLink;

    public TemperaturePage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("temperature-conversion.htm/");
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                elementToBeClickable(this.celsiusToFahrenheitLink));
    }

    public void goToCelsiusToFahrenheitPage(){
        this.celsiusToFahrenheitLink.click();
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), CelsiusToFahrenheitPage.class).
                waitTillPageLoaded();
    }
}
