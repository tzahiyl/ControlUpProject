package ui.modules.metricConversionsModules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.singletons.WaiterSingleton;
import ui.singletons.WebDriverSingleton;

public class ConvertModule {
    @FindBy(id = "argumentConv")
    private WebElement userConvertInputField;

    public ConvertModule(){
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
    }

    public void waitTillElementDisplayed(){
        WaiterSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.
                visibilityOf(this.userConvertInputField));
    }

    public void insertValue(float value){
        this.userConvertInputField.sendKeys(Float.toString(value));
    }
}
