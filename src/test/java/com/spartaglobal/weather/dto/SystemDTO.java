package com.spartaglobal.weather.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "id",
        "message",
        "country",
        "sunrise",
        "sunset"
})
@Generated("jsonschema2pojo")

public class SystemDTO implements ISystemDTO{

    @JsonProperty("type")
    private Integer type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private Long sunrise;
    @JsonProperty("sunset")
    private Long sunset;

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("message")
    public Double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Double message) {
        this.message = message;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("sunrise")
    public Long getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunset")
    public Long getSunset() {
        return sunset;
    }

    @Override
    public Boolean isTypeWithinBoundaries(int typeValue) {
        int lowerBound = 1;
        int upperBound = 2;
        if((typeValue>=lowerBound)&&(typeValue <= upperBound)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean isIdWithinBoundaries(int idValue) {
        int lowerBound = 0;
        int upperBound = Integer.MAX_VALUE;

        if((idValue >=lowerBound)&&(idValue<=upperBound)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean isCountryTwoLetters(String countryCode) {
        String countryCodeReg = "[A-Z]{2}";
        return countryCode.matches(countryCodeReg);
    }

    @Override
    public Boolean isSunriseTenDigits(Long time) {
        return time.toString().length()==10;
    }

    @Override
    public Boolean isSunsetTenDigits(Long time) {
        return time.toString().length()==10;
    }

    @Override
    public Boolean isSunriseBeforeSunset(Long sunriseTime, Long sunsetTime) {
        return sunriseTime<sunsetTime;
    }
}
