package ui.pages.metricConversionsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.PageBase;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

public class HomePage extends PageBase {
    @FindBys
    ({
            @FindBy(id = "typeMenu"),
            @FindBy(linkText = "Temperature")
    })
    private WebElement temperatureConversionLink;
    @FindBys
            ({
                    @FindBy(id = "typeMenu"),
                    @FindBy(linkText = "Weight")
            })
    private WebElement weightConversionLink;
    @FindBys
            ({
                    @FindBy(id = "typeMenu"),
                    @FindBy(linkText = "Length")
            })
    private WebElement lengthConversionLink;

    public HomePage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("");
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                elementToBeClickable(this.temperatureConversionLink));
    }

    public void goToTemperaturePage() {
        this.temperatureConversionLink.click();
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), TemperaturePage.class).
                waitTillPageLoaded();
    }

    public void goToWeightPage(){
        this.weightConversionLink.click();
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), WeightPage.class).
                waitTillPageLoaded();
    }
    public void goToLengthPage(){
        this.lengthConversionLink.click();
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), LengthPage.class).
                waitTillPageLoaded();
    }
}
