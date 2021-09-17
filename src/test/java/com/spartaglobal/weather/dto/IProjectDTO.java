package com.spartaglobal.weather.dto;

import java.util.List;

public interface IProjectDTO {
    CoordDTO getCoord();
    List<WeatherDTO> getWeather();
    String getBase();
    MainDTO getMain();
    Integer getVisibility();
    WindDTO getWind();
    CloudsDTO getClouds();
    Integer getDt();
    SystemDTO getSys();
    Integer getTimezone();
    Integer getId();
    String getName();
    Integer getCod();;
}
