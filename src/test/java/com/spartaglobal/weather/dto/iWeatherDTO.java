package com.spartaglobal.weather.dto;

public interface iWeatherDTO {
    Integer getId();
    String getMain();
    String getDescription();
    String getIcon();
    boolean isValidWeatherOption();
    boolean isValidDescription();
    boolean isValidIcon();
    boolean isValidWeatherObject();
}
