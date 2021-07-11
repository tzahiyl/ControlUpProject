package ui.pages.weatherPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.PageBase;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

public class TodayWeatherPage extends PageBase{
    private String relativeUrl = "weather/today/l/{cityOrZipCode}";

    @FindBys
            ({
                    @FindBy(css = "div[data-testid = 'CurrentConditionsContainer']"),
                    @FindBy(css = "span[data-testid = 'TemperatureValue']")
            })
    WebElement currentTemperatureField;

    public TodayWeatherPage(String cityOrZipCode){
        this.relativeUrl = this.relativeUrl.replace("{cityOrZipCode}", cityOrZipCode);
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        super.loadPage(relativeUrl);
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                visibilityOf(this.currentTemperatureField));
    }

    public Double getCurrentTemperature(){
        this.waitTillPageLoaded();
        return Double.parseDouble(this.currentTemperatureField.getText().replace("\u00B0", ""));
    }
}
