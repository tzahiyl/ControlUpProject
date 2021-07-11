package ui.singletons;

import lombok.Getter;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterSingleton {
    private static final WaiterSingleton instance = new WaiterSingleton();
    @Getter
    private final WebDriverWait webDriverWait;

    private WaiterSingleton() {
        this.webDriverWait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 10);
    }

    public static WaiterSingleton getInstance() {
        return instance;
    }
}
