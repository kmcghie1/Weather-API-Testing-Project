package com.spartaglobal.weather.dto.interfaces;

public interface ICoordDTO {
    Double getLon();
    Double getLat();

    Boolean isLatWithinBounds();
    Boolean isLonWithinBounds();

    Boolean isLatLonWithinBounds();

    Boolean isCoordsCorrect();
}
