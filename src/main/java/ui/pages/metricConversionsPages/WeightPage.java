package ui.pages.metricConversionsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.PageBase;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

public class WeightPage extends PageBase {
    @FindBys
            ({
                    @FindBy(id = "popLinks"),
                    @FindBy(linkText = "Ounces to Grams")
            })
    private WebElement ouncesToGramsLink;

    public WeightPage(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    @Override
    public void loadPage() {
        this.loadPage("weight-conversion.htm/");
        this.waitTillPageLoaded();
    }

    @Override
    protected void waitTillPageLoaded() {
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                elementToBeClickable(this.ouncesToGramsLink));
    }

    public void goToOuncesToGramsPage(){
        this.ouncesToGramsLink.click();
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), OuncesToGramsPage.class).
                waitTillPageLoaded();
    }
}
