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

    boolean isWithinLimits(Integer upper, Integer lower, Integer value);

    boolean isWithinLimits(Double upper, Double lower, Double value);
}
