package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeatherDTOTest {
    WeatherDTO weatherDTO;

    @BeforeEach
    void setup(){
        weatherDTO = new WeatherDTO();
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
        @Disabled
        @DisplayName("Testing id is the correct data type")
        void testIdIsInteger(){
            Assertions.assertEquals(Integer.class, weatherDTO.getId().getClass());
        }

        @Test
        @Disabled
        @DisplayName("Testing main is the correct data type")
        void testMainIsString(){
            Assertions.assertEquals(String.class, weatherDTO.getMain().getClass());
        }

        @Test
        @Disabled
        @DisplayName("Testing description is the correct data type")
        void testDescriptionIsString(){
            Assertions.assertEquals(String.class, weatherDTO.getDescription().getClass());
        }

        @Test
        @Disabled
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
        void testIfValidWeatherOptionAllowsValidStrings(String weather){
            Assertions.assertTrue(weatherDTO.isValidWeatherOption(weather));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Hail", "Sleet"})
        @DisplayName("Testing if isValidWeatherOptions rejects invalid strings")
        void testIfValidWeatherOptionsRejectsInvalidStrings(String weather){
            Assertions.assertFalse(weatherDTO.isValidWeatherOption(weather));
        }

    }
}
