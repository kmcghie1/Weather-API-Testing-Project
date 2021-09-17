package com.spartaglobal.weather.dto;

import com.fasterxml.jackson.annotation.*;
import javax.annotation.processing.Generated;
import java.lang.reflect.Array;
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

    @JsonProperty("main")
    public String getMain() {
        return main;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @Override
    public boolean isValidWeatherOption(String weather) {
        ArrayList<String> validWeatherOptions = new ArrayList<>(Arrays.asList("Thunderstorm", "Drizzle", "Rain", "Snow", "Mist", "Smoke", "Haze", "Dust", "Fog", "Sand", "Dust", "Ash", "Squall", "Tornado", "Clear", "Clouds"));

        if(validWeatherOptions.contains(weather)){
            return true;
        }
        else{
            return false;
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
