package com.spartaglobal.weather.tests;

import com.spartaglobal.weather.ConnectionManager;
import com.spartaglobal.weather.Injector;
import com.spartaglobal.weather.dto.ProjectDTO;
import com.spartaglobal.weather.dto.helper.WeatherDTO;
import com.spartaglobal.weather.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeatherDTOTest {
    WeatherDTO weatherDTO;
    WeatherDTO exampleWeatherObject;

    @BeforeEach
    void setup(){
        ProjectDTO projectDTO = Injector.injectDTO(ConnectionManager.getURL("London", PropertiesLoader.getProperties().getProperty("APIKey")));
        weatherDTO = projectDTO.getWeather().get(0);

        exampleWeatherObject = new WeatherDTO();
        exampleWeatherObject.setId(612);
        exampleWeatherObject.setMain("Snow");
        exampleWeatherObject.setDescription("Light shower sleet");
        exampleWeatherObject.setIcon("13d");
    }
    @Nested
    @DisplayName("Test getters function")
    class testGettersFunction{

        @Test
        @DisplayName("Testing getId returns id")
        void testingGetId(){
            Assertions.assertNotNull(weatherDTO.getId());
        }

        @Test
        @DisplayName("Testing getMain returns main")
        void testingGetMain(){
            Assertions.assertNotNull(weatherDTO.getMain());
        }

        @Test
        @DisplayName("Testing getDescription returns description")
        void testingGetDescription(){
            Assertions.assertNotNull(weatherDTO.getDescription());
        }

        @Test
        @DisplayName("Testing getIcon returns icon")
        void testingGetIcon(){
            Assertions.assertNotNull(weatherDTO.getIcon());
        }
    }

    @Nested
    @DisplayName("Testing correct data type")
    class testingCorrectDataType{

        @Test
        @DisplayName("Testing id is the correct data type")
        void testIdIsInteger(){
            Assertions.assertEquals(Integer.class, weatherDTO.getId().getClass());
        }

        @Test
        @DisplayName("Testing main is the correct data type")
        void testMainIsString(){
            Assertions.assertEquals(String.class, weatherDTO.getMain().getClass());
        }

        @Test
        @DisplayName("Testing description is the correct data type")
        void testDescriptionIsString(){
            Assertions.assertEquals(String.class, weatherDTO.getDescription().getClass());
        }

        @Test
        @DisplayName("Testing icon is the correct data type")
        void testIconIsString(){
            Assertions.assertEquals(String.class, weatherDTO.getIcon().getClass());
        }
    }

    @Nested
    @DisplayName("Testing helper methods")
    class testingHelperMethods{

        @ParameterizedTest
        @ValueSource(strings = {"Thunderstorm", "Mist", "Dust"})
        @DisplayName("Testing if isValidWeatherOptions allows valid strings")
        void testIfIsValidWeatherOptionAllowsValidStrings(String weather){
            weatherDTO.setMain(weather);
            Assertions.assertTrue(weatherDTO.isValidWeatherOption());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Hail", "Sleet"})
        @DisplayName("Testing if isValidWeatherOptions rejects invalid strings")
        void testIfIsValidWeatherOptionsRejectsInvalidStrings(String weather){
            weatherDTO.setMain(weather);
            Assertions.assertFalse(weatherDTO.isValidWeatherOption());
        }

        @ParameterizedTest
        @ValueSource(strings = {"scattered clouds", "rain", "shower rain"})
        @DisplayName("Testing if isValidDescription allows valid strings")
        void testIfIsValidDescriptionAllowsValidStrings(String weather){
            weatherDTO.setDescription(weather);
            Assertions.assertTrue(weatherDTO.isValidDescription());
        }

        @ParameterizedTest
        @ValueSource(strings = {"cloudy rain", "hail", "shower sleet"})
        @DisplayName("Testing if isValidDescription rejects invalid strings")
        void testIfIsValidDescriptionRejectsInvalidStrings(String weather){
            weatherDTO.setDescription(weather);
            Assertions.assertFalse(weatherDTO.isValidDescription());
        }

        @ParameterizedTest
        @ValueSource(strings = {"01d", "04d", "50d","03n", "04n", "09n"})
        @DisplayName("Testing if isValidIcon accepts valid strings")
        void testIfIsValidIconAcceptsValidStrings(String weather){
            weatherDTO.setIcon(weather);
            Assertions.assertTrue(weatherDTO.isValidIcon());
        }

        @ParameterizedTest
        @ValueSource(strings = {"22d", "49d", "40n", "110n"})
        @DisplayName("Testing if isValidIcon accepts valid strings")
        void testIfIsValidIconRejectsInvalidStrings(String weather){
            weatherDTO.setIcon(weather);
            Assertions.assertFalse(weatherDTO.isValidIcon());
        }

        @Test
        @DisplayName("Test Weather Object Accepts Valid Object")
        void testIfValidObjectIsAccepted(){
            Assertions.assertTrue(exampleWeatherObject.isValidWeatherObject());
        }

        @Test
        @DisplayName("Test Weather Object rejects an invalid ID")
        void testIfValidObjectIDIsRejected(){
            exampleWeatherObject.setId(100);
            Assertions.assertFalse(exampleWeatherObject.isValidWeatherObject());
        }

        @Test
        @DisplayName("Test Weather Object rejects an invalid Main")
        void testIfValidObjectNameIsRejected(){
            exampleWeatherObject.setMain("Wrong Temp");
            Assertions.assertFalse(exampleWeatherObject.isValidWeatherObject());
        }

        @Test
        @DisplayName("Test Weather Object rejects an invalid Description")
        void testIfValidObjectDescriptionIsRejected(){
            exampleWeatherObject.setDescription("Wrong Temp");
            Assertions.assertFalse(exampleWeatherObject.isValidWeatherObject());
        }

        @Test
        @DisplayName("Test Weather Object rejects an invalid Icon")
        void testIfValidObjectIconIsRejected(){
            exampleWeatherObject.setIcon("100b");
            Assertions.assertFalse(exampleWeatherObject.isValidWeatherObject());
        }
    }
}
