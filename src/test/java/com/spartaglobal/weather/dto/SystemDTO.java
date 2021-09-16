package com.spartaglobal.weather.dto;

public class SystemDTO implements ISystemDTO{

    private Integer type;
    private Integer id;
    private Double message;
    private String country;
    private Long sunrise;
    private Long sunset;

    @Override
    public Integer getType() {
        return type;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Double getMessage() {
        return message;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public Long getSunrise() {
        return sunrise;
    }

    @Override
    public Long getSunset() {
        return sunset;
    }

    @Override
    public Boolean isTypeWithinBoundaries(int typeValue) {
        int lowerBound = 1;
        int upperBound = 2;
        if((typeValue>=lowerBound)&&(typeValue <= upperBound)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean isIdWithinBoundaries(int idValue) {
        int lowerBound = 0;
        int upperBound = Integer.MAX_VALUE;

        if((idValue >=lowerBound)&&(idValue<=upperBound)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean isCountryTwoLetters(String countryCode) {
        String countryCodeReg = "[A-Z]{2}";
        return countryCode.matches(countryCodeReg);
    }

    @Override
    public Boolean isSunriseTenDigits(Long time) {
        return time.toString().length()==10;
    }

    @Override
    public Boolean isSunsetTenDigits(Long time) {
        return time.toString().length()==10;
    }

    @Override
    public Boolean isSunriseBeforeSunset(Long sunriseTime, Long sunsetTime) {
        return sunriseTime<sunsetTime;
    }
}
