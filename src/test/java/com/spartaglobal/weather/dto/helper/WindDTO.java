package com.spartaglobal.weather.dto.helper;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.spartaglobal.weather.dto.interfaces.iWindDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "speed",
        "deg",
})
@Generated("jsonschema2pojo")
public class WindDTO implements iWindDTO {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Integer deg;
    @JsonProperty("gust")
    private Double gust;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("speed")
    public Double getSpeed() {
        return speed;
    }

    @JsonProperty("deg")
    public Integer getDeg() {
        return deg;
    }

    @JsonProperty("gust")
    public Double getGust() {
        return gust;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public boolean isWithinLimits(Integer value) {
        if(value >= 0 && value <= 359)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isWithinLimits(Double value) {
        if(value >= 0 && value <= 359)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isGreaterThanZero(int value) {
        if(value > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isGreaterThanZero(Double value) {
        if(value > 0)
        {
            return true;
        }
        return false;
    }

}