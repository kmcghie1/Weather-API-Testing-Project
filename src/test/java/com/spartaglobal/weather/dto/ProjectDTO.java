package com.spartaglobal.weather.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.spartaglobal.weather.dto.helper.*;
import com.spartaglobal.weather.dto.interfaces.IProjectDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "weather",
        "base",
        "main",
        "visibility",
        "wind",
        "clouds",
        "dt",
        "sys",
        "timezone",
        "id",
        "name",
        "cod"
})
@Generated("jsonschema2pojo")
public class ProjectDTO implements IProjectDTO {

    @JsonProperty("coord")
    private CoordDTO coord;
    @JsonProperty("weather")
    private List<WeatherDTO> weather = null;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private MainDTO main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private WindDTO wind;
    @JsonProperty("clouds")
    private CloudsDTO clouds;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sys")
    private SystemDTO sys;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coord")
    public CoordDTO getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(CoordDTO coord) {
        this.coord = coord;
    }

    @JsonProperty("weather")
    public List<WeatherDTO> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<WeatherDTO> weather) {
        this.weather = weather;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("main")
    public MainDTO getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(MainDTO main) {
        this.main = main;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("wind")
    public WindDTO getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(WindDTO wind) {
        this.wind = wind;
    }

    @JsonProperty("clouds")
    public CloudsDTO getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(CloudsDTO clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("sys")
    public SystemDTO getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(SystemDTO sys) {
        this.sys = sys;
    }

    @JsonProperty("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
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