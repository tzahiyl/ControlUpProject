package ui.pages.metricConversionsPages;

import org.openqa.selenium.support.PageFactory;
import ui.modules.metricConversionsModules.ConvertModule;
import ui.singletons.WebDriverSingleton;

public class MetersToFeetPage extends PageBaseExtended {
    public MetersToFeetPage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("length/meters-to-feet.htm");
        this.waitTillPageLoaded();
    }

    protected void waitTillPageLoaded() {
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), ConvertModule.class).
                waitTillElementDisplayed();
    }

    @Override
    public float convertUnit(float sourceUnit) {
        return sourceUnit*3.2808f;
    }
}
