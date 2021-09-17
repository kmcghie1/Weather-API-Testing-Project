package com.spartaglobal.weather.util;

import java.util.HashMap;

public class WeatherEventLoader {
    public HashMap<Integer, String[]> getAllWeatherEvents() {
        HashMap<Integer, String[]> allWeatherEvents = new HashMap<>() {{
            put(200, new String[]{"Thunderstorm", "thunderstorm with light rain", "11d"});
            put(201, new String[]{"Thunderstorm", "thunderstorm with rain", "11d"});
            put(202, new String[]{"Thunderstorm", "thunderstorm with heavy rain", "11d"});
            put(210, new String[]{"Thunderstorm", "light thunderstorm", "11d"});
            put(211, new String[]{"Thunderstorm", "thunderstorm", "11d"});
            put(212, new String[]{"Thunderstorm", "heavy thunderstorm", "11d"});
            put(221, new String[]{"Thunderstorm", "ragged thunderstorm", "11d"});
            put(230, new String[]{"Thunderstorm", "thunderstorm with light drizzle", "11d"});
            put(231, new String[]{"Thunderstorm", "thunderstorm with drizzle", "11d"});
            put(232, new String[]{"Thunderstorm", "thunderstorm with heavy drizzle", "11d"});
            put(300, new String[]{"Drizzle", "light intensity drizzle", "09d"});
            put(301, new String[]{"Drizzle", "drizzle", "09d"});
            put(302, new String[]{"Drizzle", "heavy intensity drizzle", "09d"});
            put(310, new String[]{"Drizzle", "light intensity drizzle rain", "09d"});
            put(311, new String[]{"Drizzle", "drizzle rain", "09d"});
            put(312, new String[]{"Drizzle", "heavy intensity drizzle rain", "09d"});
            put(313, new String[]{"Drizzle", "shower rain and drizzle", "09d"});
            put(314, new String[]{"Drizzle", "heavy shower rain and drizzle", "09d"});
            put(321, new String[]{"Drizzle", "shower drizzle", "09d"});
            put(500, new String[]{"Rain", "light rain", "10d"});
            put(501, new String[]{"Rain", "moderate rain", "10d"});
            put(502, new String[]{"Rain", "heavy intensity rain", "10d"});
            put(503, new String[]{"Rain", "very heavy rain", "10d"});
            put(504, new String[]{"Rain", "extreme rain", "10d"});
            put(511, new String[]{"Rain", "freezing rain", "13c"});
            put(520, new String[]{"Rain", "light intensity shower rain", "09d"});
            put(521, new String[]{"Rain", "shower rain", "09d"});
            put(522, new String[]{"Rain", "heavy intensity shower rain", "09d"});
            put(531, new String[]{"Rain", "ragged shower rain", "09d"});
            put(600, new String[]{"Snow", "light snow", "13d"});
            put(601, new String[]{"Snow", "Snow", "13d"});
            put(602, new String[]{"Snow", "Heavy snow", "13d"});
            put(611, new String[]{"Snow", "Sleet", "13d"});
            put(612, new String[]{"Snow", "Light shower sleet", "13d"});
            put(613, new String[]{"Snow", "Shower sleet", "13d"});
            put(615, new String[]{"Snow", "Light rain and snow", "13d"});
            put(616, new String[]{"Snow", "Rain and snow", "13d"});
            put(620, new String[]{"Snow", "Light shower snow", "13d"});
            put(621, new String[]{"Snow", "Shower snow", "13d"});
            put(622, new String[]{"Snow", "Heavy shower snow", "13d"});
            put(701, new String[]{"Mist", "mist", "50d"});
            put(711, new String[]{"Smoke", "Smoke", "50d"});
            put(721, new String[]{"Haze", "Haze", "50d"});
            put(731, new String[]{"Dust", "sand/ dust whirls", "50d"});
            put(741, new String[]{"Fog", "fog", "50d"});
            put(751, new String[]{"Sand", "sand", "50d"});
            put(761, new String[]{"Dust", "dust", "50d"});
            put(762, new String[]{"Ash", "volcanic ash", "50d"});
            put(771, new String[]{"Squall", "squalls", "50d"});
            put(781, new String[]{"Tornado", "tornado", "50d"});
            put(800, new String[]{"Clear", "clear sky", "01d-01n"});
            put(801, new String[]{"Clouds", "few clouds: 11-25%", "02d-02n"});
            put(802, new String[]{"Clouds", "scattered clouds: 25-50%", "03d-03n"});
            put(803, new String[]{"Clouds", "broken clouds: 51-84%", "04d-04n"});
            put(804, new String[]{"Clouds", "overcast clouds: 85-100%", "04d-04n"});
        }};
        return allWeatherEvents;
    }
}
