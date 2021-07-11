package ui.pages.metricConversionsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.PageBase;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

public class LengthPage extends PageBase {
    @FindBys
            ({
                    @FindBy(id = "popLinks"),
                    @FindBy(linkText = "Meters to Feet")
            })
    private WebElement metersToFeetLink;

    public LengthPage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("length-conversion.htm/");
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                elementToBeClickable(this.metersToFeetLink));
    }

    public void goToMetersToFeetPage(){
        this.metersToFeetLink.click();
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), MetersToFeetPage.class).
                waitTillPageLoaded();
    }
}
