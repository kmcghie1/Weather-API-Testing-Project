package com.spartaglobal.weather.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class WindDTOTest
{
    WindDTO windDTO;
    WindDTO mockWindDTO;
    @BeforeEach
    void setup(){
        windDTO = new WindDTO();
        mockWindDTO = Mockito.mock(WindDTO.class);
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
        void testSpeedHasAValue() {
            Mockito.when(mockWindDTO.getSpeed()).thenReturn(2.53);
            Assertions.assertNotNull(mockWindDTO.getSpeed());
        }
        @Test
        @DisplayName("Test Degree has a value")
        void testDegHasAValue() {
            Mockito.when(mockWindDTO.getDeg()).thenReturn(20);
            Assertions.assertNotNull(mockWindDTO.getDeg());
        }
    }

    @Nested
    @DisplayName("Data type")
    class dataTypeTests{
        @Test
        @DisplayName("Testing Degree is Integer")
        void testDegIsInteger(){
            Mockito.when(mockWindDTO.getDeg()).thenReturn(20);
            Assertions.assertEquals(Integer.class, mockWindDTO.getDeg().getClass());
        }

        @Test
        @DisplayName("Testing Speed is Double")
        void testSpeedIsDouble(){
            Mockito.when(mockWindDTO.getSpeed()).thenReturn(2.24);
            Assertions.assertEquals(Double.class, mockWindDTO.getSpeed().getClass());
        }

        @Test
        @DisplayName("Testing Gust is Double")
        void testGustIsDouble(){
            Mockito.when(mockWindDTO.getGust()).thenReturn(2.54);
            Assertions.assertEquals(Double.class, mockWindDTO.getGust().getClass());
        }
    }

}
