package ui.pages.metricConversionsPages;

import org.openqa.selenium.support.PageFactory;
import ui.modules.metricConversionsModules.ConvertModule;
import ui.singletons.WebDriverSingleton;

public class OuncesToGramsPage extends PageBaseExtended {
    public OuncesToGramsPage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("weight/ounces-to-grams.htm");
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), ConvertModule.class).
                waitTillElementDisplayed();
    }

    @Override
    public float convertUnit(float sourceUnit) {
        return (float) (sourceUnit/0.035274);
    }
}
