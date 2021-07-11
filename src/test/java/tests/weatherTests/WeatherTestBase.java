package tests.weatherTests;

import api.endpoints.IEndPoints;
import api.client.ClientSingleton;
import org.junit.jupiter.api.BeforeEach;
import tests.TestBase;
import ui.modules.weatherModules.HeaderToolBarModule;
import ui.pages.weatherPages.HomePage;
import ui.pages.weatherPages.TodayWeatherPage;

public class WeatherTestBase extends TestBase {
    protected HomePage homePage;
    protected HeaderToolBarModule headerToolBarModule;
    protected TodayWeatherPage todayWeatherPage;
    protected String cityOrZipCode = "20852";
    protected String units = "imperial";
    protected IEndPoints endPoints;

    @BeforeEach
    public void setUp(){
        this.homePage = new HomePage();
        this.headerToolBarModule = new HeaderToolBarModule();
        this.todayWeatherPage = new TodayWeatherPage(this.cityOrZipCode);
        this.endPoints = ClientSingleton.getInstance().getEndPoints();
    }
}
