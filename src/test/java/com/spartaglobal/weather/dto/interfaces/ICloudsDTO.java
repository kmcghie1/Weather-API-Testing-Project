package com.spartaglobal.weather.dto.interfaces;

public interface ICloudsDTO {
    Integer getAll();
    Boolean isPercentWithinBoundaries(Integer percentage);
}
