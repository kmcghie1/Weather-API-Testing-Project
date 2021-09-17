package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;

public class WeatherDTOTest {
    WeatherDTO weatherDTO;

    @BeforeEach
    void setup(){
        weatherDTO = new WeatherDTO();
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
}
