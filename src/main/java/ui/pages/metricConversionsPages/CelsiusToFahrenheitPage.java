package ui.pages.metricConversionsPages;

import org.openqa.selenium.support.PageFactory;
import ui.modules.metricConversionsModules.ConvertModule;
import ui.singletons.WebDriverSingleton;


public class CelsiusToFahrenheitPage extends PageBaseExtended {
    public CelsiusToFahrenheitPage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("temperature/celsius-to-fahrenheit.htm");
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), ConvertModule.class).
                waitTillElementDisplayed();
    }

    @Override
    public float convertUnit(float sourceUnit) {
        return (float)(sourceUnit*1.8 + 32);
    }
}
