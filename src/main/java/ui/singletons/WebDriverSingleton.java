package ui.singletons;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriverSingleton instance;
    @Getter
    private final WebDriver driver;

    private WebDriverSingleton() {
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("/drivers/chromedriver.exe").getPath());
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
    }

    public static WebDriverSingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverSingleton();
        }

        return instance;
    }

    public void closeInstance() {
        this.driver.close();
        instance = null;
    }
}
