package api.client;

import api.endpoints.IEndPoints;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import propertiesLoader.PropertiesSingleton;
import java.util.concurrent.TimeUnit;

public class ClientSingleton {
    private static final ClientSingleton instance = new ClientSingleton();
    @Getter
    private final IEndPoints endPoints;

    private ClientSingleton() {
        OkHttpClient client  = new OkHttpClient.
                Builder().
                connectTimeout(60, TimeUnit.SECONDS).
                readTimeout(60, TimeUnit.SECONDS).
                addInterceptor(new HttpLoggingInterceptor().
                        setLevel(HttpLoggingInterceptor.Level.BODY)).
                build();

        try {
            this.endPoints = new Retrofit.
                    Builder().
                    baseUrl(PropertiesSingleton.getInstance().getProperties().getProperty("apiBaseUrl")).
                    client(client).
                    addConverterFactory(GsonConverterFactory.create()).
                    build().
                    create(IEndPoints.class);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public static ClientSingleton getInstance() {
        return instance;
    }
}
