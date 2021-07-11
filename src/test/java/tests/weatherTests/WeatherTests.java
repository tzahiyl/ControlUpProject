package tests.weatherTests;

import api.pojos.CurrentTemperature;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTests extends WeatherTestBase{

    @Test
    public void verifyGapIsInRangeOf10PercentageTest() throws IOException {
        this.homePage.loadPage();
        this.headerToolBarModule.searchByCityOrZipCode(this.cityOrZipCode);
        Double current = this.todayWeatherPage.getCurrentTemperature();

        Response<CurrentTemperature> res = this.endPoints.
                getCurrentTemperature(this.cityOrZipCode, this.units).
                execute();

        assertThat(res.code()).as("get current temperature status code by api is not 200").isEqualTo(200);
        assertThat(res.body()).as("get current temperature body by api is null").isNotNull();
        assertThat(current).isCloseTo(res.body().getMain().getTemp(), Percentage.withPercentage(10));
    }
}
