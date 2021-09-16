package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class CloudsDTOTest {

    CloudsDTO cloudsDTO;

    @BeforeEach
    void setup(){
        cloudsDTO = new CloudsDTO();
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

    }

}
