package com.spartaglobal.weather.dto;

public interface ICloudsDTO {
    Integer getAll();
    Boolean isPercentWithinBoundaries(Integer percentage);
}
