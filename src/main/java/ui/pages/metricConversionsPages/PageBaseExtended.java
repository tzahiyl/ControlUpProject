package ui.pages.metricConversionsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.pages.PageBase;

public abstract class PageBaseExtended extends PageBase {
    @FindBy(id = "answer")
    protected WebElement result;
    @FindBy(id = "format")
    protected WebElement formatResult;

    public void selectFormat(String text){
        Select dropdown = new Select(this.formatResult);
        dropdown.selectByVisibleText(text);
    }

    public String getResult(){
        return this.result.getText();
    }

    public abstract float convertUnit(float sourceUnit);
}
