package ui.pages;

import propertiesLoader.PropertiesSingleton;
import ui.singletons.WebDriverSingleton;

public abstract class PageBase {
    protected void loadPage(String relativeUrl) {
        WebDriverSingleton.getInstance().getDriver().
                get(PropertiesSingleton.getInstance().getProperties().get("baseUrl") + relativeUrl);
    }

    public abstract void loadPage();
    protected abstract void waitTillPageLoaded();
}
