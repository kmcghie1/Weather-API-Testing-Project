package com.spartaglobal.weather.dto.interfaces;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public interface IMainDTO {

    @JsonProperty("temp")
    Double getTemp();

    @JsonProperty("feels_like")
    Double getFeelsLike();

    @JsonProperty("temp_min")
    Double getTempMin();

    @JsonProperty("temp_max")
    Double getTempMax();

    @JsonProperty("pressure")
    Integer getPressure();

    @JsonProperty("humidity")
    Integer getHumidity();

    @JsonAnyGetter
    Map<String, Object> getAdditionalProperties();

    boolean isMinTempLessThanMaxTemp();

    boolean isWithinLimits(Integer upper, Integer lower, Integer value);

    boolean isWithinLimits(Double upper, Double lower, Double value);

    boolean hasSeaLevelAndGroundLevelPressure();

}
