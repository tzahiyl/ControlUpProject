package tests;

import org.junit.jupiter.api.AfterEach;
import ui.singletons.WebDriverSingleton;

public class TestBase {
    @AfterEach
    public void tearDown(){
        WebDriverSingleton.getInstance().closeInstance();
    }
}
