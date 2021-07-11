package api.endpoints;

import api.pojos.CurrentTemperature;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IEndPoints {
    @GET("weather?appid=5b2bbcc9a8320da6c7318a4c96ef5cca")
    Call<CurrentTemperature> getCurrentTemperature(
            @Query("zip") String zipCode,
            @Query("units") String units
    );
}
