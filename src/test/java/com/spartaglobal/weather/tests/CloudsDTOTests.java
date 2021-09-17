package com.spartaglobal.weather.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.weather.ConnectionManager;
import com.spartaglobal.weather.Injector;
import com.spartaglobal.weather.dto.CloudsDTO;
import com.spartaglobal.weather.dto.ProjectDTO;
import com.spartaglobal.weather.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;


public class CloudsDTOTests {

    private CloudsDTO cloudsDTO;
    private ProjectDTO projectDTO;

    @BeforeEach
    void setup(){
        projectDTO = Injector.injectDTO(ConnectionManager.getURL("London",  PropertiesLoader.getProperties().getProperty("APIKey")));
        cloudsDTO = projectDTO.getClouds();
    }


    @Nested
    @DisplayName("Testing the percentage boundaries")
    class PercentageBoundaries {

        @ParameterizedTest
        @DisplayName("Testing the out of bounds percentage boundaries")
        @ValueSource(ints = {-1, 101})
        void testPercentageOutOfBounds(int percentages) {
            Assertions.assertFalse(cloudsDTO.isPercentWithinBoundaries(percentages));
        }

        @ParameterizedTest
        @DisplayName("Testing the in bounds percentage boundaries")
        @ValueSource(ints = {0, 100})
        void testPercentageInBounds(int percentages) {
            Assertions.assertTrue(cloudsDTO.isPercentWithinBoundaries(percentages));
        }
    }

    @Nested
    @DisplayName("Testing data types")
    class TestDataTypes{

        @Test
        @DisplayName("Testing the boundaries return data type")
        void testBoolean(){
            Assertions.assertEquals(Boolean.class, cloudsDTO.isPercentWithinBoundaries(0).getClass());
        }

        @Test
        @DisplayName("Testing the percentage return data type")
        void testInteger(){
            Assertions.assertEquals(Integer.class, cloudsDTO.getAll().getClass());
        }

    @Nested
    @DisplayName("Testing the value is not null or empty")
    class TestValueIsNotEmptyOrNull{

            @Test
            @DisplayName("Test the value is not empty")
            void testValueIsNotEmpty(){
                Assertions.assertNotEquals("",cloudsDTO.getAll().toString());
            }

            @Test
            @DisplayName("Test the value is not null")
            void testValueIsNotNull(){
                Assertions.assertNotNull(cloudsDTO.getAll());
            }
    }

    }

}
