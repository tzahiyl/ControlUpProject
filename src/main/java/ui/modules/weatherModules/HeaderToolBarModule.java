package ui.modules.weatherModules;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

public class HeaderToolBarModule {
    @FindBy(id = "LocationSearch_input")
    private WebElement searchByCityOrZipCodeInputField;
    @FindBy(id = "LocationSearch_listbox")
    private WebElement searchList;

    public HeaderToolBarModule(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    public void waitTillHeaderToolBarDisplayed(){
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                elementToBeClickable(this.searchByCityOrZipCodeInputField));
    }

    public void insertCityOrZipCode(String cityOrZipCode){
        this.waitTillHeaderToolBarDisplayed();
        this.searchByCityOrZipCodeInputField.sendKeys(cityOrZipCode);
    }

    protected void waitTillSearchListDisplayed(){
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                visibilityOf(this.searchList));
    }

    public void executeSearch(){
        this.waitTillSearchListDisplayed();
        this.searchByCityOrZipCodeInputField.sendKeys(Keys.ENTER);
    }

    public void searchByCityOrZipCode(String cityOrZipCode){
        this.insertCityOrZipCode(cityOrZipCode);
        this.executeSearch();
    }
}
