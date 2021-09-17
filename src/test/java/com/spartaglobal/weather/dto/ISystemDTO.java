package com.spartaglobal.weather.dto;

public interface ISystemDTO {
    Integer getType();
    Integer getId();
    Double getMessage();
    String getCountry();
    Long getSunrise();
    Long getSunset();
    Boolean isTypeWithinBoundaries(int typeValue);
    Boolean isIdWithinBoundaries(int idValue);
    Boolean isCountryTwoLetters(String countryCode);
    //Commented for deletion
    /*Boolean isSunriseTenDigits(Long time);
    Boolean isSunsetTenDigits(Long time);*/
    Boolean isSunrisePositive(Long time);
    Boolean isSunsetPositive(Long time);
    Boolean isSunriseBeforeSunset(Long sunriseTime, Long sunsetTime);
}
