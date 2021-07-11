package tests.metricConversionsTests;

import org.junit.jupiter.api.BeforeEach;
import tests.TestBase;
import ui.modules.metricConversionsModules.ConvertModule;
import ui.pages.metricConversionsPages.*;

public class MetricConversionsTestBase extends TestBase {
    protected HomePage homePage;
    protected TemperaturePage temperaturePage;
    protected ConvertModule convertModule;
    protected CelsiusToFahrenheitPage celsiusToFahrenheitPage;
    protected WeightPage weightPage;
    protected OuncesToGramsPage ouncesToGramsPage;
    protected LengthPage lengthPage;
    protected MetersToFeetPage metersToFeetPage;
    protected float value = 12.4f;
    protected String valueFormat = "Decimal";

    @BeforeEach
    public void setUp(){
        this.homePage = new HomePage();
        this.temperaturePage = new TemperaturePage();
        this.celsiusToFahrenheitPage = new CelsiusToFahrenheitPage();
        this.convertModule = new ConvertModule();
        this.weightPage = new WeightPage();
        this.ouncesToGramsPage = new OuncesToGramsPage();
        this.lengthPage = new LengthPage();
        this.metersToFeetPage = new MetersToFeetPage();
    }
}
