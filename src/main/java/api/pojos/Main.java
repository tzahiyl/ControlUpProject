package api.pojos;

import lombok.Data;

@Data
public class Main {
    private Double temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String humidity;
}
