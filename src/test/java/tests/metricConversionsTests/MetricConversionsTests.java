package tests.metricConversionsTests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MetricConversionsTests extends MetricConversionsTestBase {
    @Test
    public void verifyCelsiusToFahrenheitIsCorrectTest() {
        this.homePage.loadPage();
        this.homePage.goToTemperaturePage();
        this.temperaturePage.goToCelsiusToFahrenheitPage();
        this.convertModule.insertValue(this.value);
        this.celsiusToFahrenheitPage.selectFormat(this.valueFormat);

        Assertions.assertThat(this.celsiusToFahrenheitPage.getResult()).
                as("celsius-to-fahrenheit result is not equal").
                contains(String.format("%.3f", this.celsiusToFahrenheitPage.convertUnit(value)));
    }

    @Test
    public void verifyMetersToFeetIsCorrectTest() {
        this.homePage.loadPage();
        this.homePage.goToLengthPage();
        this.lengthPage.goToMetersToFeetPage();
        this.convertModule.insertValue(this.value);
        this.metersToFeetPage.selectFormat(this.valueFormat);

        Assertions.assertThat(this.metersToFeetPage.getResult()).
                as("meters-to-feet result is not equal").
                contains(String.format("%.3f", this.metersToFeetPage.convertUnit(value)));
    }

    @Test
    public void verifyOuncesToGramsIsCorrectTest() {
        this.homePage.loadPage();
        this.homePage.goToWeightPage();
        this.weightPage.goToOuncesToGramsPage();
        this.convertModule.insertValue(this.value);
        this.ouncesToGramsPage.selectFormat(this.valueFormat);

        Assertions.assertThat(this.ouncesToGramsPage.getResult()).
                as("ounces-to-grams result is not equal").
                contains(String.format("%.3f", this.ouncesToGramsPage.convertUnit(value)));
    }
}
