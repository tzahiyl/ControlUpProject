package ui.pages.weatherPages;

import org.openqa.selenium.support.PageFactory;
import ui.modules.weatherModules.HeaderToolBarModule;
import ui.pages.PageBase;
import ui.singletons.WebDriverSingleton;

public class HomePage extends PageBase {
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
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), HeaderToolBarModule.class).
                waitTillHeaderToolBarDisplayed();
    }
}
