package com.spartaglobal.weather.dto.helper;

import com.fasterxml.jackson.annotation.*;
import com.spartaglobal.weather.dto.interfaces.iWeatherDTO;
import com.spartaglobal.weather.util.WeatherEventLoader;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "main",
        "description",
        "icon"
})
@Generated("jsonschema2pojo")
public class WeatherDTO implements iWeatherDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("main")
    public String getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(String main) {
        this.main = main;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }
    @Override
    public boolean isValidWeatherOption() {
        ArrayList<String> validWeatherOptions = new ArrayList<>(Arrays.asList("Thunderstorm", "Drizzle", "Rain", "Snow", "Mist", "Smoke", "Haze", "Dust", "Fog", "Sand", "Dust", "Ash", "Squall", "Tornado", "Clear", "Clouds"));
        return validWeatherOptions.contains(this.main);
    }

    @Override
    public boolean isValidDescription(){
        ArrayList<String> validDescriptionOptions = new ArrayList<>(Arrays.asList("clear sky", "few clouds", "scattered clouds", "broken clouds", "shower rain", "rain", "thunderstorm", "snow", "mist"));
        return validDescriptionOptions.contains(this.description);
    }

    @Override
    public boolean isValidIcon(){
        ArrayList<String> validIconOptions = new ArrayList<>(Arrays.asList("01d", "02d", "03d", "04d", "09d", "10d", "11d", "13d", "50d", "01n", "02n", "03n", "04n", "09n", "10n", "11n", "13n", "50n"));
        return validIconOptions.contains(this.icon);
    }

    @Override
    public boolean isValidWeatherObject(){
        WeatherEventLoader weatherEventLoader = new WeatherEventLoader();
        HashMap<Integer, String[]> fullWeatherMap = weatherEventLoader.getAllWeatherEvents();
        if(!fullWeatherMap.containsKey(this.id)) {
            return false;
        } else {
            String[] arrayToCheck = fullWeatherMap.get(this.id);
            if(this.main == arrayToCheck[0] && this.description == arrayToCheck[1] && this.icon == arrayToCheck[2]) {
                return true;
            } else {
                return false;
            }
        }
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
