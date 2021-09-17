package com.spartaglobal.weather.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface iWindDTO
{
    @JsonProperty("speed")
    Double getSpeed();
    @JsonProperty("deg")
    Integer getDeg();

    boolean isWithinLimits(Integer value);

    boolean isWithinLimits(Double value);

    boolean isGreaterThanZero(int value);

    boolean isGreaterThanZero(Double value);


}
