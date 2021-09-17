package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WindDTOTest
{
    WindDTO windDTO = new WindDTO();

    @BeforeEach
    void setup(){
        windDTO = new WindDTO();
    }

    @Nested
    @DisplayName("Testing Limits")
    class limitTesting{
        @ParameterizedTest
        @DisplayName("Testing that the speed is always above 0")
        @ValueSource(ints = {-1 , 0})
        void testSpeedLowerThanZero(double values) {
            Assertions.assertFalse(windDTO.isGreaterThanZero(values));
        }

        @ParameterizedTest
        @DisplayName("Testing the Degree is out of Bounds")
        @ValueSource(ints = {-1,360})
        void testDegreeOutOfBoundaries(int values) {
            Assertions.assertFalse(windDTO.isWithinLimits(values));
        }

        @ParameterizedTest
        @DisplayName("Testing the Degree Boundaries")
        @ValueSource(ints = {0, 30 ,359})
        void testDegreeInBoundaries(int values) {
            Assertions.assertTrue(windDTO.isWithinLimits(values));
        }
    }

    @Nested
    @DisplayName("Testing getters")
    class getterTests {
        @Test
        @DisplayName("Test Speed has a value")
        void testLonHasAValue() {
            Assertions.assertNotNull(windDTO.getSpeed());
        }
        @Test
        @DisplayName("Test Degree has a value")
        void testDegHasAValue() {
            Assertions.assertNotNull(windDTO.getDeg());
        }
    }

    @Nested
    @DisplayName("Data type")
    class dataTypeTests{
        @Test
        @DisplayName("Testing Degree is Integer")
        void testDegIsInteger(){
            Assertions.assertEquals(Integer.class, windDTO.getDeg().getClass());
        }

        @Test
        @DisplayName("Testing Speed is Double")
        void testSpeedIsDouble(){
            Assertions.assertEquals(Double.class, windDTO.getDeg().getClass());
        }
    }

}
